package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerForLevels implements Initializable {
    @FXML
    AnchorPane anchorPane;

    @FXML
    private Button fruso;

    @FXML
    private Button limera;

    @FXML
    private Button upion;

    @FXML
    Button backButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setChangeFxml(backButton, "sample.fxml");
        setChangeFxml(fruso, "fight.fxml");
        setChangeFxml(limera, "fight.fxml");
        setChangeFxml(upion, "fight.fxml");

    }

    private void setChangeFxml(Button button, String fxml) {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ControllerForFight.refreshSuper();

                if(button.equals(fruso)) {ControllerForFight.level = 1;
                    ControllerForFight.wales = 1;
                }
                if(button.equals(limera)) {ControllerForFight.level = 2;
                    ControllerForFight.wales = 2;}
                if(button.equals(upion)) {ControllerForFight.level = 3;
                    ControllerForFight.wales = 3;}
                try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource(fxml));
                    anchorPane.getChildren().setAll(pane);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
