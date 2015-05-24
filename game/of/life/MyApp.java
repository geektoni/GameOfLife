/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.of.life;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author uriel
 */
public class MyApp extends Application {
    
    private Stage thisStage;
    private VBox layout;
    private TextField number;
    private Button submit;
    private Text error, title;
    private ToggleButton fullScreen;
    
    private boolean isFullScreen = false;
    
    @Override
    public void start(Stage primaryStage) {
        
        thisStage = primaryStage;
        
        layout = new VBox();
        number = new TextField();
        submit = new Button("Generate");
        fullScreen = new ToggleButton("Full Screen");
        
        error = new Text("Error! Maximum grid dimension 20.");
        title = new Text("Insert grid dimension:");
        error.setFill(Paint.valueOf("RED"));
        error.setVisible(false);
        
        layout.getChildren().addAll(title, error, number,fullScreen, submit);
        layout.setSpacing(10);
        layout.setPadding(new Insets(30));
        layout.setAlignment(Pos.CENTER);
        
        fullScreen.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                isFullScreen = true;
            }
        }); 
        
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                int generator = Integer.parseInt(number.getText());
                if (generator > 40) {
                    error.setVisible(true);
                } else {
                    new Layout(generator, isFullScreen);
                    thisStage.close();
                }
            }
        }); 
        
        Scene scene = new Scene(layout, 300, 250);
        
        primaryStage.setTitle("Game of Life");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
