package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BREarca implements PixelsDrawer{
    private final int x;
    private final int y;
    private final int a;
    private final int b;


    public BREarca(Group group, int x, int y, int a, int b, Color color) {
        this.x = x;
        this.y = y;
        this.a = a;
        this.b = b;
        Draw(group, color);
    }

    @Override
    public void Draw(Group group, Color color) {
        int x1 = 0;
        int y1 = b;
        int a_sqr = a * a;
        int b_sqr = b * b;
        int delta = 4 * b_sqr * ((x1 + 1) * (x1 + 1)) + a_sqr * ((2 * y1 - 1) * (2 * y1 - 1)) - 4 * a_sqr * b_sqr;
        while (a_sqr * (2 * y1 - 1) > 2 * b_sqr * (x1 + 1)){
            Pixel_circle(group, x, y, x1, y1, 1, color);
            if (delta < 0){
                x1++;
                delta += 4 * b_sqr * (2 * x1 + 3);
            }
            else {
                x1++;
                delta = delta - 8 * a_sqr * (y1 - 1) + 4 * b_sqr * (2 * x1 + 3);
                y1--;
            }
        }
        delta = b_sqr * ((2 * x1 + 1) * (2 * x1 + 1)) + 4 * a_sqr * ((y1 + 1) * (y1 + 1)) - 4 * a_sqr * b_sqr;
        while (y1 + 1 != 0){
            Pixel_circle(group, x, y, x1, y1, 1, color);
            if (delta < 0) // Переход по вертикали
            {
                y1--;
                delta += 4 * a_sqr * (2 * y1 + 3);
            }
            else {
                y1--;
                delta = delta - 8 * b_sqr * (x1 + 1) + 4 * a_sqr * (2 * y1 + 3);
                x1++;
            }
        }
    }

    private void Pixel_circle (Group group, int xc, int yc, int x1, int y1, int pixel, Color color){
        //putpixel(group,xc+x1, yc+y1, pixel, color);
        //BRE bre1 = new BRE(group,xc+x1, x, yc + y1, y, color);
        putpixel(group,xc+x1, yc-y1, pixel, color);
       // BRE bre2 = new BRE(group,xc+x1, x, yc - y1, y, color);
        putpixel(group,xc-x1, yc-y1, pixel, color);
       // BRE bre3 = new BRE(group,xc-x1, x, yc - y1, y, color);
        //putpixel(group,xc-x1, yc+y1, pixel, color);
        //BRE bre4 = new BRE(group,xc-x1, x, yc + y1, y, color);
    }

    private void putpixel(Group group,int x, int y, int pixel, Color color){
        Rectangle rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setWidth(pixel);
        rectangle.setHeight(pixel);
        rectangle.setFill(color);
        group.getChildren().add(rectangle);
    }
}
