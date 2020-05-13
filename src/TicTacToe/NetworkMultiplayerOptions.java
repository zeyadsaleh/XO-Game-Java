package TicTacToe;

import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public  class NetworkMultiplayerOptions extends AnchorPane {

    protected final Pane pane;
    protected final ImageView imageView;
    protected final Button back;
    protected final Button joinGame;
    protected final Button createGame;

    public NetworkMultiplayerOptions() {

        pane = new Pane();
        imageView = new ImageView();
        back = new Button();
        joinGame = new Button();
        createGame = new Button();

        setId("background");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(578.0);
        setPrefWidth(688.0);
        getStylesheets().add("/projectfxml/newCascadeStyleSheet.css");

        pane.setId("background");
        pane.setPrefHeight(578.0);
        pane.setPrefWidth(688.0);
        pane.getStylesheets().add("/projectfxml/newCascadeStyleSheet.css");

        imageView.setFitHeight(151.0);
        imageView.setFitWidth(480.0);
        imageView.setLayoutX(104.0);
        imageView.setLayoutY(60.0);
        imageView.setImage(new Image(getClass().getResource("logooo.png").toExternalForm()));

        back.setId("button");
        back.setLayoutX(344.0);
        back.setLayoutY(424.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(47.0);
        back.setPrefWidth(254.0);
        back.setText("Back");

        joinGame.setId("button");
        joinGame.setLayoutX(203.0);
        joinGame.setLayoutY(346.0);
        joinGame.setMnemonicParsing(false);
        joinGame.setPrefHeight(47.0);
        joinGame.setPrefWidth(254.0);
        joinGame.setText("Join Game");

        createGame.setId("button");
        createGame.setLayoutX(76.0);
        createGame.setLayoutY(266.0);
        createGame.setMnemonicParsing(false);
        createGame.setPrefHeight(47.0);
        createGame.setPrefWidth(254.0);
        createGame.setText("Create Game");

        pane.getChildren().add(imageView);
        pane.getChildren().add(back);
        pane.getChildren().add(joinGame);
        pane.getChildren().add(createGame);
        getChildren().add(pane);
        
         createGame.setOnAction((Action) -> {
            AllPanes.xoGame_MultiPlayer.isSinglePlayer = false;
            try {
                
                AllPanes.xoGame_MultiPlayer.intializeServer();
                 System.out.println("easy easy tmam tmam");  
                
            } catch (IOException ex) {
                      System.out.println("initilaze error");         
            }
            
            AllPanes.xoGame_MultiPlayer.th = new Thread(AllPanes.xoGame_MultiPlayer);
            AllPanes.xoGame_MultiPlayer.th.start();
            AllPanes.viewPane(AllPanes.xoGame_MultiPlayer);           

        });       
        joinGame.setOnAction((Action) -> {
            AllPanes.xoGame_MultiPlayer.isSinglePlayer = false;
            if(AllPanes.xoGame_MultiPlayer.connect()){
                AllPanes.xoGame_MultiPlayer.th = new Thread(AllPanes.xoGame_MultiPlayer);
                AllPanes.xoGame_MultiPlayer.th.start();
                AllPanes.viewPane(AllPanes.xoGame_MultiPlayer);
            }
            else{
                  Alert NotEnd = new Alert(Alert.AlertType.NONE);
                   NotEnd.setAlertType(Alert.AlertType.WARNING);
                   NotEnd.setContentText("No server had created the game");
                   NotEnd.show();         
            }

        });
        
        back.setOnAction((Action)-> {
            AllPanes.viewPane(AllPanes.multiplayerOptions);
        });


    }
}
