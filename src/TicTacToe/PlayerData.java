package TicTacToe;

import java.util.Vector;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public  class PlayerData extends AnchorPane {

    protected final Pane pane;
    protected final ImageView imageView;
    protected final Button back;
    protected final Button enter;
    protected final TextField IDtextField;
    protected final Label userName;
    protected final TextField nameTextField;
    protected final Label ID;
    
    public boolean isNewPlayer;
    DbFunctions dbfunction = new DbFunctions();
    String playername;
    int count = 0;
    int playerid;

    Vector<String> allRecord = new Vector<>();


    public PlayerData() {

        pane = new Pane();
        imageView = new ImageView();
        back = new Button();
        enter = new Button();
        IDtextField = new TextField();
        userName = new Label();
        nameTextField = new TextField();
        ID = new Label();

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
        back.setLayoutX(129.0);
        back.setLayoutY(443.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(47.0);
        back.setPrefWidth(168.0);
        back.setText("Back");

        enter.setId("button");
        enter.setLayoutX(344.0);
        enter.setLayoutY(443.0);
        enter.setMnemonicParsing(false);
        enter.setPrefHeight(47.0);
        enter.setPrefWidth(183.0);
        enter.setText("Enter");


        userName.setLayoutX(110.0);
        userName.setLayoutY(287.0);
        userName.setPrefHeight(44.0);
        userName.setPrefWidth(205.0);
        userName.setText("User Name");
        userName.setFont(new Font("Segoe UI Black", 31.0));


        ID.setLayoutX(172.0);
        ID.setLayoutY(347.0);
        ID.setPrefHeight(44.0);
        ID.setPrefWidth(104.0);
        ID.setText("ID");
        ID.setFont(new Font("Segoe UI Black", 31.0));
        
        IDtextField.setLayoutX(322.0);
        IDtextField.setLayoutY(349.0);
        IDtextField.setPrefHeight(39.0);
        IDtextField.setPrefWidth(205.0);
        
        nameTextField.setLayoutX(322.0);
        nameTextField.setLayoutY(289.0);
        nameTextField.setPrefHeight(39.0);
        nameTextField.setPrefWidth(205.0);

        pane.getChildren().add(imageView);
        pane.getChildren().add(back);
        pane.getChildren().add(enter);
        pane.getChildren().add(IDtextField);
        pane.getChildren().add(userName);
        pane.getChildren().add(nameTextField);
        pane.getChildren().add(ID);
        getChildren().add(pane);
        
         enter.setOnAction((Action) -> {
            if (isNewPlayer == true) {
               String temp=nameTextField.getText();
               if(temp.equals(""))
               {   Alert a = new Alert(Alert.AlertType.NONE);
                    a.setAlertType(Alert.AlertType.WARNING);
                    a.setContentText("user name is empty");
                    a.show();}
            
               else{
                count++;
                if (IDtextField.getText().isEmpty() && count == 1) {
                    playername = nameTextField.getText();
                    playerid = dbfunction.insertPlayer(playername);
                    IDtextField.setText(Integer.toString(playerid));
                   

                } else {
                    AllPanes.mainMenu.scoreValue.setText("0");
                    AllPanes.record.playername1 = playername;
                    AllPanes.record.playerid1 = playerid;
                    AllPanes.xoGame_MultiPlayer.playername = playername;
                    AllPanes.xoGame_MultiPlayer.playerid = playerid;
                    AllPanes.xoGame.playername1 = playername;
                    AllPanes.xoGame.playerid1 = playerid;
                    
                  //  AllPanes.xoGame_MultiPlayer.player1.setText(nameTextField.getText());
                  //AllPanes.xoGame_MultiPlayer.player1score.setText("0");
                    AllPanes.xoGame.player1.setText(nameTextField.getText());
                    AllPanes.xoGame.player1score.setText("0");
                    AllPanes.viewPane(AllPanes.mainMenu);
                }}

            } else {

                playername = nameTextField.getText();

                try {
                    playerid = Integer.parseInt(IDtextField.getText());
                } catch (NumberFormatException e) {
                    e.getMessage();
                }

                if (dbfunction.check(playername, playerid)) {

                    Record record = new Record();
                    allRecord = dbfunction.returnAllGames(playerid);

                    for (int w = 0; w < allRecord.size(); w++) {
                        AllPanes.record.addRecord(allRecord.get(w));
                    }
                    int playerScore=dbfunction.selectScore(playerid);
                     AllPanes.mainMenu.scoreValue.setText(Integer.toString(playerScore));

                    AllPanes.xoGame.playername1 = playername;
                    AllPanes.xoGame.playerid1 = playerid;
                    AllPanes.xoGame_MultiPlayer.playername = playername;
                    AllPanes.xoGame_MultiPlayer.playerid = playerid;
                    AllPanes.record.playername1 = playername;
                    AllPanes.record.playerid1 = playerid;
                   // AllPanes.xoGame_MultiPlayer.player1.setText(nameTextField.getText());
                    //AllPanes.xoGame_MultiPlayer.player1score.setText("0");
                    AllPanes.xoGame.player1.setText(nameTextField.getText());
                    AllPanes.xoGame.player1score.setText("0");

                    AllPanes.viewPane(AllPanes.mainMenu);

                } else {

                    Alert a = new Alert(Alert.AlertType.NONE);
                    a.setAlertType(Alert.AlertType.WARNING);
                    a.setContentText("wrong name or passward");
                    a.show();
                }

            }

        });

        back.setOnAction((Action) -> {
            AllPanes.viewPane(AllPanes.registerMenu);
            nameTextField.setText("");

        });

    

    }
}
