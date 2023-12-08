package edu.project4;

public class Pixel {
    int red;
    int green;
    int blue;
    int count;
    double normal;

    public void incrementCount() {
        this.count++;
    }

    public void plusRed(int red) {
        this.red = (this.red + red) / 2;
    }

    public void plusGreen(int green) {
        this.green = (this.green + green) / 2;
    }

    public void plusBlue(int blue) {
        this.blue = (this.blue + blue) / 2;
    }

    public void plusCount(int count) {
        this.count += count;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getNormal() {
        return normal;
    }

    public void setNormal(double normal) {
        this.normal = normal;
    }

    public Pixel(int red, int green, int blue, int count, double normal) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.count = count;
        this.normal = normal;
    }
}
