/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author courtney
 */
public class Towers extends Application {
    private final static int GAME_HEIGHT = 800;
    private final static int GAME_WIDTH = 600;
    private final static int BUTTON_SPACING = 12;

    Button startGameBtn = new Button();
    Button exitBtn = new Button();
    Button settingsBtn = new Button();

    VBox mainMenuButtons = new VBox(BUTTON_SPACING);
    
    @Override
    public void start(Stage primaryStage) {
        buildButtons();
        StackPane root = new StackPane();
        
        Scene scene = new Scene(root, GAME_HEIGHT, GAME_WIDTH);

        Image splashPageBackplate = new Image("/splashBackground.png", GAME_HEIGHT, GAME_WIDTH, true, false, true);
        ImageView splashPage = new ImageView(splashPageBackplate);

        root.getChildren().add(splashPage);	
        root.getChildren().add(mainMenuButtons);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void buildButtons() {
        startGameBtn.setText("Say 'Hello World'");
        startGameBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        settingsBtn.setText("Settings");
        settingsBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Settings");
            }
        });

        exitBtn.setText("Exit");
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        mainMenuButtons.getChildren().addAll(startGameBtn, settingsBtn, exitBtn);
        mainMenuButtons.setAlignment(Pos.CENTER);

    }
    
}
