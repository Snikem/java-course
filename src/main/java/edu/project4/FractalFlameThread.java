package edu.project4;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static java.lang.Math.log10;
import static java.lang.Math.pow;

@SuppressWarnings({"MagicNumber"})
public class FractalFlameThread {
    private final static Logger LOGGER = LogManager.getLogger();
    Random random;
    int xResolution = 1980;
    int yResolution = 1080;
    private BufferedImage image;
    int seed;
    int numberOfThreads;
    Pixel[][] pixels;
    MyThread[] threads;
    int[] strokesForThread;
    int strokesCopy;

    public List<Coefficient> generateCoef(int size) {
        double a;
        double b;
        double c;
        double d;
        double e;
        double f;
        int red;
        int green;
        int blue;
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

    public FractalFlameThread(int seed, int numberOfThreads, int strokes) {
        this.numberOfThreads = numberOfThreads;
        this.seed = seed;
        random = new Random();
        strokesCopy = strokes;
        strokesForThread = new int[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            strokesForThread[i] = 0;
        }
        int indexThread = numberOfThreads - 1;
        while (strokesCopy != 0) {
            strokesForThread[indexThread]++;
            indexThread--;
            strokesCopy--;
            if (indexThread == -1) {
                indexThread = numberOfThreads - 1;
            }
        }
        pixels = new Pixel[xResolution][yResolution];
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                pixels[i][j] = new Pixel(0, 0, 0, 0, 0);
            }
        }
        threads = new MyThread[numberOfThreads];
    }

    public void start() {
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] =
                new MyThread(generateCoef(20), 20, 100000000, xResolution, yResolution, seed, strokesForThread[i]);
            threads[i].start();
        }
        for (int i = 0; i < numberOfThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        saveToMainPixels(numberOfThreads);
        correction();

        image = new BufferedImage(xResolution, yResolution, BufferedImage.TYPE_INT_RGB);
        for (int row = 0; row < xResolution; row++) {
            for (int col = 0; col < yResolution; col++) {
                image.setRGB(
                    row,
                    col,
                    new Color(
                        pixels[row][col].getRed(),
                        pixels[row][col].getGreen(),
                        pixels[row][col].getBlue()
                    ).getRGB()
                );

            }
        }
        safeImage();
    }

    void saveToMainPixels(int numberOfThreads) {
        Pixel[][] pixelsFromThread;
        for (int h = 0; h < numberOfThreads; h++) {
            pixelsFromThread = threads[h].getPixels();
            for (int i = 0; i < pixels.length; i++) {
                for (int j = 0; j < pixels[i].length; j++) {
                    pixels[i][j].plusRed(pixelsFromThread[i][j].getRed());
                    pixels[i][j].plusGreen(pixelsFromThread[i][j].getGreen());
                    pixels[i][j].plusBlue(pixelsFromThread[i][j].getBlue());
                    pixels[i][j].plusCount(pixelsFromThread[i][j].getCount());
                }
            }

        }
    }

    void correction() {
        double max = 0.0;
        double gamma = 2.2;
        for (int row = 0; row < xResolution; row++) {
            for (int col = 0; col < yResolution; col++) {
                if (pixels[row][col].count != 0) {
                    pixels[row][col].setNormal(log10((double) (pixels[row][col].count)));
                    if (pixels[row][col].getNormal() > max) {
                        max = pixels[row][col].getNormal();
                    }
                }
            }
        }

        for (int row = 0; row < xResolution; row++) {
            for (int col = 0; col < yResolution; col++) {

                pixels[row][col].setNormal(pixels[row][col].getNormal() / max);
                pixels[row][col].setRed((int) (pixels[row][col].getRed()
                    * pow(pixels[row][col].getNormal(), (1.0 / gamma))));
                pixels[row][col].setGreen((int) (pixels[row][col].getGreen()
                    * pow(pixels[row][col].getNormal(), (1.0 / gamma))));
                pixels[row][col].setBlue((int) (pixels[row][col].getBlue()
                    * pow(pixels[row][col].getNormal(), (1.0 / gamma))));

            }
        }
    }

    private void safeImage() {
        Graphics2D g2d = image.createGraphics();
        File output = new File("output.png");

        try {
            // write the BufferedImage to the file using ImageIO.write()
            ImageIO.write(image, "png", output);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
    }
}
