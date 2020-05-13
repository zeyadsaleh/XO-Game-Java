package TicTacToe;

import java.util.Random;
import javafx.event.ActionEvent;
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

public class XOGame extends AnchorPane {

    protected final Pane pane;
    protected final Button back;
    protected final Button record;
    protected final Button newGame;
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
    protected int playerid1;

    public boolean isSinglePlayer;
    public boolean isLevelOne;
    public volatile boolean isGameEnd;
    public boolean isPlayerOneTurn = true;
    public int counterGame = 0;
    public Button[] btns;
//    image and alert
    Image winImage = new Image("/TicTacToe/win2.gif");
    ImageView imageView = new ImageView();
    Alert alert = new Alert(AlertType.INFORMATION);

    //updates for database and record
    DbFunctions recordGame = new DbFunctions();
    public String[] btnsId;
    static public int j = 0;
    public boolean isRecord = false;
    protected int playerScore;

    Random random = new Random();
    public int randomNumber;

    public XOGame() {

        pane = new Pane();
        back = new Button();
        record = new Button();
        newGame = new Button();
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

        record.setId("button");
        record.setLayoutX(45.0);
        record.setLayoutY(297.0);
        record.setMnemonicParsing(false);
        record.setPrefHeight(47.0);
        record.setPrefWidth(168.0);
        record.setText("Record");
        record.setTextFill(javafx.scene.paint.Color.WHITE);

        newGame.setId("button");
        newGame.setLayoutX(45.0);
        newGame.setLayoutY(232.0);
        newGame.setMnemonicParsing(false);
        newGame.setPrefHeight(47.0);
        newGame.setPrefWidth(168.0);
        newGame.setText("New Game");

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
        btnsId = new String[9];

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
        player1.setText("");
        player1.setTextFill(javafx.scene.paint.Color.WHITE);
        player1.setFont(new Font("Algerian", 35.0));

        player2.setLayoutX(503.0);
        player2.setLayoutY(468.0);
        player2.setPrefHeight(47.0);
        player2.setPrefWidth(180.0);
        player2.setText("");
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
        pane.getChildren().add(record);
        pane.getChildren().add(newGame);
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

        addActionToButtons();

        startGame();

        newGame.setOnAction((Action) -> {
            startGame();

        });

        back.setOnAction((Action) -> {

            for (int i = 0; i < 9; i++) {
                btns[i].setText("");
                btns[i].setStyle("-fx-background-color: burlywood;");
            }

            player1score.setText("0");
            player2score.setText("0");
            startGame();
            if (isSinglePlayer) {
                AllPanes.viewPane(AllPanes.SingleplayerLevels);
            } else {
                AllPanes.viewPane(AllPanes.localMultiplayerOptions);
            }

        });

        record.setOnAction((Action) -> {
            isRecord = true;
            startGame();

        });

    }

    private void storeGame() {

        String nameWithDate = recordGame.recordGame(playerid1, player2.getText(), btnsId);
        AllPanes.record.addRecord(nameWithDate);
        isRecord = false;
    }

    private void addActionToButtons() {

        for (int i = 0; i < 9; i++) {
            btns[i].addEventHandler(ActionEvent.ACTION, e -> {
                actionPerformed(e);
            });

        }

    }

    private void startGame() {

        counterGame = 0;
        isGameEnd = false;

        j = 0;

        setCurrentPlayer();

        for (int i = 0; i < 9; i++) {
            btns[i].setText("");
            btns[i].setStyle("-fx-background-color: burlywood;");
            btnsId[i] = null;

        }

    }

    private void setCurrentPlayer() {

        if (isPlayerOneTurn == true) {
            turnPlayer.setText("x");
        } else {
            turnPlayer.setText("o");
        }

    }

    private void actionPerformed(ActionEvent e) {

        Button clickedButton = (Button) e.getSource();

        if (isGameEnd == false && clickedButton.getText().equals("")) {
            if (isSinglePlayer == false) {
                if (isPlayerOneTurn) {
                    clickedButton.setText("X");
                    checkIfGameEnd();
                    if (isGameEnd) {
                        alert.setTitle("xWinner");
                        imageView.setImage(winImage);
                        alert.setGraphic(imageView);
                        alert.setHeaderText("Congratulations");
                        alert.showAndWait();
                    }

                } else {
                    clickedButton.setText("O");
                    checkIfGameEnd();
                    if (isGameEnd) {
                        alert.setTitle("oWinner");
                        imageView.setImage(winImage);
                        alert.setGraphic(imageView);
                        alert.setHeaderText("Congratulations");
                        alert.showAndWait();
                    }

                }
                btnsId[j] = clickedButton.getId();
                j++;
//                checkIfGameEnd();
                isPlayerOneTurn = !isPlayerOneTurn;
                setCurrentPlayer();
            }

            if (isSinglePlayer == true) {
                if (isLevelOne == true) {
                    turnPlayer.setText("");
                    counterGame++;
                    isPlayerOneTurn = true;
                    clickedButton.setText("X");
                    btnsId[j] = clickedButton.getId();
                    j++;
                    checkIfGameEnd();
                    if (isGameEnd) {
                        alert.setTitle("Winner");
                        imageView.setImage(winImage);
                        alert.setGraphic(imageView);
                        alert.setHeaderText("Congratulations");
                        alert.showAndWait();
                        setCurrentPlayer();
                    }

                    if (isGameEnd == false) {
                        isPlayerOneTurn = false;
                        removeActionToButton();
                        counterGame++;
                        while (true) {
                            randomNumber = random.nextInt(9);

                            if (btns[randomNumber].getText().equals("")) {
                                btns[randomNumber].setText("O");
                                btnsId[j] = btns[randomNumber].getId();
                                j++;
                                break;
                            }

                        }
                        checkIfGameEnd();

                        addActionToButtons();

                    }
                } else {
                    System.out.println("hi");
                    singlePlayerAI(clickedButton);

                }
            }

        }

    }

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

        if (isGameEnd == true) {
            if (isPlayerOneTurn) {
                player1score.setText(Integer.valueOf(player1score.getText()) + 1 + "");
                recordGame.updateScore(playerid1);
                playerScore = recordGame.selectScore(playerid1);
                AllPanes.mainMenu.scoreValue.setText(Integer.toString(playerScore));
            } else {
                player2score.setText(Integer.valueOf(player2score.getText()) + 1 + "");
            }

            counterGame = 0;
            newGame.requestFocus();

        }

        if (counterGame >= 9) {
            isGameEnd = true;
            isPlayerOneTurn = true;
            counterGame = 0;
        }

        if (isGameEnd == true && isRecord == true) {
            storeGame();
        }

    }

    private void removeActionToButton() {

        for (int i = 0; i < 9; i++) {
            btns[i].removeEventHandler(ActionEvent.ACTION, e -> {
                actionPerformed(e);
            });

        }

    }

    private void colorWinnerButtons(Button b1, Button b2, Button b3) {

        b1.setStyle("-fx-background-color: lightcoral;");
        b2.setStyle("-fx-background-color: lightcoral;");
        b3.setStyle("-fx-background-color: lightcoral;");
        //               Media sound = new Media(new File("/TicTacToe/B.wav").toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.play();
//   
//      AudioClip p=new AudioClip(new File("./src/TicTacToe/Baby.mp3").toURI().toString());
//          p.play();     
    }

//    endrandom
//    playWithComputer
    public void singlePlayerAI(Button clickedButton) {
//        
//                
//        
        counterGame++;
        isPlayerOneTurn = true;
        clickedButton.setText("X");
        btnsId[j] = clickedButton.getId();
        j++;
        checkIfGameEnd();
        setCurrentPlayer();
        if (isGameEnd == false) {
            removeActionToButton();

            counterGame++;
            isPlayerOneTurn = false;
            int pos = findBestMove();
            btns[pos].setText("O");
            System.out.println("pos" + pos);
            checkIfGameEnd();
            addActionToButtons();

        }
    }
//    Start@AI

    public int minimax(int depth, Boolean isPlayerOneTurn) {
//
        if (!isPlayerOneTurn) {
//            System.out.println("max");
            int best = -1000;
            for (int i = 0; i < 9; i++) {
                if (btns[i].getText().equals("")) {

                    best = Math.max(best, minimax(depth + 1, !isPlayerOneTurn));

                }

            }
            return best;
        } else {
//            System.out.println("min");
            int best = 1000;
            for (int i = 0; i < 9; i++) {
                if (btns[i].getText().equals("")) {

                    best = Math.min(best, minimax(depth + 1, !isPlayerOneTurn));

                }

            }
            return best;
        }

    }

    public int findBestMove() {
//        System.out.println("findBestMove");
        int bestVal = -1000;
        int move = 0;
        for (int i = 0; i < 9; i++) {
            if (btns[i].getText().equals("")) {
                btns[i].setText("O");

                int moveVal = minimax(0, false);
                btns[i].setText("");

//                    System.out.println("mov" + move);
                move = i;
                bestVal = moveVal;

            }
        }

        return move;
    }

}
