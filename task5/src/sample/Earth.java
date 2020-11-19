package sample;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Earth {

    public Earth(Group group) {
        draw(group);
    }
    public void draw(Group group){
        PhongMaterial phongMaterial = new PhongMaterial();
        phongMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("earth.jpg")));
        Sphere sphere = new Sphere(50);
        sphere.setMaterial(phongMaterial);
        sphere.setRotationAxis(Rotate.Y_AXIS);
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(4000),sphere);
        scaleTransition.setToX(2);
        scaleTransition.setToY(2);
        scaleTransition.setToZ(2);
        scaleTransition.play();
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(60000), sphere);
        rotateTransition.setToAngle(3600);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.play();
        group.getChildren().add(sphere);
    }
}
