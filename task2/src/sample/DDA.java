package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DDA implements PixelsDrawer{

    private  float x1;
    private final float x2;
    private  float y1;
    private final float y2;

    public DDA(Group group, float x1, float y1, float x2, float y2, Color color) {
        if (x1 < x2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
        else {
            this.x1 = x2;
            this.x2 = x1;
            this.y1 = y2;
            this.y2 = y1;
        }
        Draw(group, color);
    }

    @Override
    public void Draw(Group group, Color color){
        float Px= x2 - x1;
        float Py= y2 - y1;
        float N = Math.max(Math.abs(Px), Math.abs(Py));
        PutPixel (group, x1, y1, color);
        while (x1 != x2 && y1 != y2) {
            x1 += Px / N;
            y1 += Py/Px;
            PutPixel (group, x1, y1, color);
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
