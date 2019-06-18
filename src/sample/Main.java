package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

    public static Ship ship = new Ship( 1000000000,100, 0, 0, 1,3, false, false,false);
    public static Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setOnCloseRequest(event -> System.exit(0));
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1280, 720));
        scene =primaryStage.getScene();
        primaryStage.getIcons().add(new Image("file:C:\\Users\\Volodymyr\\Documents\\New folder (2)\\New folder\\SpaceDefender2\\src\\recources\\download.png"));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
