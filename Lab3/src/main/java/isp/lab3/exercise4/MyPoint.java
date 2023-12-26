package isp.lab3.exercise4;

import isp.lab3.exercise3.Vehicle;

import java.awt.*;

public class MyPoint {
    private int x,y,z;

    public MyPoint() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public MyPoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void setXYZ(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public double distance(int x, int y, int z){
        int distX = this.x - x;
        int distY = this.y - y;
        int distZ = this.z - z;

        return Math.sqrt(distX * distX + distY * distY+ distZ * distZ);
    }

    public double distance(MyPoint another){
        return distance(another.getX(), another.getY(), another.getZ());

    }

    public static void main(String[] args) {
        MyPoint point1 = new MyPoint(1,2,3);
        MyPoint point2 = new MyPoint(2,3,4);

        System.out.println(point1.distance(point2));
    }

}
