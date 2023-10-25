package edu.hw2.task2;

public class Square extends Rectangle implements edu.hw2.task2.interfaces.Square {
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
    }

    @Override
    public int getWidth() {
        return super.getWidth();
    }

    @Override
    public void setSquareSide(int squareSide) {
        super.setWidth(squareSide);
        super.setHeight(squareSide);
    }

    @Override
    public double getSquareSide() {
        return Math.sqrt(super.area());
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
    }

}
