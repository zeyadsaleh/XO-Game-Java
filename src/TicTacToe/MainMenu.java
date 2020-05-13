package TicTacToe;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public  class MainMenu extends AnchorPane {

    protected final Pane pane;
    protected final ImageView imageView;
    protected final Button singlePlayer;
    protected final Button exit;
    protected final Button multiPlayer;
    protected final Button record;
    protected final Button about;
    protected final Label scoreLabel;
    protected final Label scoreValue;

    public MainMenu() {

        pane = new Pane();
        imageView = new ImageView();
        singlePlayer = new Button();
        exit = new Button();
        multiPlayer = new Button();
        record = new Button();
        about = new Button();
        scoreLabel = new Label();
        scoreValue = new Label();

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

        singlePlayer.setId("button");
        singlePlayer.setLayoutX(217.0);
        singlePlayer.setLayoutY(235.0);
        singlePlayer.setMnemonicParsing(false);
        singlePlayer.setPrefHeight(47.0);
        singlePlayer.setPrefWidth(254.0);
        singlePlayer.setText("Single Player");

        exit.setId("button");
        exit.setLayoutX(217.0);
        exit.setLayoutY(464.0);
        exit.setMnemonicParsing(false);
        exit.setPrefHeight(47.0);
        exit.setPrefWidth(254.0);
        exit.setText("Exit");
        exit.setTextFill(javafx.scene.paint.Color.valueOf("#460000"));

        multiPlayer.setId("button");
        multiPlayer.setLayoutX(217.0);
        multiPlayer.setLayoutY(291.0);
        multiPlayer.setMnemonicParsing(false);
        multiPlayer.setPrefHeight(47.0);
        multiPlayer.setPrefWidth(254.0);
        multiPlayer.setText("Multi Player");

        record.setId("button");
        record.setLayoutX(217.0);
        record.setLayoutY(348.0);
        record.setMnemonicParsing(false);
        record.setPrefHeight(47.0);
        record.setPrefWidth(254.0);
        record.setText("Record");

        about.setId("button");
        about.setLayoutX(217.0);
        about.setLayoutY(405.0);
        about.setMnemonicParsing(false);
        about.setPrefHeight(47.0);
        about.setPrefWidth(254.0);
        about.setText("About");
        
        scoreLabel.setLayoutX(24.0);
        scoreLabel.setLayoutY(497.0);
        scoreLabel.setPrefHeight(72.0);
        scoreLabel.setPrefWidth(113.0);
        scoreLabel.setText("Score");
        scoreLabel.setFont(new Font(41.0));

        scoreValue.setLayoutX(137.0);
        scoreValue.setLayoutY(507.0);
        scoreValue.setPrefHeight(59.0);
        scoreValue.setPrefWidth(47.0);
        scoreValue.setText("0");
        scoreValue.setFont(new Font(41.0));

        pane.getChildren().add(imageView);
        pane.getChildren().add(singlePlayer);
        pane.getChildren().add(exit);
        pane.getChildren().add(multiPlayer);
        pane.getChildren().add(record);
        pane.getChildren().add(about);
        pane.getChildren().add(scoreLabel);
        pane.getChildren().add(scoreValue);
        getChildren().add(pane);
        
        
        singlePlayer.setOnAction((Action)-> {
            AllPanes.xoGame.isSinglePlayer = true;
            AllPanes.viewPane(AllPanes.SingleplayerLevels);
        });
        
        multiPlayer.setOnAction((Action)-> {
            AllPanes.xoGame.isSinglePlayer = false;
            AllPanes.viewPane(AllPanes.multiplayerOptions);
        });
        
        
        record.setOnAction((Action)-> {
            
            if(AllPanes.record.recordBtns.isEmpty()){
                
                Alert a = new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.WARNING);
                a.setContentText("There is no record");
                a.show();
            
            }
            else{
                
                AllPanes.viewPane(AllPanes.record);
            }
            
            
        });
        
        about.setOnAction((Action)->{
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setTitle("Tic Tac Toe");
            a.setHeaderText("a7la team dah wla a");
            Image image = new Image("File:src\\TicTacToe\\Emotion.png");
            ImageView imageView = new ImageView(image);
            a.setGraphic(imageView);
            a.setContentText("Ektbo asamena");
            a.show();
        });
        exit.setOnAction((Action) -> {
            Platform.exit();
        });
        

    }
}
