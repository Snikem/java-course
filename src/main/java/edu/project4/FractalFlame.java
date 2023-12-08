package edu.project4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import static java.lang.Math.log10;
import static java.lang.Math.pow;

public class FractalFlame {
    private final static Logger LOGGER = LogManager.getLogger();
    Random random;
    int xResolution = 1980;
    int yResolution = 1080;

    private BufferedImage image;
    int[][] countPixels;
    double[][] normal;

    private void safeImage() {
        Graphics2D g2d = image.createGraphics();
        File output = new File("output.png");

        try {
            // write the BufferedImage to the file using ImageIO.write()
            ImageIO.write(image, "png", output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FractalFlame(int seed) {
        image = new BufferedImage(xResolution, yResolution, BufferedImage.TYPE_INT_RGB);
        countPixels = new int[xResolution][yResolution];
        for (int i = 0; i < countPixels.length; i++) {
            for (int j = 0; j < countPixels[i].length; j++) {
                countPixels[i][j] = 0;
            }
        }
        normal = new double[xResolution][yResolution];
        for (int i = 0; i < normal.length; i++) {
            for (int j = 0; j < normal[i].length; j++) {
                normal[i][j] = 0.0;
            }
        }
        random = new Random(seed);
        render(4, 20, 10000000, xResolution, yResolution);
        correction(xResolution,yResolution);
        safeImage();

    }
    private double sinusReformationX(double x, double y) {
        return Math.sin(x);
    }

    private double sinusReformationY(double x, double y) {
        return Math.sin(y);
    }
    private double sphereReformationX(double x, double y) {
        return x / (x*x + y*y);
    }

    private double sphereReformationY(double x, double y) {
        return  y / (x*x + y*y);
    }

    private double polarReformationX(double x, double y) {
        return Math.atan(y / x) / Math.PI;
    }

    private double polarReformationY(double x, double y) {
        return Math.sqrt(x * x + y * y) - 1;
    }

    public List<Coefficient> generateCoef(int size) {
        double a, b, c, d, e, f;
        int red, green, blue;
        List<Coefficient> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            a = random.nextDouble(-1, 1);
            d = random.nextDouble(-Math.sqrt(1 - a * a), Math.sqrt(1 - a * a));
            b = random.nextDouble(-1, 1);
            e = random.nextDouble(-Math.sqrt(1 - b * b), Math.sqrt(1 - b * b));
            while ((a * a + b * b + d * d + e * e) < (1 + (a * e - b * d) * (a * e - b * d))) {
                a = random.nextDouble(-1, 1);
                d = random.nextDouble(-Math.sqrt(1 - a * a), Math.sqrt(1 - a * a));
                b = random.nextDouble(-1, 1);
                e = random.nextDouble(-Math.sqrt(1 - b * b), Math.sqrt(1 - b * b));
            }
            c = random.nextDouble(-1.5, 1.5);
            f = random.nextDouble(-1.5, 1.5);
            red = random.nextInt(0, 256);
            green = random.nextInt(0, 256);
            blue = random.nextInt(0, 256);
            list.add(new Coefficient(a, b, c, d, e, f, red, green, blue));
        }

        return list;

    }

    void correction(int xRes, int yRes) {
        double max = 0.0;
        double gamma = 2.2;
        Color imageColor;
        for (int row = 0; row < xRes; row++) {
            for (int col = 0; col < yRes; col++) {
                if (countPixels[row][col] != 0) {
                    normal[row][col] = log10((double) (countPixels[row][col]));
                    if (normal[row][col] > max) {
                        max = normal[row][col];
                    }
                }
            }
        }
        for (int row = 0; row < xRes; row++) {
            for (int col = 0; col < yRes; col++) {

                normal[row][col] /= max;
                imageColor = new Color(image.getRGB(row, col));
                Color temp = new Color( (int)(imageColor.getRed() * pow(normal[row][col],(1.0 / gamma))),
                    (int)(imageColor.getGreen() * pow(normal[row][col],(1.0 / gamma))),
                    (int)(imageColor.getBlue() * pow(normal[row][col],(1.0 / gamma)))
                );
                image.setRGB(row, col, temp.getRGB());
            }
        }
    }

    public void render(int n, int eqCount, int it, int xRes, int yRes) {
        double x, y, xMIN, xMAX, yMIN, yMAX, newX, newY;
        int x1, y1;
        int i;
        double cff;
        Color imageColor;
        Color color;
        List<Coefficient> listCoef = generateCoef(eqCount);
        for (int num = 0; num < n; num++) {
            cff = Math.round(Double.valueOf(xRes) / Double.valueOf(yRes) * 10000d) / 10000d;
            xMIN = -cff;
            xMAX = cff;
            yMIN = -1;
            yMAX = 1;
            newX = random.nextDouble(xMIN, xMAX);
            newY = random.nextDouble(yMIN, yMAX);
            for (int step = -20; step < it; step++) {
                i = random.nextInt(0, eqCount);
                x = listCoef.get(i).a() * newX + listCoef.get(i).b() * newY + listCoef.get(i).c();
                y = listCoef.get(i).d() * newX + listCoef.get(i).e() * newY * listCoef.get(i).f();
                newX = sphereReformationX(x, y);
                newY = sphereReformationY(x, y);
                if (step >= 0 && (newX >= xMIN && newX <= xMAX) && (newY >= yMIN && newY <= yMAX)) {
                    x1 = xRes - (int)(((xMAX - newX) / (xMAX - xMIN)) * xRes);
                    y1 = yRes - Double.valueOf(((yMAX - newY) / (yMAX - yMIN)) * yRes).intValue();
                    //LOGGER.info(y1);
                    if (x1 < xRes && y1 < yRes) {
                        color = new Color(listCoef.get(i).red(), listCoef.get(i).green(), listCoef.get(i).blue());
                        if (countPixels[x1][y1] == 0) {
                            image.setRGB(x1, y1, color.getRGB());
                        } else {
                            imageColor = new Color(image.getRGB(x1, y1));
                            Color temp = new Color((imageColor.getRed() + color.getRed()) / 2,
                                (imageColor.getGreen() + color.getGreen()) / 2,
                                (imageColor.getBlue() + color.getBlue()) / 2
                            );
                            image.setRGB(x1, y1, temp.getRGB());
                        }
                        countPixels[x1][y1]++;
                    }

                }
            }
        }

    }

}
