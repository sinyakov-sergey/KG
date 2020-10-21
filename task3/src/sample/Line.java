package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Line {
    public final float x1;
    public final float x2;
    public final float y1;
    public final float y2;

    public Line(Group group, float x1, float x2, float y1, float y2, Color color) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        Draw(group, color);
    }

    private float sign (float x) {
        return (x > 0) ? 1 : (x < 0) ? -1 : 0;
        //возвращает 0, если аргумент (x) равен нулю; -1, если x < 0 и 1, если x > 0.
    }

    public void Draw(Group group, Color color){
        float x, y, dx, dy, incx, incy, pdx, pdy, es, el, err;
        dx = x2 - x1;
        dy = y2 - y1;
        incx = sign(dx);
        incy = sign(dy);
        if (dx < 0) dx = -dx;
        if (dy < 0) dy = -dy;
        if (dx > dy) {
            pdx = incx;
            pdy = 0;
            es = dy;
            el = dx;
        }
        else {
            pdx = 0;
            pdy = incy;
            es = dx;
            el = dy;
        }
        x = x1;
        y = y1;
        err = el/2;
        PutPixel(group, x, y, color);
        for (int t = 0; t < el; t++) {
            err -= es;
            if (err < 0){
                err += el;
                x += incx;
                y += incy;
            }
            else {
                x += pdx;
                y += pdy;
            }
            PutPixel(group, x, y, color);
        }
    }

    private void PutPixel(Group group, float x1, float y1, Color color){
        Rectangle rectangle = new Rectangle();
        rectangle.setX(x1);
        rectangle.setY(y1);
        rectangle.setWidth(1);
        rectangle.setHeight(1);
        rectangle.setFill(color);
        group.getChildren().add(rectangle);
    }
}
