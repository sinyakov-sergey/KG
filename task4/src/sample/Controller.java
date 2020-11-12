package sample;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.scene.control.Button;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane Anchor;

    @FXML
    private Button go;

    @FXML
    void initialize() {

        Group group = new Group();
        group.setLayoutX(500);
        group.setLayoutY(250);
        Flatness flatness1 = new Flatness(group, 170, Color.DARKGREEN);
        Flatness flatness2 = new Flatness(group, 170, Color.DARKGREEN);
        group.getChildren().get(group.getChildren().size() - 1).getTransforms().
                addAll(new Rotate(90, Rotate.X_AXIS));
        Flatness flatness3 = new Flatness(group, 170, Color.DARKGREEN);
        group.getChildren().get(group.getChildren().size() - 1).getTransforms().
                addAll(new Rotate(90, Rotate.X_AXIS), new Rotate(90, Rotate.Y_AXIS));
        Camera camera = new Camera(group);
        Anchor.getChildren().add(group);

        go.setStyle("-fx-background-color: darkgreen");
        go.setOnAction(ActiveEvent -> {
            group.getChildren().clear();
            Flatness flatness4 = new Flatness(group, 150, Color.DARKGREEN);
            Flatness flatness5 = new Flatness(group, 150, Color.DARKGREEN);
            group.getChildren().get(group.getChildren().size() - 1).getTransforms().
                    addAll(new Rotate(90, Rotate.X_AXIS));
            Flatness flatness6 = new Flatness(group, 150, Color.DARKGREEN);
            group.getChildren().get(group.getChildren().size() - 1).getTransforms().
                    addAll(new Rotate(90, Rotate.X_AXIS), new Rotate(90, Rotate.Y_AXIS));

            group.getChildren().get(1).setTranslateX(20);
            group.getChildren().get(2).setTranslateY(20);
            group.getChildren().get(0).setTranslateX(20);
            group.getChildren().get(0).setTranslateY(20);
            group.getChildren().get(0).setTranslateZ(-20);

            for (int i = 0; i <= 150; i++){
                Arc arc = new Arc(20, 20, 20, 20, 90, 90);
                arc.setTranslateZ(i);
                arc.setType(ArcType.OPEN);
                arc.setStroke(Color.DARKGREEN);
                arc.setFill(Color.TRANSPARENT);
                group.getChildren().add(arc);
            }

            for (int i = 20; i <= 170; i++){
                Arc arc = new Arc(0, 20, 20, 20, 0, 90);
                arc.setTranslateX(i);
                arc.setType(ArcType.OPEN);
                arc.setStroke(Color.DARKGREEN);
                arc.setFill(Color.TRANSPARENT);
                arc.getTransforms().add(new Rotate(90, Rotate.Y_AXIS));
                group.getChildren().add(arc);
            }

            for (int i = 20; i <= 170; i++){
                Arc arc = new Arc(20, 0, 20, 20, 90, 90);
                arc.setTranslateY(i);
                arc.setType(ArcType.OPEN);
                arc.setStroke(Color.DARKGREEN);
                arc.setFill(Color.TRANSPARENT);
                arc.getTransforms().add(new Rotate(90, Rotate.X_AXIS));
                group.getChildren().add(arc);
            }

            for (int i = 0; i <= 90; i++){
                Arc arc = new Arc(0, 0, 20, 20, 90, 90);
                arc.setType(ArcType.OPEN);
                arc.setTranslateY(20);
                arc.setTranslateX(20);
                arc.setStroke(Color.DARKGREEN);
                arc.setFill(Color.TRANSPARENT);
                arc.getTransforms().addAll(new Rotate(i, Rotate.Y_AXIS), new Rotate(270, Rotate.Y_AXIS));
                group.getChildren().add(arc);
            }
        });
    }
}

