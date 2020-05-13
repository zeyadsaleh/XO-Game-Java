/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author OWNER
 */
public class TicTacToe extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        AnchorPane pane = new AnchorPane();

        pane.getChildren().add(AllPanes.registerMenu);
        pane.getChildren().add(AllPanes.playerData);
        pane.getChildren().add(AllPanes.mainMenu);
        pane.getChildren().add(AllPanes.SingleplayerLevels);
        pane.getChildren().add(AllPanes.multiplayerOptions);
        pane.getChildren().add(AllPanes.localMultiplayerOptions);
        pane.getChildren().add(AllPanes.xoGame);
        pane.getChildren().add(AllPanes.xoGame_MultiPlayer);
        pane.getChildren().add(AllPanes.networkMultiplayerOptions);
        pane.getChildren().add(AllPanes.record);
        pane.getChildren().add(AllPanes.xoRecords);

        AllPanes.viewPane(AllPanes.registerMenu);

        Scene scene = new Scene(pane, 688, 578);

        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add( new Image(TicTacToe.class.getResourceAsStream( "icon.png" ))); 
        primaryStage.setScene(scene);

        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
             System.exit(0);
          }
        }); 
    }
               

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
