package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Square {
    private final int radius;
    private final int x;
    private final int y;

    public Square(Group group, int radius, int x, int y) {
        this.radius = 2 * radius;
        this.x = x - radius;
        this.y = y - radius;
        Draw(group);
    }

    public void Draw(Group group){
       // Circle circle1 = new Circle(group, 10, x, y, 1, Color.BLACK);
        Circle circle2 = new Circle(group, 10, x + radius, y, 1, Color.BLACK);
       // Circle circle3 = new Circle(group, 10, x, y + radius, 1, Color.BLACK);
       // Circle circle4 = new Circle(group, 10, x + radius, y + radius, 1, Color.BLACK);
        Line line1 = new Line(group, x, x, y, y + radius, Color.BLACK);
        Line line2 = new Line(group, x + radius, x + radius, y, y + radius, Color.BLACK);
        Line line3 = new Line(group, x, x + radius, y + radius, y + radius, Color.BLACK);
        Line line4 = new Line(group, x, x + radius, y, y, Color.BLACK);
    }
}
