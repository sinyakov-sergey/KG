package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Group root = new Group();
        DDA dda1 = new DDA(root,400, 180, 600, 100, Color.DARKKHAKI);
        BRE bre2 = new BRE(root, 300, 200,0, 100, Color.DARKBLUE);
        By by = new By(root, 200, 300, 0,0, Color.RED);
        BREcirc brEcirc1 = new BREcirc(root, 100,100, 20,1, Color.KHAKI);
        BREelips brEelips1 = new BREelips(root, 400, 200, 50,10, Color.BROWN);
        BREarca brEarca = new BREarca(root, 200, 340, 70, 30, Color.PINK);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
