package TicTacToe;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class SingleplayerLevels extends AnchorPane {

    protected final Pane pane;
    protected final ImageView imageView;
    protected final Button levelOne;
    protected final Button levelTwo;
    protected final Button back;

    public SingleplayerLevels() {

        pane = new Pane();
        imageView = new ImageView();
        levelOne = new Button();
        levelTwo = new Button();
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

        levelOne.setId("button");
        levelOne.setLayoutX(217.0);
        levelOne.setLayoutY(273.0);
        levelOne.setMnemonicParsing(false);
        levelOne.setPrefHeight(47.0);
        levelOne.setPrefWidth(254.0);
        levelOne.setText("Level One");

        levelTwo.setId("button");
        levelTwo.setLayoutX(217.0);
        levelTwo.setLayoutY(342.0);
        levelTwo.setMnemonicParsing(false);
        levelTwo.setPrefHeight(47.0);
        levelTwo.setPrefWidth(254.0);
        levelTwo.setText("Level Two");

        back.setId("button");
        back.setLayoutX(217.0);
        back.setLayoutY(415.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(47.0);
        back.setPrefWidth(254.0);
        back.setText("Back");

        pane.getChildren().add(imageView);
        pane.getChildren().add(levelOne);
        pane.getChildren().add(levelTwo);
        pane.getChildren().add(back);
        getChildren().add(pane);

        levelOne.setOnAction((Action) -> {
           AllPanes.xoGame.player2.setText("Computer");
            AllPanes.viewPane(AllPanes.xoGame);

        });
        back.setOnAction((Action) -> {
            AllPanes.viewPane(AllPanes.mainMenu);

        });

//        levelTwo.setOnAction((Action) -> {
//         AllPanes.viewPane(AllPanes.xoGame);
//        
//        });
    }
}
