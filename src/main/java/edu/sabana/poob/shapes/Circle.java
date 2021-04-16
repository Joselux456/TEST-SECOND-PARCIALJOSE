package edu.sabana.poob.shapes;

public class Circle extends Shape {

    private double radius;
    private static final double PI = 3.141;

    public Circle() {
        this.radius = 1.0;
    }

    @Override
    public double getArea() {
        double Area = Math.round(PI*Math.pow(this.radius,2));
        return (int) Area;
    }

    @Override
    public double getPerimeter() {
        double result = (2*PI)*this.radius;
        return (int) result;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double getDiameter() {
        return this.radius*2;
    }

    @Override
    public String toString() {
        String result = " ";
        if((int) this.radius == this.radius) result = Integer.toString((int) this.radius);
        else
            result = Double.toString(this.radius);
        return super.toString()+ String.format(" and radius %s", result);
    }
}
