package TicTacToe;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;


public class XORecords extends AnchorPane {

    protected final Pane pane;
    protected final Button back;
    protected final Button display;
    protected final Button btn5;
    protected final Button btn4;
    protected final Button btn3;
    protected final Button btn2;
    protected final Button btn1;
    protected final Button btn0;
    protected final Button btn8;
    protected final Button btn7;
    protected final Button btn6;
    protected final Label player1;
    protected final Label player2;
    protected final Label player1score;
    protected final Label player2score;
    protected final Label turnPlayer;
   
    protected String playername1;
    protected String playername2;
    protected int playerid1;
    protected String [] moves;
//    alert and image
       Image winImage = new Image("/TicTacToe/win2.gif");
    ImageView imageView = new ImageView();
     Alert alert = new Alert(AlertType.INFORMATION);
    
    
    public boolean isGameEnd;
    public boolean isPlayerOneTurn = true;
    public int counterGame = 0;
    public Button[] btns;
    public boolean isReco=false;
    String playch;
    

    public XORecords() {

        pane = new Pane();
        back = new Button();
        display = new Button();
        btn5 = new Button();
        btn4 = new Button();
        btn3 = new Button();
        btn2 = new Button();
        btn1 = new Button();
        btn0 = new Button();
        btn8 = new Button();
        btn7 = new Button();
        btn6 = new Button();
        player1 = new Label();
        player2 = new Label();
        player1score = new Label();
        player2score = new Label();
        turnPlayer = new Label();

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

        
         back.setId("button");
        back.setLayoutX(41.0);
        back.setLayoutY(355.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(47.0);
        back.setPrefWidth(168.0);
        back.setText("Back");

        display.setId("button");
        display.setLayoutX(45.0);
        display.setLayoutY(297.0);
        display.setMnemonicParsing(false);
        display.setPrefHeight(47.0);
        display.setPrefWidth(168.0);
        display.setText("Display");
        display.setTextFill(javafx.scene.paint.Color.WHITE);




        btn5.setLayoutX(529.0);
        btn5.setLayoutY(206.0);

        btn4.setLayoutX(414.0);
        btn4.setLayoutY(207.0);

        btn3.setLayoutX(299.0);
        btn3.setLayoutY(206.0);

        btn2.setLayoutX(529.0);
        btn2.setLayoutY(91.0);

        btn1.setLayoutX(414.0);
        btn1.setLayoutY(91.0);

        btn0.setLayoutX(299.0);
        btn0.setLayoutY(91.0);

        btn8.setLayoutX(529.0);
        btn8.setLayoutY(320.0);

        btn7.setLayoutX(414.0);
        btn7.setLayoutY(320.0);

        btn6.setLayoutX(299.0);
        btn6.setLayoutY(320.0);

        btns = new Button[]{btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8};

        for (int i = 0; i < 9; i++) {
            btns[i].setId(Integer.toString(i));
            btns[i].setMnemonicParsing(false);
            btns[i].setPrefHeight(115.0);
            btns[i].setPrefWidth(115.0);
            btns[i].getStylesheets().add("/projectfxml/newCascadeStyleSheet.css");
            btns[i].setText("");
            btns[i].setOpaqueInsets(new Insets(0.0));
        }

        player1.setLayoutX(246.0);
        player1.setLayoutY(468.0);
        player1.setPrefHeight(47.0);
        player1.setPrefWidth(168.0);
        player1.setText("Player 1");
        player1.setTextFill(javafx.scene.paint.Color.WHITE);
        player1.setFont(new Font("Algerian", 35.0));

        player2.setLayoutX(503.0);
        player2.setLayoutY(468.0);
        player2.setPrefHeight(47.0);
        player2.setPrefWidth(168.0);
        player2.setText("Player 2");
        player2.setTextFill(javafx.scene.paint.Color.WHITE);
        player2.setFont(new Font("Algerian", 35.0));

        player1score.setLayoutX(312.0);
        player1score.setLayoutY(515.0);
        player1score.setPrefHeight(47.0);
        player1score.setPrefWidth(36.0);
        player1score.setText("0");
        player1score.setTextFill(javafx.scene.paint.Color.WHITE);
        player1score.setFont(new Font("Algerian", 40.0));

        player2score.setLayoutX(569.0);
        player2score.setLayoutY(515.0);
        player2score.setPrefHeight(47.0);
        player2score.setPrefWidth(22.0);
        player2score.setText("0");
        player2score.setTextFill(javafx.scene.paint.Color.WHITE);
        player2score.setFont(new Font("Algerian", 40.0));

        turnPlayer.setLayoutX(434.0);
        turnPlayer.setLayoutY(479.0);
        turnPlayer.setPrefHeight(47.0);
        turnPlayer.setPrefWidth(36.0);
        turnPlayer.setText("0");
        turnPlayer.setTextFill(javafx.scene.paint.Color.WHITE);
        turnPlayer.setFont(new Font("Algerian", 64.0));

        pane.getChildren().add(back);
        pane.getChildren().add(display);
        pane.getChildren().add(btn5);
        pane.getChildren().add(btn4);
        pane.getChildren().add(btn3);
        pane.getChildren().add(btn2);
        pane.getChildren().add(btn1);
        pane.getChildren().add(btn0);
        pane.getChildren().add(btn8);
        pane.getChildren().add(btn7);
        pane.getChildren().add(btn6);
        pane.getChildren().add(player1);
        pane.getChildren().add(player2);
        pane.getChildren().add(player1score);
        pane.getChildren().add(player2score);
        pane.getChildren().add(turnPlayer);
        getChildren().add(pane);
  
        display.setOnAction(new EventHandler<ActionEvent>()
        {    
          
            @Override
            public void handle(ActionEvent event) {
                startGame();
                Runnable task = new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    playRecord();
                } catch (InterruptedException ex) {
                     System.out.println("cant run method");
                }
            }
        };
          
        Thread backgroundThread = new Thread(task);
        backgroundThread.setDaemon(true);
        backgroundThread.start();}
         
           
        });
       
        
        
        back.setOnAction((Action) -> {
             player1score.setText("0");
             player2score.setText("0");
             player1.setText("player1");
             player2.setText("player1");
            for(int i=0;i<9;i++){
            btns[i].setText("");
            btns[i].setStyle("-fx-background-color: burlywood;");
                }
                AllPanes.viewPane(AllPanes.record);
        
        });
        


    }
    
            
        
    
    
    
    public void startGame() {

        isGameEnd = false;
        setCurrentPlayer();
        isPlayerOneTurn=true;
         System.out.println(playername2);
        if(playername2.equals("player1"))
        {player1.setText(playername2);
        player2.setText(playername1);
        }
        else
        {player1.setText(playername1);
        player2.setText(playername2);}   
        player1score.setText("0");
        player2score.setText("0");
        for(int i=0;i<9;i++){
            btns[i].setText("");
            btns[i].setStyle("-fx-background-color: burlywood;");



        }
      

    }


    public void setCurrentPlayer() {
              
        if (isPlayerOneTurn == true) {
              //  final String x="X";
            turnPlayer.setText("x");
        } else {
            // final String O="O";
            turnPlayer.setText("o");
        }
        
    }
    
     public void playRecord() throws InterruptedException
   {   
        
    for(int m=0 ;m<9 && moves[m]!=null; m++)
      {
          try
            {  if(isPlayerOneTurn) {
                     playch="X";   
                }
                else {
                    playch="O";
                }
                 for(int c=0;c<9;c++)
                {
                   if(moves[m].equals(btns[c].getId()))
                    {  
                         Button playerBt=btns[c];
                       Platform.runLater(new Runnable() 
                       {
                           @Override
                           public void run() 
                           {  
                              playerBt.setText(playch);
                              setCurrentPlayer();
                              checkIfGameEnd();
                              isPlayerOneTurn=!isPlayerOneTurn;

                           }
                       });
                        break;
                     }}
                       
                       Thread.sleep(3000);
                       
                   }
            catch (InterruptedException e) 
            {
               System.out.println("thread has a problem");
            }
         
       
        
        // 
         
         }}
       
    
   
     public void checkIfGameEnd() {

        String A1 = btn0.getText();
        String A2 = btn1.getText();
        String A3 = btn2.getText();
        String B1 = btn3.getText();
        String B2 = btn4.getText();
        String B3 = btn5.getText();
        String C1 = btn6.getText();
        String C2 = btn7.getText();
        String C3 = btn8.getText();

        if (A1.equals(A2) && A1.equals(A3) && !A1.equals("")) {
            isGameEnd = true;
            colorWinnerButtons(btn0, btn1, btn2);
        }

        if (B1.equals(B2) && B1.equals(B3) && !B1.equals("")) {
            isGameEnd = true;
            colorWinnerButtons(btn3, btn4, btn5);
        }

        if (C1.equals(C2) && C1.equals(C3) && !C1.equals("")) {
            isGameEnd = true;
            colorWinnerButtons(btn6, btn7, btn8);
        }

        if (A1.equals(B1) && A1.equals(C1) && !A1.equals("")) {
            isGameEnd = true;
            colorWinnerButtons(btn0, btn3, btn6);
        }

        if (A2.equals(B2) && A2.equals(C2) && !A2.equals("")) {
            isGameEnd = true;
            colorWinnerButtons(btn1, btn4, btn7);
        }

        if (A3.equals(B3) && A3.equals(C3) && !A3.equals("")) {
            isGameEnd = true;
            colorWinnerButtons(btn2, btn5, btn8);
        }

        if (A1.equals(B2) && A1.equals(C3) && !A1.equals("")) {
            isGameEnd = true;
            colorWinnerButtons(btn0, btn4, btn8);
        }

        if (A3.equals(B2) && A3.equals(C1) && !A3.equals("")) {
            isGameEnd = true;
            colorWinnerButtons(btn2, btn4, btn6);
        }

          if(isGameEnd == true )
        {
            if(isPlayerOneTurn)
                player1score.setText(Integer.valueOf(player1score.getText()) + 1 + "");
    
            else
                player2score.setText(Integer.valueOf(player2score.getText()) + 1 + "");

            counterGame = 0;
            display.requestFocus();
            
        }
        
        if( counterGame >= 9)
        {   
            isGameEnd = true;
            isPlayerOneTurn = true;
            counterGame = 0;
        }

    }

    
      private void colorWinnerButtons(Button b1, Button b2, Button b3)
    {
        //               Media sound = new Media(new File("/TicTacToe/B.wav").toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.play();
//   
//      AudioClip p=new AudioClip(new File("./src/TicTacToe/Baby.mp3").toURI().toString());
//          p.play();     
            alert.setTitle("Winner");
            imageView.setImage(winImage);
            alert.setGraphic(imageView);
            alert.showAndWait();
        b1.setStyle("-fx-background-color: lightcoral;");
        b2.setStyle("-fx-background-color: lightcoral;");
        b3.setStyle("-fx-background-color: lightcoral;");
    }
    
    
}



  