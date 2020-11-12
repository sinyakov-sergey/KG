package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Flatness {
    private final double weight;
    private final Color color;

    public Flatness(Group group, double weight, Color color){
        this.weight = weight;
        this.color = color;
        draw(group);
    }

    private void draw(Group group){
        Rectangle rectangle = new Rectangle(weight, weight);
        rectangle.setFill(color);
        group.getChildren().add(rectangle);
    }
}
