package sample;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.transform.Rotate;

public class Camera {

    private double anchorX, anchorY;
    private double anchorAngelX = 0;
    private double anchorAngelY = 0;
    private final DoubleProperty angelX = new SimpleDoubleProperty(0);
    private final DoubleProperty angelY = new SimpleDoubleProperty(0);

    public Camera(Group group) {
        initMouseControl(group);
    }

    public void initMouseControl(Group group){
        Rotate xRotate;
        Rotate yRotate;
        group.getTransforms().addAll(
                xRotate = new Rotate(0, Rotate.X_AXIS),
                yRotate = new Rotate(0, Rotate.Y_AXIS)
        );
        xRotate.angleProperty().bind(angelX);
        yRotate.angleProperty().bind(angelY);

        group.setOnMousePressed(event -> {
            anchorX = event.getSceneX();
            anchorY = event.getSceneY();
            anchorAngelX = angelX.get();
            anchorAngelY = angelY.get();
        });

        group.setOnMouseDragged(event -> {
            angelX.set(anchorAngelX - (anchorY - event.getSceneY()));
            angelY.set(anchorAngelY + anchorX - event.getSceneX());
        });
    }
}
