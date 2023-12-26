package isp.lab3.exercise2;

import isp.lab3.exercise1.Tree;

public class Rectangle {
    private int width;
    private int length;
    private String color;

    public Rectangle() {
        this.width = 2;
        this.length = 1;
        this.color = "red";
    }

    public Rectangle(int l,int w)
    {
        this.length=l;
        this.width=w;
    }

    public Rectangle(int l,int w,String color)
    {
        this.length=l;
        this.width=w;
        this.color=color;
    }

    public int getLength() {
        return length;
    }

    public String getColor() {
        return color;
    }

    public int getWidth() {
        return width;
    }

    public int getPerimeter() {
        return 2*width+2*length;
    }

    public int getArea() {
        return width*length;
    }

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(3,5,"purple");
        System.out.println(rectangle1.getWidth());
        System.out.println(rectangle1.getLength());
        System.out.println(rectangle1.getColor());
        System.out.println(rectangle1.getArea());
        System.out.println(rectangle1.getPerimeter());
    }

}
