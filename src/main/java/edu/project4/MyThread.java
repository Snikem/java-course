package edu.project4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings({"MagicNumber"})
public class MyThread extends Thread {
    Random random;
    int xResolution;
    int yResolution;
    int eqCount;
    int it;
    int strokes;
    List<Coefficient> listCoef;
    Pixel[][] pixels;

    public MyThread(
        List<Coefficient> coef,
        int eqCount,
        int it,
        int xResolution,
        int yResolution,
        int seed,
        int strokes
    ) {
        pixels = new Pixel[xResolution][yResolution];
        this.strokes = strokes;

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                pixels[i][j] = new Pixel(0, 0, 0, 0, 0);
            }
        }
        random = new Random(seed + Thread.currentThread().threadId());
        listCoef = new ArrayList<Coefficient>(coef);
        this.eqCount = eqCount;
        this.it = it;
        this.xResolution = xResolution;
        this.yResolution = yResolution;
    }

    private double sinusReformationX(double x, double y) {
        return Math.sin(x);
    }

    private double sinusReformationY(double x, double y) {
        return Math.sin(y);
    }

    private double polarReformationX(double x, double y) {
        return Math.atan(y / x) / Math.PI;
    }

    private double polarReformationY(double x, double y) {
        return Math.sqrt(x * x + y * y) - 1;
    }

    private double sphereReformationX(double x, double y) {
        return x / (x * x + y * y);
    }

    private double sphereReformationY(double x, double y) {
        return y / (x * x + y * y);
    }

    @Override
    public void run() {
        double x;
        double y;
        double xMIN;
        double xMAX;
        double yMIN;
        double yMAX;
        double newX;
        double newY;
        int x1;
        int y1;
        int i;
        double cff;
        cff = Math.round(Double.valueOf(xResolution) / Double.valueOf(yResolution) * 10000d) / 10000d;
        xMIN = -cff;
        xMAX = cff;
        yMIN = -1;
        yMAX = 1;
        for (int num = 0; num < strokes; num++) {
            newX = random.nextDouble(xMIN, xMAX);
            newY = random.nextDouble(yMIN, yMAX);
            for (int step = -20; step < it; step++) {
                i = random.nextInt(0, eqCount);
                x = listCoef.get(i).a() * newX + listCoef.get(i).b() * newY + listCoef.get(i).c();
                y = listCoef.get(i).d() * newX + listCoef.get(i).e() * newY * listCoef.get(i).f();
                newX = sphereReformationX(x, y);
                newY = sphereReformationY(x, y);
                if (step >= 0 && (newX >= xMIN && newX <= xMAX) && (newY >= yMIN && newY <= yMAX)) {
                    x1 = xResolution - (int) (((xMAX - newX) / (xMAX - xMIN)) * xResolution);
                    y1 = yResolution - Double.valueOf(((yMAX - newY) / (yMAX - yMIN)) * yResolution).intValue();
                    if (x1 < xResolution && y1 < yResolution) {
                        if (pixels[x1][y1].count == 0) {
                            pixels[x1][y1].setRed(listCoef.get(i).red());
                            pixels[x1][y1].setGreen(listCoef.get(i).green());
                            pixels[x1][y1].setBlue(listCoef.get(i).blue());
                        } else {
                            pixels[x1][y1].plusRed(listCoef.get(i).red());
                            pixels[x1][y1].plusGreen(listCoef.get(i).green());
                            pixels[x1][y1].plusBlue(listCoef.get(i).blue());
                        }
                        pixels[x1][y1].incrementCount();
                    }

                }
            }
        }

    }

    public Pixel[][] getPixels() {
        return pixels;
    }
}
