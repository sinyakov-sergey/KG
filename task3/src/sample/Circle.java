package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Circle {
    private final int xc;
    private final int yc;
    private final int pixel;
    private final int r;

    public Circle(Group group, int r, int x, int y, int pixel, Color color) {
        this.xc = x;
        this.yc = y;
        this.pixel = pixel;
        this.r = r;
        Draw(group, color);
    }

    public void Draw(Group group, Color color) {
        int x = 0;
        int y= r;
        int d= 3 - 2*r;
        while (x < y) {
            Pixel_circle (group, xc, yc, x, y, pixel, color);
            if (d < 0) d= d + 4*x + 6;
            else {
                d= d + 4*(x-y) + 10;
                --y;
            }
            ++x;
        }
        if (x == y) Pixel_circle (group, xc, yc, x, y, pixel, color);
    }

    private void Pixel_circle (Group group, int xc1, int yc1, int x, int y, int pixel, Color color){
        putpixel(group,xc1+x, yc1+y, pixel, color);
        Line line1 = new Line(group,xc1+x,xc1-x,yc1+y, yc1+y,color);
        putpixel(group,xc1+y, yc1+x, pixel, color);
        Line line2 = new Line(group,xc1+y,xc1-y,yc1+x, yc1+x,color);
        putpixel(group,xc1+y, yc1-x, pixel, color);
        Line line3 = new Line(group,xc1+y,xc1-y,yc1-x, yc1-x,color);
        putpixel(group,xc1+x, yc1-y, pixel, color);
        Line line4 = new Line(group,xc1+x,xc1-x,yc1-y, yc1-y,color);
        putpixel(group,xc1-x, yc1-y, pixel, color);
        putpixel(group,xc1-y, yc1-x, pixel, color);
        putpixel(group,xc1-y, yc1+x, pixel, color);
        putpixel(group,xc1-x, yc1+y, pixel, color);
    }

    private void putpixel(Group group,int x, int y, int pixel,Color color){
        Rectangle rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setWidth(pixel);
        rectangle.setHeight(pixel);
        rectangle.setFill(color);
        group.getChildren().add(rectangle);
    }
}
