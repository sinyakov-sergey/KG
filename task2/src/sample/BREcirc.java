package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BREcirc implements PixelsDrawer{
    private final int xc;
    private final int yc;
    private final int pixel;
    private final int r;

    public BREcirc(Group group,int xc, int yc, int r, int pixel, Color color) {
        this.xc = xc;
        this.yc = yc;
        this.pixel = pixel;
        this.r = r;
        Draw(group, color);
    }

    @Override
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
        putpixel(group,xc1+y, yc1+x, pixel, color);
        putpixel(group,xc1+y, yc1-x, pixel, color);
        putpixel(group,xc1+x, yc1-y, pixel, color);
        putpixel(group,xc1-x, yc1-y, pixel, color);
        putpixel(group,xc1-y, yc1-x, pixel, color);
        putpixel(group,xc1-y, yc1+x, pixel, color);
        putpixel(group,xc1-x, yc1+y, pixel, color);
      //  BRE bre1 = new BRE(group,xc1+x, xc, yc1 + y, yc, color);
//        BRE bre2 = new BRE(group,xc1+x, xc, yc1 - y, yc, color);
        BRE bre3 = new BRE(group,xc1-x, xc, yc1 - y, yc, color);
        BRE bre4 = new BRE(group,xc1-x, xc, yc1 + y, yc, color);
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
