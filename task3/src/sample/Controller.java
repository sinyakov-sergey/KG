package sample;


import java.net.URL;
import java.util.ResourceBundle;


import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor;

    @FXML
    private CheckBox edit;

    @FXML
    private Button add;

    @FXML
    private TextField radius;

    @FXML
    private TextField degree;

    @FXML
    private TextField numberLines;

    @FXML
    private TextField length1;

    @FXML
    private TextField X;

    @FXML
    private TextField Y;

    private double oldX;
    private double oldY;
    private double oldCX;
    private double oldCY;
    private double oldCXst;
    private double oldCYst;
    private static int count = 0;
    private Group circleGR = new Group();

    @FXML
    void initialize() {
        add.setOnAction(ActionEvent -> {
            Group group = new Group();
            int x = Integer.parseInt(X.getText());//начальная координата х
            int y = Integer.parseInt(Y.getText());//начальная координата у
            int rad = Integer.parseInt(radius.getText());//радиус солнца
            float degr = (float) (Float.parseFloat(degree.getText()) * Math.PI / 180);
            int number = Integer.parseInt(numberLines.getText());//количество лучей
            int leng = Integer.parseInt(length1.getText());//длина одного луча
            Sun sun = new Sun(group, rad, x, y, number, leng, degr);
            anchor.getChildren().add(group);
            count++;//считаются количество объектов
            group.setOnMousePressed(e -> {
                oldX = group.getTranslateX() - e.getSceneX();
                oldY = group.getTranslateY() - e.getSceneY();
            });
            group.setOnMouseDragged(e -> {
                group.setTranslateX(oldX + e.getSceneX());
                group.setTranslateY(oldY + e.getSceneY());
            });//задаются условия, что бы солнце моголо передвигаться
            Group sq = new Group();
            Square square = new Square(sq, leng, x, y);
            sq.setVisible(false);
            group.getChildren().add(sq);//создается рамка редактирования
            sq.setOnMousePressed(e -> {
                int xc = (int) (e.getSceneX());
                int yc = (int) (e.getSceneY());
                oldCXst = e.getSceneX();
                oldCYst = e.getSceneY();
                Group circlegr = new Group();
                Circle circle1 = new Circle(circlegr, 10, xc, yc, 1, Color.BLACK);
                circleGR = circlegr;
                oldCX = circlegr.getTranslateX() - e.getSceneX();
                oldCY = circlegr.getTranslateY() - e.getSceneY();
                anchor.getChildren().add(circlegr);
            });
            sq.setOnMouseDragged(v -> {
                anchor.getChildren().get(anchor.getChildren().size() - 1).setTranslateX(oldCX + v.getSceneX());
                anchor.getChildren().get(anchor.getChildren().size() - 1).setTranslateY(oldCY + v.getSceneY());
            });
            sq.setOnMouseReleased(e -> {
                anchor.getChildren().remove(circleGR);
                group.setVisible(true);
                ScaleTransition scale = new ScaleTransition(Duration.millis(1), group);
                double stx = (e.getSceneX() - oldCXst) / (leng);
                double sty = (oldCYst - e.getSceneY()) / (leng);
                scale.setByX(stx);
                scale.setByY(sty);
                scale.play();
            });//редактирование объекта по размеру
        });

        edit.setOnAction(ActionEvent ->{
            if (edit.isSelected()){
                for (int i = 0; i < count ; i++){
                    int c = i + 8;
                    Group old = (Group) anchor.getChildren().get(c);
                    Group sq = (Group) old.getChildren().get(old.getChildren().size() - 1);
                    Group circle1 = (Group) anchor.getChildren().get(anchor.getChildren().size() - 1);
                    old.setOnMouseEntered(e -> {
                        old.setOnMouseDragged(v -> {});
                        sq.setVisible(true);
                    });
                }
            }
            else {
                for (int i = 0; i < count ; i++){
                    int c = i + 8;
                    Group old = (Group) anchor.getChildren().get(c);
                    old.getChildren().get(old.getChildren().size() - 1).setVisible(false);
                    old.setOnMouseEntered(e -> {
                        old.getChildren().get(0).setVisible(false);
                    });
                    old.setOnMousePressed(e -> {
                        oldX = old.getTranslateX() - e.getSceneX();
                        oldY = old.getTranslateY() - e.getSceneY();
                    });
                    old.setOnMouseDragged(e -> {
                        old.setTranslateX(oldX + e.getSceneX());
                        old.setTranslateY(oldY + e.getSceneY());
                    });
                }
            }
        });
    }
}
