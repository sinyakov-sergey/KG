package sample;


import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Star {

    private double degree;
    private Circle circle;
    private double length;
    private double cx;
    private double cy;
    private int b = 1;


    public Star(double degree) {
        this.degree =  -degree;
        do {
            this.length = Math.random() * 360;
            cx = length * Math.cos(-degree * Math.PI/180);
            cy = length * Math.sin(-degree * Math.PI/180);
        } while (cy > 205 || cy < - 200);
        this.circle = new Circle(cx, cy,Math.random() * 2);
        circle.setFill(Color.WHITE);
    }

    public void setLength(double length, int c) {
        this.length = length;
        double ex = length * Math.cos(degree * Math.PI / 180);
        double ey = length * Math.sin(degree * Math.PI / 180);
        cx = ex;
        cy = ey;
        circle.setCenterX(cx);
        circle.setCenterY(cy);
        if (c != 0) this.check();
    }

    public double getLength() {
        return length;
    }

    public double getDegree() {
        return degree;
    }

    private void check(){
        if (b == 1){
            if (cx < -360 || cx > 360 || cy < -205 || cy > 200){
                this.setLength(0, 1);
            }
        }
        else {
            if (cx == 0 || cy == 0){
                this.setLength(360, 0);
            }
        }
    }

    public Circle getCircle() {
        return circle;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
