package TicTacToe;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class RegisterMenu extends AnchorPane {

    protected final Pane pane;
    protected final ImageView imageView;
    protected final Button NewPlayer;
    protected final Button OldPlayer;

    public RegisterMenu() {

        pane = new Pane();
        imageView = new ImageView();
        NewPlayer = new Button();
        OldPlayer = new Button();

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

        NewPlayer.setId("button");
        NewPlayer.setLayoutX(79.0);
        NewPlayer.setLayoutY(289.0);
        NewPlayer.setMnemonicParsing(false);
        NewPlayer.setPrefHeight(47.0);
        NewPlayer.setPrefWidth(254.0);
        NewPlayer.setText("New Player");

        OldPlayer.setId("button");
        OldPlayer.setLayoutX(323.0);
        OldPlayer.setLayoutY(377.0);
        OldPlayer.setMnemonicParsing(false);
        OldPlayer.setPrefHeight(47.0);
        OldPlayer.setPrefWidth(254.0);
        OldPlayer.setText("Old Player");

        pane.getChildren().add(imageView);
        pane.getChildren().add(NewPlayer);
        pane.getChildren().add(OldPlayer);
        getChildren().add(pane);
        
         NewPlayer.setOnAction((Action) -> {
            
            AllPanes.playerData.isNewPlayer=true;
            AllPanes.playerData.IDtextField.setEditable(false);
            AllPanes.viewPane(AllPanes.playerData);
           
        });
        
        OldPlayer.setOnAction((Action) -> {
            
            AllPanes.playerData.isNewPlayer=false;
            AllPanes.playerData.IDtextField.setEditable(true);
            AllPanes.viewPane(AllPanes.playerData);
           
        });

    }
}
