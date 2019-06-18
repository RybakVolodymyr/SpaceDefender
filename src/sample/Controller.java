package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    AnchorPane anchorPane;

    @FXML
    ImageView ship;

    @FXML
    Button levels;

    @FXML
    Button shop;

    @FXML
    Button save;

    @FXML
    Button load;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setChangeFxml(levels,"levels.fxml");
        setChangeFxml(shop,"Shop.fxml");

        save.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                saveToFile();
            }
        });

        load.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                openFile();
            }
        });
        ship.setImage(new Image(Main.ship.getUrl()));
    }

    private void setChangeFxml(Button button, String fxml){
        button.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource(fxml));
                    anchorPane.getChildren().setAll(pane);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }



    private void saveToFile() {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Space Defender file (*.sdef)", "*.sdef");
        fc.getExtensionFilters().add(extFilter);
        Stage fileChooserStage = new Stage();
        fc.setTitle("chooser");
        File selectedFile = fc.showSaveDialog(fileChooserStage);
        if (selectedFile != null) {
            serialization(selectedFile);
        }
    }

    private void serialization(File file){
        try
        {
            //Saving of object in a file
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);

            // Method for serialization of object
            out.writeObject(Main.ship);

            out.close();
            fileOutputStream.close();

            System.out.println("Object has been serialized");

        }catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }


    }


    private  void openFile() {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Space Defender file (*.sdef)", "*.sdef");
        fc.getExtensionFilters().add(extFilter);
        Stage fileChooserStage = new Stage();
        fc.setTitle("chooser");
        File selectedFile = fc.showOpenDialog(fileChooserStage);
        if (selectedFile != null) {
            deserialization(selectedFile);
        }
    }

    private void deserialization(File file){
        try
        {
            // Reading the object from a file
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileInputStream);

            // Method for deserialization of object
            Main.ship = (Ship) in.readObject();
            ship.setImage(new Image(Main.ship.getUrl()));

            in.close();
            fileInputStream.close();
        }catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
    }






}
