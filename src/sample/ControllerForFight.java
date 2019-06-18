package sample;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class ControllerForFight implements Initializable {

    static boolean play = true;
    boolean iterrupt = false;

    @FXML
    volatile AnchorPane anchorPane;

    double anchorPaneWidth = 900;
    double anchorPaneHeight = 500;
    @FXML
    ImageView ship;


    @FXML
    Label lifes;

    @FXML
    Label coins;

    @FXML
    AnchorPane anchorPaneForPause;

    static AnchorPane anchorPaneForPauseStatic;

    @FXML
    ImageView backForPause;

    static ImageView backForPauseStatic;

    @FXML
    ImageView menu;


    @FXML
    ImageView back;

    @FXML
    ImageView speedUp;

    @FXML
    ImageView backForEnd;

    @FXML
    Label labelEnd;

    @FXML
    Label click;

    static ImageView menuStatic;

    @FXML
    Button resume;

    @FXML
    Button exit;

    static int speedUper = 1;
    static boolean speedUpEnable;

    ImageView helper;

    static Thread[] threads;

    static int level = 0;
    static int wales = 0;


    volatile ArrayList<ImageView> fires = new ArrayList<>();

    volatile ArrayList<ImageView> mobFires = new ArrayList<>();

    volatile ArrayList<Mobs> mobs = new ArrayList<>();

    static void refreshSuper() {
        if (Main.ship.isFirstSuper()) {
            speedUpEnable = true;
        } else {
            speedUpEnable = false;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        back.setVisible(true);
        if(level == 1)
        back.setImage(new Image("\\recources\\yar.gif"));
        if(level == 2)
            back.setImage(new Image("\\recources\\hmx.gif"));
        if(level == 3)
            back.setImage(new Image("\\recources\\wtf.gif"));
        if (Main.ship.isFirstSuper()) {
            speedUp.setVisible(true);
        } else {
            speedUp.setVisible(false);
        }
        unkiled = false;
        Main.ship.refreshLives();

        System.out.println("init");
        anchorPane.setFocusTraversable(true);
        anchorPane.setCursor(Cursor.NONE);
        lifes.setText(String.valueOf(Main.ship.getLifes()));
        coins.setText(String.valueOf(Main.ship.getNumberOfCoins()));

//      init ship
        {
            ship = new ImageView(Main.ship.getUrl());
//            ship = new ImageView("file:///C://Users//Volodymyr//Documents//New folder (2)//New folder//SpaceDefender//redOne.png");
            ship.setVisible(true);
            anchorPane.getChildren().add(ship);
            ship.setFitHeight(112 - 20);
            ship.setFitWidth(112 - 20);
            ship.setX(anchorPaneWidth / 2 - ship.getFitWidth() / 2);
            ship.setY(anchorPaneHeight - ship.getFitHeight());
        }

        if (Main.ship.isHelper()) {
            helper = new ImageView("\\recources\\space ship\\playerShip3_red.png");
            helper.setVisible(true);
            anchorPane.getChildren().add(helper);
            helper.setFitHeight(40);
            helper.setFitWidth(40);
            helper.setX(ship.getX() + +ship.getFitWidth() / 2 + ship.getFitWidth() - helper.getFitWidth() / 2);
            helper.setY(ship.getY() + ship.getFitHeight() / 2 + ship.getFitHeight() / 3 - helper.getFitWidth() / 2);
        }

//        for (int i = 0; i < 11; i++) {
//            System.out.println("add mob");
//            Mobs mob = new Mobs(0);
//            mob.getImage().setFitWidth(mob.getImage().getImage().getWidth());
//            mob.getImage().setFitHeight(mob.getImage().getImage().getHeight());
//            mob.getImage().setX(-100);
//            mob.getImage().setY(-100);
////            mob.setHp(100);
//            System.out.println("add mob to array");
//            addToMobs(mob);
//            System.out.println(mobs.size());
//            anchorPane.getChildren().add(mob.getImage());
//        }
//        FromOneDotRightTopLiteToAll.fillArray11(mobs);

        anchorPane.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (play) {

                    ship.setY(event.getY() - ship.getFitHeight() / 2);
                    ship.setX(event.getX() - ship.getFitWidth() / 2);

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            backForPause.toFront();
                            anchorPaneForPause.toFront();

                        }
                    });
//                    Platform.runLater(new Runnable() {
//
//                        @Override
//                        public void run() {
//                            backForPause.setVisible(false);
//                            anchorPane.setCursor(Cursor.NONE);
//                            anchorPaneForPause.setVisible(false);
//                        }
//                    });
                }

            }
        });

        anchorPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                play = false;
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        backForPause.setVisible(true);
                        backForPause.toFront();
                        anchorPaneForPause.setVisible(true);
                        System.out.println("pause");
                        anchorPaneForPause.toFront();
                        anchorPane.setCursor(Cursor.DEFAULT);
                    }
                });
            }
        });

        anchorPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.DIGIT1) {
                    System.out.println("super");
                    if (speedUpEnable) {
                        System.out.println("super Start");
                        speedUpEnable = false;
                        speedUper = 3;
                        FadeTransition fadeTransition = new FadeTransition();
                        fadeTransition.setNode(speedUp);
                        fadeTransition.setDuration(Duration.seconds(0.5));
                        fadeTransition.setFromValue(0.3);
                        fadeTransition.setToValue(1.0);
                        fadeTransition.setCycleCount(6);
                        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                speedUper = 1;
                                FadeTransition fadeTransition = new FadeTransition();
                                fadeTransition.setNode(speedUp);
                                fadeTransition.setDuration(Duration.seconds(20));
                                fadeTransition.setFromValue(0.3);
                                fadeTransition.setToValue(1.0);
                                fadeTransition.setCycleCount(1);
                                fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        speedUpEnable = true;
                                    }
                                });
                                fadeTransition.play();
                            }
                        });
                        fadeTransition.play();

                    }
                }
            }
        });

//        anchorPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                if (event.getCode() == KeyCode.ESCAPE) {
//                    if (!iterrupt || true) {
//                        if (play) {
//                            play = false;
//                        } else {
//                            play = true;
//                        }
//                    }
//                }
//            }
//        });

        Fire fire = new Fire();
        Thread fireThread = new Thread(fire);
        fireThread.start();
        mainLoop();

        FireMove fireMove = new FireMove();
        Thread fileMoveThread = new Thread(fireMove);
        fileMoveThread.start();

        MobMove mobsMove = new MobMove();
        Thread mobsMoveThread = new Thread(mobsMove);
        mobsMoveThread.start();

        MobFire mobFire = new MobFire();
        Thread mobsFireThread = new Thread(mobFire);
        mobsFireThread.start();

        MobFireMove mobFireMove = new MobFireMove();
        Thread mobsFireMoveThread = new Thread(mobFireMove);
        mobsFireMoveThread.start();

        MobFireColi mobFireColi = new MobFireColi();
        Thread mobsFireMoveColiThread = new Thread(mobFireColi);
        mobsFireMoveColiThread.start();
        Thread helperMoveThread = null;
        if (Main.ship.isHelper()) {
            HelperMove helherMove = new HelperMove();
            helperMoveThread = new Thread(helherMove);
            helperMoveThread.start();
        }

        CheckColWithMobs checkColWithMobs = new CheckColWithMobs();
        Thread checkColWithMobsThread = new Thread(checkColWithMobs);
        checkColWithMobsThread.start();


        MobsAdding mobsAdding = new MobsAdding();
        Thread mobsAddingTread = new Thread(mobsAdding);
        mobsAddingTread.start();

        if (!Main.ship.isHelper())
            threads = new Thread[]{mobsAddingTread, fireThread, fileMoveThread, mobsMoveThread, mobsFireThread, mobsFireMoveThread, mobsFireMoveColiThread, checkColWithMobsThread};
        else
            threads = new Thread[]{mobsAddingTread, fireThread, helperMoveThread, fileMoveThread, mobsMoveThread, mobsFireThread, mobsFireMoveThread, mobsFireMoveColiThread, checkColWithMobsThread};
        play = true;
//        iterrupt = false;


    }


    public void resume(ActionEvent event) {
        play = true;
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                backForPause.setVisible(false);
                anchorPaneForPause.setVisible(false);
                anchorPane.setCursor(Cursor.NONE);
            }
        });
    }

    public void exit(ActionEvent event) {
        for (ImageView fire : fires) {
            removeFromPane(fire);
        }
        for (ImageView fire : mobFires) {
            removeFromPane(fire);
        }

//        play = false;
        iterrupt = true;
//        for(Thread thread: threads){
//            synchronized (thread){
//                thread.interrupt();
//
//            }
//        }

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("levels.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
        anchorPane.setCursor(Cursor.DEFAULT);

    }


    void mainLoop() {

    }

    static void controlThreads() {
        while (!play)
            for (Thread thread : threads) {
                synchronized (thread) {
                    try {
                        thread.wait(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (play) break;

            }
    }


    static void stopThreads() {

        synchronized (threads) {
            try {
                threads.wait(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static void startThreads() {
        synchronized (threads) {
            threads.notifyAll();
        }
    }

//    Line copyLine(Line line){
//        Line newLine = new Line();
//        newLine.setLayoutX(line.getLayoutX());
//        newLine.setLayoutY(line.getLayoutY());
//        newLine.setStartX(line.getStartX());
//        newLine.setStartY(line.getStartY());
//        newLine.setEndX(line.getEndX());
//        newLine.setEndY(line.getEndY());
//        return newLine;
//    }

    void fireMove(ImageView fire) {
        fire.setY(fire.getY() - 1);
    }

    void mobFireMove(ImageView fire) {
        fire.setY(fire.getY() + 1);
    }


    public class FireMove implements Runnable {

        @Override
        public void run() {
            while (true && !iterrupt) {
                System.out.print("");
                if (play) {
                    boolean hit = false;
                    //fires move
                    System.out.print("");
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ArrayList<ImageView> firesForCheck;
                    synchronized (fires) {
                        firesForCheck = (ArrayList<ImageView>) fires.clone();
                    }
                    ArrayList<Mobs> mobsForCheck;
                    synchronized (mobs) {
                        mobsForCheck = (ArrayList<Mobs>) mobs.clone();
                    }


                    for (ImageView fire : firesForCheck) {
                        for (Mobs mob : mobsForCheck) {
                            //check collig
                            System.out.print("");
                            if (fire.intersects(mob.getImage().getBoundsInParent())) {
                                hit = true;
                                System.out.println("killed");
                                if (fires.contains(fire))
                                    removeFromFires(fire);
                                removeFromPane(fire);
                                fireMob(mob);
                                System.out.println(mob.getHp() + "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        coins.setText(String.valueOf(Main.ship.getNumberOfCoins()));
                                    }
                                });

                                break;

                            }
                            if (fire.getY() < -50) {
                                removeFromFires(fire);
                            }
                        }
                        if (hit) {
                            hit = false;
                            break;
                        }
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            synchronized (fires){
                            for (ImageView fire : fires) {
                                fireMove(fire);

                            }
                        }}
                    });

                }
            }
        }
    }

    int helperFire = 0;

    public class Fire implements Runnable {

        @Override
        public void run() {
            while (true && !iterrupt) {
                System.out.print("");
                if (play) {
                    System.out.print("");
                    try {
                        Thread.sleep(300 / speedUper);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Platform.runLater(new Runnable() {

                        @Override
                        public void run() {
                            if (helperFire == 3) {
                                if(Main.ship.isHelper()) {
                                    System.out.println("fire");
                                    ImageView fireHelper = new ImageView("\\recources\\space ship\\spaceshooter\\PNG\\Effects\\fire03.png");
                                    fireHelper.setFitWidth(fireHelper.getImage().getWidth());
                                    fireHelper.setFitHeight(fireHelper.getImage().getHeight());
                                    fireHelper.setX(helper.getX() + helper.getFitWidth() / 2 - fireHelper.getFitWidth() / 2 - 1);
                                    fireHelper.setY(helper.getY() - fireHelper.getFitHeight());

                                    if (fireHelper.getY() > 0 && play) {
                                        addToFires(fireHelper);
                                        addToPane(fireHelper);
                                    }
                                }
                                helperFire = 0;
                            }
                        }
                    });

                    Platform.runLater(new Runnable() {

                        @Override
                        public void run() {
                            System.out.println("fire");
                            for (int i = 0; i < Main.ship.getNumberOfGuns(); i++) {
                                ImageView fire = new ImageView("\\recources\\space ship\\spaceshooter\\PNG\\Effects\\fire06gooodone.png");
                                fire.setFitWidth(fire.getImage().getWidth());
                                fire.setFitHeight(fire.getImage().getHeight());
                                if (Main.ship.getNumberOfGuns() == 1) {
                                    fire.setX(ship.getX() + ship.getFitWidth() / 2 - fire.getFitWidth() / 2 - 1);
                                    fire.setY(ship.getY() - fire.getFitHeight());
                                }

                                if (Main.ship.getNumberOfGuns() == 2) {
                                    fire.setX(ship.getX() + ship.getFitWidth() / 2 - fire.getFitWidth() / 2 - 1 - 20 + i * 40);
                                    fire.setY(ship.getY() - fire.getFitHeight() + 10);
                                }

                                if (Main.ship.getNumberOfGuns() == 3) {
                                    fire.setX(ship.getX() + ship.getFitWidth() / 2 - fire.getFitWidth() / 2 - 1 - 20 + i * 20);
                                    fire.setY(ship.getY() - fire.getFitHeight() + 10 - Math.pow(-1, i + 1) * 10);
                                }


                                if (fire.getY() > 0 && play) {
                                    addToFires(fire);
                                    addToPane(fire);
                                    helperFire++;
                                }

                            }
                        }
                    });

                }

            }
        }
    }

    Random random = new Random();

    public class MobFire implements Runnable {

        @Override
        public void run() {
            while (true && !iterrupt) {
                System.out.print("");
                if (play) {
                    System.out.print("");
                    ArrayList<Mobs> mobsForCheck;
                    synchronized (mobs) {
                        mobsForCheck = (ArrayList<Mobs>) mobs.clone();
                    }
                    if (mobsForCheck.size() != 0) {
                        Mobs mob;

                        if (mobsForCheck.size() == 1) mob = mobsForCheck.get(0);
                        else
                            mob = mobsForCheck.get(random.nextInt(mobsForCheck.size() - 1));
                        try {
                            Thread.sleep((long) (random.nextInt(250) + 500) * 2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Platform.runLater(new Runnable() {

                            @Override
                            public void run() {
                                if (mob.isFireAbility()) {
                                    //MobFire
                                    System.out.print("");
                                    ImageView fire = new ImageView("\\recources\\space ship\\spaceshooter\\PNG\\Effects\\fire14.png");
                                    fire.setFitWidth(fire.getImage().getWidth());
                                    fire.setFitHeight(fire.getImage().getHeight());
                                    fire.setX(mob.getImage().getX() + mob.getImage().getFitWidth() / 2 - fire.getFitWidth() / 2 - 1);
                                    fire.setY(mob.getImage().getY() + mob.getImage().getFitHeight() / 2 + fire.getFitHeight());
                                    if (mobs.contains(mob) && play) {
                                        addToPane(fire);
                                        addToMobFires(fire);
                                    }
                                }

                            }
                        });


                    }
                }
            }
        }
    }

    public class MobFireMove implements Runnable {

        @Override
        public void run() {
            while (true && !iterrupt) {
                System.out.print("");
                if (play) {
                    System.out.print("");

                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ArrayList<ImageView> fires;
                    synchronized (mobFires) {
                        fires = (ArrayList<ImageView>) mobFires.clone();
                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            for (ImageView mobFire : fires) {
                                if (mobFire.getY() > 1000) {
                                    removeFromMobFires(mobFire);
                                    removeFromPane(mobFire);
                                }
                                mobFireMove(mobFire);
                            }
                        }
                    });
                }
            }
        }
    }

    public class MobsAdding implements Runnable {

        @Override
        public void run() {
            while (true && !iterrupt) {
                if (level == 1 && wales == 1) {
                    for (int i = 0; i < 10; i++) {
                        // addmob
                        System.out.print("");
                        Mobs mob = new Mobs(0);
                        mob.getImage().setFitWidth(mob.getImage().getImage().getWidth());
                        mob.getImage().setFitHeight(mob.getImage().getImage().getHeight());
                        mob.getImage().setX(-100);
                        mob.getImage().setY(-100);
                        mob.setHp(100);
                        System.out.println("add mob to array");
                        addToMobs(mob);
                        System.out.println(mobs.size());
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                anchorPane.getChildren().add(mob.getImage());

                            }
                        });

                    }
                    FromOneDotAllRectangle.fillArray10(mobs);
                    wales--;
                } else if (level == 2) {
                    if (wales == 2 && mobs.size() == 0) {
                        for (int i = 0; i < 10; i++) {
                            System.out.println("add mob");
                            Mobs mob = new Mobs(1);
                            mob.getImage().setFitWidth(mob.getImage().getImage().getWidth());
                            mob.getImage().setFitHeight(mob.getImage().getImage().getHeight());
                            mob.getImage().setX(-100);
                            mob.getImage().setY(-100);
                            mob.setHp(500);
                            System.out.println("add mob to array");
                            addToMobs(mob);
                            System.out.println(mobs.size());
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    anchorPane.getChildren().add(mob.getImage());

                                }
                            });
                        }
                        FromOneDotAllStraight.fillArray10(mobs);
                        wales--;
                    }
                    if (wales == 1 && mobs.size() == 0) {
                        for (int i = 0; i < 11; i++) {
                            System.out.println("add mob");
                            Mobs mob = new Mobs(1);
                            mob.getImage().setFitWidth(mob.getImage().getImage().getWidth());
                            mob.getImage().setFitHeight(mob.getImage().getImage().getHeight());
                            mob.getImage().setX(-100);
                            mob.getImage().setY(-100);
                            mob.setHp(500);
                            System.out.println("add mob to array");
                            addToMobs(mob);
                            System.out.println(mobs.size());
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    anchorPane.getChildren().add(mob.getImage());

                                }
                            });
                        }
                        FromOneDotRightTopLiteToAll.fillArray11(mobs);
                        wales--;
                    }
                } else if (level == 3) {
                    if (wales == 3 && mobs.size() == 0) {
                        for (int i = 0; i < 10; i++) {
                            System.out.println("add mob");
                            Mobs mob = new Mobs(2);
                            mob.getImage().setFitWidth(mob.getImage().getImage().getWidth());
                            mob.getImage().setFitHeight(mob.getImage().getImage().getHeight());
                            mob.getImage().setX(-100);
                            mob.getImage().setY(-100);
                            mob.setHp(1000);
                            System.out.println("add mob to array");
                            addToMobs(mob);
                            System.out.println(mobs.size());
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    anchorPane.getChildren().add(mob.getImage());

                                }
                            });
                        }
                        FromOneDotAllRectangle.fillArray10(mobs);
                        wales--;
                    }
                    if (wales == 2 && mobs.size() == 0) {
                        for (int i = 0; i < 11; i++) {
                            System.out.println("add mob");
                            Mobs mob = new Mobs(2);
                            mob.getImage().setFitWidth(mob.getImage().getImage().getWidth());
                            mob.getImage().setFitHeight(mob.getImage().getImage().getHeight());
                            mob.getImage().setX(-100);
                            mob.getImage().setY(-100);
                            mob.setHp(1000);
                            System.out.println("add mob to array");
                            addToMobs(mob);
                            System.out.println(mobs.size());
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    anchorPane.getChildren().add(mob.getImage());

                                }
                            });
                        }
                        FromOneDotRightTopLiteToAll.fillArray11(mobs);
                        wales--;
                    }
                    if (wales == 1 && mobs.size() == 0) {
                        System.out.println("add mob");
                        Mobs mob = new Mobs(100);
                        mob.getImage().setFitWidth(mob.getImage().getImage().getWidth());
                        mob.getImage().setFitHeight(mob.getImage().getImage().getHeight());
                        mob.getImage().setX(-100);
                        mob.getImage().setY(-100);
                        mob.setHp(2000000000);
                        System.out.println("add mob to array");
                        addToMobs(mob);
                        System.out.println(mobs.size());
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                anchorPane.getChildren().add(mob.getImage());

                            }
                        });
                        FromOneDotLastOne.fillArray1(mob);
                        wales--;
                    }

                }
                if (wales == 0 && mobs.size() == 0) {
                    win();
                    wales = -1;
                }
            }
        }
    }

    private void win() {
        anchorPane.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
        anchorPane.setOnMouseDragged
                (new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                    }
                });
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                play = false;
                iterrupt = true;
                backForEnd.setVisible(true);
                labelEnd.setText("You Win");
                labelEnd.setLayoutX(labelEnd.getLayoutX() + 75);
                labelEnd.setTextAlignment(TextAlignment.CENTER);
                labelEnd.setVisible(true);
                labelEnd.setTextFill(Color.YELLOW);
                click.setVisible(true);
                anchorPane.setCursor(Cursor.DEFAULT);
            }
        });
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), click);
        fadeTransition.setFromValue(0.4);
        fadeTransition.setToValue(1.0);
        fadeTransition.setCycleCount(Animation.INDEFINITE);
        fadeTransition.play();

        click.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                exit(null);
            }
        });


    }


    public class MobFireColi implements Runnable {

        @Override
        public void run() {
            while (true && !iterrupt) {
                System.out.print("");
                if (play) {
                    System.out.print("");

                    ArrayList<ImageView> fires;
                    synchronized (mobFires) {
                        fires = (ArrayList<ImageView>) mobFires.clone();
                    }
                    for (ImageView mobFire : fires) {
                        if (mobFire.intersects(ship.getBoundsInParent())) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    Main.ship.setLifes(Main.ship.getLifes() - 1);
                                    lifes.setText(String.valueOf(Main.ship.getLifes()));
                                    removeFromMobFires(mobFire);
                                    removeFromPane(mobFire);
                                    if (Main.ship.getLifes() == 0) lose();

                                }
                            });

                            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.4), ship);
                            fadeTransition.setFromValue(1.0);
                            fadeTransition.setToValue(0.0);
                            fadeTransition.setCycleCount(Animation.INDEFINITE);
                            fadeTransition.play();
                            unkiled = true;
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            fadeTransition.stop();
                            ship.setOpacity(1.0);
                            unkiled = false;


                        }
                    }
                }
            }
        }
    }

    private void lose() {
        unkiled = true;
        play = false;
        anchorPane.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
        anchorPane.setOnMouseDragged
                (new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                    }
                });
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(ship);
        fadeTransition.setAutoReverse(false);
        fadeTransition.setDuration(Duration.seconds(2));
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        removeFromPane(ship);
                        play = false;
                        iterrupt = true;
                        backForEnd.setVisible(true);
                        labelEnd.setText("Game Over");
                        labelEnd.setVisible(true);
                        labelEnd.setTextFill(Color.YELLOW);
                        click.setVisible(true);
                        anchorPane.setCursor(Cursor.DEFAULT);
                    }
                });
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), click);
                fadeTransition.setFromValue(0.4);
                fadeTransition.setToValue(1.0);
                fadeTransition.setCycleCount(Animation.INDEFINITE);
                fadeTransition.play();

                click.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        exit(null);
                    }
                });
            }
        });
        fadeTransition.play();


    }

    void threadSleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public class MobMove implements Runnable {

        @Override
        public void run() {
            while (true && !iterrupt) {
                System.out.print("");
                if (play) {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ArrayList<Mobs> mobsTemp;
                    synchronized (mobs) {
                        mobsTemp = (ArrayList<Mobs>) mobs.clone();
                    }
                    for (Mobs mob : mobsTemp) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                if (mob != null && mob.path != null) {
                                    mob.getImage().setX(mob.path.getNextPoint().getX());
                                    mob.getImage().setY(mob.path.getNextPoint().getY());
                                    if (mob.getImage().getY() > anchorPane.getHeight()) removeFromMobs(mob);
                                }
                            }
                        });
                    }
                }
            }
        }
    }


    public class HelperMove implements Runnable {

        @Override
        public void run() {
            while (true && !iterrupt) {
                System.out.print("");
                if (play) {
                    double moveX = (ship.getX() + +ship.getFitWidth() / 2 + ship.getFitWidth() - helper.getFitWidth() / 2 - helper.getX()) / helper.getX() * 12;
                    double moveY = (ship.getY() + ship.getFitHeight() / 2 + ship.getFitHeight() / 3 - helper.getFitHeight() / 2 - helper.getY()) / helper.getY() * 9;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            helper.setX(helper.getX() + moveX);
                            helper.setY(helper.getY() + moveY);
                        }
                    });
                }
            }
        }
    }

    boolean unkiled = false;

    public class CheckColWithMobs implements Runnable {

        @Override
        public void run() {
            while (true && !iterrupt) {
                System.out.print("");
                if (play) {
                    ArrayList<Mobs> mobsForCheck;
                    synchronized (mobs) {
                        mobsForCheck = (ArrayList<Mobs>) mobs.clone();
                    }


                    for (Mobs mob : mobsForCheck) {
                        if (mob.getImage().intersects(ship.getBoundsInParent())) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    Main.ship.setLifes(Main.ship.getLifes() - 1);
                                    lifes.setText(String.valueOf(Main.ship.getLifes()));
                                    if (Main.ship.getLifes() == 0) lose();
                                }
                            });
                            fireMob(mob);
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    coins.setText(String.valueOf(Main.ship.getNumberOfCoins()));
                                }
                            });
                            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.4), ship);
                            fadeTransition.setFromValue(1.0);
                            fadeTransition.setToValue(0.0);
                            fadeTransition.setCycleCount(Animation.INDEFINITE);
                            fadeTransition.play();
                            unkiled = true;
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            fadeTransition.stop();
                            ship.setOpacity(1.0);
                            unkiled = false;
                        }
                    }
                }
            }

        }

    }


    private void addToPane(Node node) {
        anchorPane.getChildren().add(node);
    }

    private void removeFromPane(Node node) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (anchorPane.getChildren().contains(node))
                    anchorPane.getChildren().remove(node);
            }
        });
    }

    private void addToFires(ImageView fire) {
        fires.add(fire);
    }

    private void removeFromFires(ImageView fire) {
        fires.remove(fire);
    }

    private void addToMobFires(ImageView fire) {
        mobFires.add(fire);
    }

    private void removeFromMobFires(ImageView fire) {
        mobFires.remove(fire);
    }

    private void addToMobs(Mobs mob) {
        mobs.add(mob);
    }

    private void removeFromMobs(Mobs mob) {
        mobs.remove(mob);
    }

    private void fireMob(Mobs mob) {
        if (mob.minosLife()) {
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.4), mob.getImage());
            fadeTransition.setFromValue(0.4);
            fadeTransition.setToValue(1.0);
            fadeTransition.setCycleCount(1);
            fadeTransition.play();
        } else {
            removeFromMobs(mob);
            removeFromPane(mob.getImage());
            Main.ship.setNumberOfCoins(Main.ship.getNumberOfCoins() + mob.getFirstHp());
        }
    }


}
