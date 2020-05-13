package TicTacToe;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public  class MultiplayerOptions extends AnchorPane {

    protected final Pane pane;
    protected final ImageView imageView;
    protected final Button local;
    protected final Button network;
    protected final Button back;

    public MultiplayerOptions() {

        pane = new Pane();
        imageView = new ImageView();
        local = new Button();
        network = new Button();
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

        local.setId("button");
        local.setLayoutX(56.0);
        local.setLayoutY(290.0);
        local.setMnemonicParsing(false);
        local.setPrefHeight(47.0);
        local.setPrefWidth(254.0);
        local.setText("Local");

        network.setId("button");
        network.setLayoutX(384.0);
        network.setLayoutY(290.0);
        network.setMnemonicParsing(false);
        network.setPrefHeight(47.0);
        network.setPrefWidth(254.0);
        network.setText("Network");

        back.setId("button");
        back.setLayoutX(210.0);
        back.setLayoutY(401.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(47.0);
        back.setPrefWidth(254.0);
        back.setText("Back");

        pane.getChildren().add(imageView);
        pane.getChildren().add(local);
        pane.getChildren().add(network);
        pane.getChildren().add(back);
        getChildren().add(pane);
        
        local.setOnAction((Action)-> {
            AllPanes.viewPane(AllPanes.localMultiplayerOptions);
        });
        
        network.setOnAction((Action)-> {
            AllPanes.viewPane(AllPanes.networkMultiplayerOptions);
        });
        
        back.setOnAction((Action)-> {
            AllPanes.viewPane(AllPanes.mainMenu);
        });

    }
}
