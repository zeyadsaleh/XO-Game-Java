package TicTacToe;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public  class LocalMultiplayerOptions extends AnchorPane {

    protected final Pane pane;
    protected final ImageView imageView;
    protected final Button oneScreen;
    protected final Button doubleScreens;
    protected final Button back;

    public LocalMultiplayerOptions() {

        pane = new Pane();
        imageView = new ImageView();
        oneScreen = new Button();
        doubleScreens = new Button();
        back = new Button();

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

        oneScreen.setId("button");
        oneScreen.setLayoutX(217.0);
        oneScreen.setLayoutY(289.0);
        oneScreen.setMnemonicParsing(false);
        oneScreen.setPrefHeight(47.0);
        oneScreen.setPrefWidth(254.0);
        oneScreen.setText("One Screen");

        doubleScreens.setId("button");
        doubleScreens.setLayoutX(217.0);
        doubleScreens.setLayoutY(356.0);
        doubleScreens.setMnemonicParsing(false);
        doubleScreens.setPrefHeight(47.0);
        doubleScreens.setPrefWidth(254.0);
        doubleScreens.setText("Double Screens");

        back.setId("button");
        back.setLayoutX(217.0);
        back.setLayoutY(424.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(47.0);
        back.setPrefWidth(254.0);
        back.setText("Back");

        pane.getChildren().add(imageView);
        pane.getChildren().add(oneScreen);
        pane.getChildren().add(doubleScreens);
        pane.getChildren().add(back);
        getChildren().add(pane);
        
        oneScreen.setOnAction((Action)-> {
            AllPanes.xoGame.player2.setText("Player 2");
            AllPanes.viewPane(AllPanes.xoGame);
        });
        
        doubleScreens.setOnAction((Action)-> {
            AllPanes.viewPane(AllPanes.networkMultiplayerOptions);
        });
        
        back.setOnAction((Action)-> {
            AllPanes.viewPane(AllPanes.multiplayerOptions);
        });

    }
}
