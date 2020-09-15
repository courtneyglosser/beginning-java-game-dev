/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author courtney
 */
public class Visitor extends Application {
    // Global Constants
    public final static int GAME_WIDTH = 800;
    public final static int GAME_HEIGHT = 600;

    public static final double GAME_RIGHT_BOUNDARY = (GAME_WIDTH/2 - 10);
    public static final double GAME_LEFT_BOUNDARY = -(GAME_WIDTH/2 - 215);
    public static final double GAME_TOP_BOUNDARY = (GAME_HEIGHT/2 - 10);
    public static final double GAME_BOTTOM_BOUNDARY = -(GAME_HEIGHT/2 - 10);

    protected static final double CENTER_X = (GAME_RIGHT_BOUNDARY + GAME_LEFT_BOUNDARY) / 2;
    protected static final double CENTER_Y = (GAME_TOP_BOUNDARY + GAME_BOTTOM_BOUNDARY) / 2;

    private final static int BUTTON_SPACING = 12;

    private boolean up, down, left, right;

    private Boolean inHeaven = true;

    private Button startGameBtn = new Button();
    private Button settingsBtn = new Button();
    private Button exitBtn = new Button();
    private Button landBtn = new Button();
    private Button departBtn = new Button();
    private Button menuBtn = new Button();


    private VBox mainMenuButtons = new VBox(BUTTON_SPACING);
    private VBox chromeButtons = new VBox(BUTTON_SPACING);

    private Image splashBackground, heavenBackground, earthBackground; 
    private Image dietyDown0, dietyLeft0, dietyUp0;
    private Image dietyDown1, dietyLeft1, dietyUp1;
    private Image dietyDown2, dietyLeft2, dietyUp2;
    private Image circle;
    private ImageView background;

    private StackPane root;
    private Scene scene;

    private GamePlayLoop gamePlayLoop;

    Deity iDeity;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Visitor");
        root = new StackPane();
        scene = new Scene(root, GAME_WIDTH, GAME_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();

        createSceneEventHandling();
        loadImageAssets();
        createGameActors();
        createCastingDirection();
        createSplashScreenNodes();
        addNodesToStackPane();
        addGameActorNodes();
        createStartGameLoop();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void loadImageAssets() {
        splashBackground = new Image("/images/png/splashBackground.png", GAME_WIDTH, GAME_HEIGHT, true, false, true);
        heavenBackground = new Image("/images/png/heavenBackground.png", GAME_WIDTH, GAME_HEIGHT, true, false, true);
        earthBackground = new Image("/images/png/earthBackground.png", GAME_WIDTH, GAME_HEIGHT, true, false, true);
        dietyDown0 = new Image("/images/png/diety/down-0.png", 32, 32, true, false, true);
        dietyDown1 = new Image("/images/png/diety/down-1.png", 32, 32, true, false, true);
        dietyDown2 = new Image("/images/png/diety/down-2.png", 32, 32, true, false, true);
        dietyLeft0 = new Image("/images/png/diety/left-0.png", 32, 32, true, false, true);
        dietyLeft1 = new Image("/images/png/diety/left-1.png", 32, 32, true, false, true);
        dietyLeft2 = new Image("/images/png/diety/left-2.png", 32, 32, true, false, true);
        dietyUp0 = new Image("/images/png/diety/up-0.png", 32, 32, true, false, true);
        dietyUp1 = new Image("/images/png/diety/up-1.png", 32, 32, true, false, true);
        dietyUp2 = new Image("/images/png/diety/up-2.png", 32, 32, true, false, true);
        circle = new Image("/images/png/circle.png", 32, 32, true, false, true);
        background = new ImageView(splashBackground);
    }

    private void createSceneEventHandling() {
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()) {
                case UP:    up    = true; break;
                case DOWN:  down  = true; break;
                case LEFT:  left  = true; break;
                case RIGHT: right = true; break;
                case W:     up    = true; break;
                case S:     down  = true; break;
                case A:     left  = true; break;
                case D:     right = true; break;
            }
        });
        
        scene.setOnKeyReleased((KeyEvent event) -> {
            switch(event.getCode()) {
                case UP:    up    = false; break;
                case DOWN:  down  = false; break;
                case LEFT:  left  = false; break;
                case RIGHT: right = false; break;
                case W:     up    = false; break;
                case S:     down  = false; break;
                case A:     left  = false; break;
                case D:     right = false; break;
            }
        });
    }

    private void createGameActors() {
        iDeity = new Deity(this, "M150 0 L75 500 L225 200 Z", CENTER_X, CENTER_Y,
            dietyDown0, dietyDown1, dietyDown2,
            dietyLeft0, dietyLeft1, dietyLeft2,
            dietyUp0, dietyUp1, dietyUp2);
        iDeity.moveCenter();
    }

    private void addGameActorNodes() {
        iDeity.spriteFrame.setVisible(false);
        root.getChildren().add(iDeity.spriteFrame);
    }

    private void createCastingDirection() {
        // Need to create CastingDirector class.
        // Do I, though?  Really?
    }

    private void createSplashScreenNodes() {
        buildMainMenuButtons();
        buildChromeButtons();
    }
    
    private void addNodesToStackPane() {
        root.getChildren().add(background);	
        root.getChildren().add(mainMenuButtons);
    }

    private void createStartGameLoop() {
        gamePlayLoop = new GamePlayLoop(this);
    }

    private void buildMainMenuButtons() {
        startGameBtn.setText("Play");
        startGameBtn.setOnAction((ActionEvent event) -> {
            if (inHeaven) {
                background.setImage(heavenBackground);
            }
            else {
                background.setImage(earthBackground);
            }
            root.getChildren().remove(mainMenuButtons);
            root.getChildren().add(chromeButtons);
            iDeity.spriteFrame.setVisible(true);
            gamePlayLoop.start();
        });
        
        settingsBtn.setText("Settings");
        settingsBtn.setOnAction((ActionEvent event) -> {
            System.out.println("Settings");
        });

        exitBtn.setText("Exit");
        exitBtn.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });

        mainMenuButtons.getChildren().addAll(startGameBtn, settingsBtn, exitBtn);
        mainMenuButtons.setAlignment(Pos.CENTER);
    }

    private void buildChromeButtons() {
        landBtn = new Button();
        landBtn.setText("Land");
        landBtn.setOnAction((ActionEvent event) -> {
            background.setImage(earthBackground);
            chromeButtons.getChildren().remove(landBtn);
            chromeButtons.getChildren().add(departBtn);
            inHeaven = false;
            iDeity.animateLanding();
            System.out.println("Game Time (Land on Earth):  ");
            System.out.println(gamePlayLoop.getGametime());
            menuBtn.toFront();
        });

        departBtn = new Button();
        departBtn.setText("Depart");
        departBtn.setOnAction((ActionEvent event) -> {
            background.setImage(heavenBackground);
            chromeButtons.getChildren().remove(departBtn);
            chromeButtons.getChildren().add(landBtn);
            iDeity.moveCenter();
            inHeaven = true;
            System.out.println("Game Time (Depart to Heaven):  ");
            System.out.println(gamePlayLoop.getGametime());
            menuBtn.toFront();
        });

        menuBtn = new Button();
        menuBtn.setText("Return to Menu");
        menuBtn.setOnAction((ActionEvent event) -> {
            background.setImage(splashBackground);
            root.getChildren().remove(chromeButtons);
            root.getChildren().add(mainMenuButtons);
            System.out.println("Game Time:  ");
            System.out.println(gamePlayLoop.getGametime());
            iDeity.spriteFrame.setVisible(false);
            gamePlayLoop.stop();
        });

        chromeButtons.getChildren().addAll(landBtn, menuBtn);
        chromeButtons.setAlignment(Pos.CENTER_LEFT);
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public Boolean isInHeaven() {
        return inHeaven;
    }

    public void setInHeaven(Boolean inHeaven) {
        this.inHeaven = inHeaven;
    }
    
}
