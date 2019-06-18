package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerForShop implements Initializable {
    @FXML
    AnchorPane anchorPane;

    @FXML
    private Button addGun;

    @FXML
    private Button plusDamage;

    @FXML
    private Button plusHeart;

    @FXML
    private Button plusSuperka;

    @FXML
    private Label superka;

    @FXML
    private Label damage;

    @FXML
    private Label numberOfHearts;

    @FXML
    private Label numberOfGuns;

    @FXML
    private Label numberOfCoins;

    @FXML
    private ImageView shipImage;

    @FXML
    Button backButton;

    @FXML
    Button helperButton;

    @FXML
    Label helper;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        plusHeart.setTooltip(new Tooltip(String.valueOf(Main.ship.getLifes() * 10000)));
        addGun.setTooltip(new Tooltip(String.valueOf(Main.ship.getNumberOfGuns() * 100000)));
        plusDamage.setTooltip(new Tooltip(String.valueOf(Main.ship.getDamage() + 100)));
        refreshCoins();
        setChangeFxml(backButton, "sample.fxml");
        if (Main.ship.isFirstSuper()) {
            superka.setText("Unlock");
            plusSuperka.setDisable(true);
            plusSuperka.setTooltip(new Tooltip("Purchased"));
        } else {
            superka.setText("Lock");
            plusSuperka.setDisable(false);
            plusSuperka.setTooltip(new Tooltip("100000"));
        }

        if (Main.ship.isHelper()) {
            helper.setText("Unlock");
            helperButton.setDisable(true);
            helperButton.setTooltip(new Tooltip("Purchased"));
        } else {
            helper.setText("Lock");
            helperButton.setDisable(false);
            helperButton.setTooltip(new Tooltip("1000000"));
        }


        numberOfCoins.setText(String.valueOf(Main.ship.getNumberOfCoins()));

        shipImage.setImage(new Image(Main.ship.getUrl()));

        if (Main.ship.getNumberOfGuns() == 3) {
            addGun.setDisable(true);
        } else {
            addGun.setDisable(false);
        }
        numberOfGuns.setText(String.valueOf(Main.ship.getNumberOfGuns()));
        numberOfHearts.setText(String.valueOf(Main.ship.getFirstHP() + Main.ship.getNymberOfHpUpdate()));
        damage.setText(String.valueOf(Main.ship.getFirstDamage() + Main.ship.getNymberOfDamageUpdate() * Main.ship.getDamageUp()));

        addGun.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Main.ship.getNumberOfCoins() >= Main.ship.getNumberOfGuns() * 100000) {
                    Main.ship.setNumberOfCoins(Main.ship.getNumberOfCoins() - Main.ship.getNumberOfGuns() * 100000);
                    Main.ship.setNumberOfGuns(Main.ship.getNumberOfGuns() + 1);
                    Main.ship.refreshURL(Main.ship.getNumberOfGuns());
                    numberOfGuns.setText(String.valueOf(Main.ship.getNumberOfGuns()));
                    shipImage.setImage(new Image(Main.ship.getUrl()));
                    if (Main.ship.getNumberOfGuns() == 3) addGun.setDisable(true);
                    addGun.getTooltip().hide();
                    addGun.setTooltip(new Tooltip(String.valueOf(Main.ship.getNumberOfGuns() * 100000)));
                    refreshCoins();
                }

            }
        });

        plusDamage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Main.ship.getNumberOfCoins() >= Main.ship.getDamage() + 100) {
                    Main.ship.setNumberOfCoins(Main.ship.getNumberOfCoins() - Main.ship.getDamage() + 100);
                    Main.ship.setNymberOfDamageUpdate(Main.ship.getNymberOfDamageUpdate() + 1);
                    damage.setText(String.valueOf(Main.ship.getFirstDamage() + Main.ship.getNymberOfDamageUpdate() * Main.ship.getDamageUp()));
                    System.out.println(Main.ship.getDamage());
                    System.out.println(Main.ship.getNymberOfDamageUpdate());
                    plusDamage.getTooltip().hide();
                    plusDamage.setTooltip(new Tooltip(String.valueOf(Main.ship.getDamage() + 100)));
                    refreshCoins();
                }
            }
        });

        plusHeart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Main.ship.getNumberOfCoins() >= Main.ship.getLifes() * 10000) {
                    Main.ship.setNumberOfCoins(Main.ship.getNumberOfCoins() - Main.ship.getLifes() * 10000);
                    Main.ship.setNymberOfHpUpdate(Main.ship.getNymberOfHpUpdate() + 1);
                    numberOfHearts.setText(String.valueOf(Main.ship.getFirstHP() + Main.ship.getNymberOfHpUpdate()));
                    plusHeart.setTooltip(new Tooltip(String.valueOf(Main.ship.getLifes() * 10000)));

                    refreshCoins();
                }
            }
        });

        plusSuperka.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Main.ship.getNumberOfCoins() >= 100000) {
                    Main.ship.setNumberOfCoins(Main.ship.getNumberOfCoins() - 100000);
                    Main.ship.setFirstSuper(true);
                    superka.setText("Unlock");
                    plusSuperka.setDisable(true);
                    plusSuperka.getTooltip().hide();
                    plusSuperka.setTooltip(new Tooltip("Purchased"));
                    refreshCoins();
                    ControllerForFight.refreshSuper();
                }
            }
        });

        helperButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Main.ship.getNumberOfCoins() >= 1000000) {
                    Main.ship.setNumberOfCoins(Main.ship.getNumberOfCoins() - 1000000);
                    Main.ship.setHelper(true);
                    helper.setText("Unlock");
                    helperButton.setDisable(true);
                    helperButton.getTooltip().hide();
                    helperButton.setTooltip(new Tooltip("Purchased"));
                    refreshCoins();
                }
            }
        });


    }

    void refreshCoins() {
        numberOfCoins.setText(String.valueOf(Main.ship.getNumberOfCoins()));
    }


    private void setChangeFxml(Button button, String fxml) {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
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
