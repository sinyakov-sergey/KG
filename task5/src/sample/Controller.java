package sample;

import java.awt.*;
import java.net.URL;
import java.util.*;
import java.util.List;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor;

    @FXML
    private Button GO;

    @FXML
    private Button STOP;

    @FXML
    private Button earth;

    @FXML
    private Slider speed;

    @FXML
    private Button revers;

    public static Space space = new Space();


    @FXML
    void initialize() {
        Group group = new Group();
        group.setLayoutX(360);
        group.setLayoutY(200);
        for (int i = 0; i <= 360; i = i + 2) {
            Star star = new Star(i);
            group.getChildren().add(star.getCircle());
            space.addToStars(star);
        }
        anchor.getChildren().add(group);
        group.toBack();


        speed.setMin(4);
        speed.setMax(15);
        speed.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                space.setSpeed((long) speed.getValue());
            }
        });
        GO.setOnAction(ActiveEvent ->{
            Timer timer = new Timer();
            Space space1 = new Space(space.getStars(), space.getSpeed(), space.getB());
            timer.schedule(space1, 0,50);
            STOP.setOnAction(ActiveEvent1 -> {
                timer.cancel();
            });
            revers.setOnAction(ActiveEvent2 -> {
                if (space.getB() == 1)space.setB(0);
                else space.setB(1);
            });
        });

        earth.setOnAction(ActiveEvent -> {
            Earth earth = new Earth(group);
        });

    }
}

