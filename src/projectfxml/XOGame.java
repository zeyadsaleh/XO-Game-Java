
package projectfxml;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public abstract class XOGame extends AnchorPane {

    protected final Pane pane;
    protected final Button back;
    protected final Button record;
    protected final Button newGame;
    protected final Button button2;
    protected final Button button3;
    protected final Button button4;
    protected final Button button5;
    protected final Button button6;
    protected final Button button7;
    protected final Button button8;
    protected final Button button9;
    protected final Button button10;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;

    public XOGame() {

        pane = new Pane();
        back = new Button();
        record = new Button();
        newGame = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();
        button6 = new Button();
        button7 = new Button();
        button8 = new Button();
        button9 = new Button();
        button10 = new Button();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();

        setId("background");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(578.0);
        setPrefWidth(688.0);
        getStylesheets().add("/projectfxml/newCascadeStyleSheet.css");

        pane.setId("background");
        pane.setLayoutX(-2.0);
        pane.setPrefHeight(578.0);
        pane.setPrefWidth(696.0);
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

        button2.setId("5");
        button2.setLayoutX(529.0);
        button2.setLayoutY(206.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(115.0);
        button2.setPrefWidth(115.0);
        button2.getStylesheets().add("/projectfxml/newCascadeStyleSheet.css");
        button2.setText("X");
        button2.setOpaqueInsets(new Insets(0.0));

        button3.setId("4");
        button3.setLayoutX(414.0);
        button3.setLayoutY(207.0);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(115.0);
        button3.setPrefWidth(115.0);
        button3.getStylesheets().add("/projectfxml/newCascadeStyleSheet.css");
        button3.setText("O");
        button3.setOpaqueInsets(new Insets(0.0));
        button3.setFont(new Font("Calisto MT Bold", 46.0));

        button4.setId("3");
        button4.setLayoutX(299.0);
        button4.setLayoutY(206.0);
        button4.setMnemonicParsing(false);
        button4.setPrefHeight(115.0);
        button4.setPrefWidth(115.0);
        button4.getStylesheets().add("/projectfxml/newCascadeStyleSheet.css");
        button4.setText("X");
        button4.setTextFill(javafx.scene.paint.Color.valueOf("#1470b7"));
        button4.setOpaqueInsets(new Insets(0.0));
        button4.setFont(new Font("Blackadder ITC", 12.0));

        button5.setId("2");
        button5.setLayoutX(529.0);
        button5.setLayoutY(91.0);
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(115.0);
        button5.setPrefWidth(115.0);
        button5.getStylesheets().add("/projectfxml/newCascadeStyleSheet.css");
        button5.setText("X");
        button5.setOpaqueInsets(new Insets(0.0));

        button6.setId("1");
        button6.setLayoutX(414.0);
        button6.setLayoutY(91.0);
        button6.setMnemonicParsing(false);
        button6.setPrefHeight(115.0);
        button6.setPrefWidth(115.0);
        button6.getStylesheets().add("/projectfxml/newCascadeStyleSheet.css");
        button6.setText("O");
        button6.setOpaqueInsets(new Insets(0.0));

        button7.setId("0");
        button7.setLayoutX(299.0);
        button7.setLayoutY(91.0);
        button7.setMnemonicParsing(false);
        button7.setPrefHeight(115.0);
        button7.setPrefWidth(115.0);
        button7.getStylesheets().add("/projectfxml/newCascadeStyleSheet.css");
        button7.setText("X");
        button7.setOpaqueInsets(new Insets(0.0));

        button8.setId("8");
        button8.setLayoutX(529.0);
        button8.setLayoutY(320.0);
        button8.setMnemonicParsing(false);
        button8.setPrefHeight(115.0);
        button8.setPrefWidth(115.0);
        button8.getStylesheets().add("/projectfxml/newCascadeStyleSheet.css");
        button8.setText("O");
        button8.setOpaqueInsets(new Insets(0.0));

        button9.setId("7");
        button9.setLayoutX(414.0);
        button9.setLayoutY(320.0);
        button9.setMnemonicParsing(false);
        button9.setPrefHeight(115.0);
        button9.setPrefWidth(115.0);
        button9.getStylesheets().add("/projectfxml/newCascadeStyleSheet.css");
        button9.setText("X");
        button9.setOpaqueInsets(new Insets(0.0));

        button10.setId("6");
        button10.setLayoutX(299.0);
        button10.setLayoutY(320.0);
        button10.setMnemonicParsing(false);
        button10.setPrefHeight(115.0);
        button10.setPrefWidth(115.0);
        button10.getStylesheets().add("/projectfxml/newCascadeStyleSheet.css");
        button10.setText("O");
        button10.setOpaqueInsets(new Insets(0.0));

        label.setLayoutX(246.0);
        label.setLayoutY(468.0);
        label.setPrefHeight(47.0);
        label.setPrefWidth(168.0);
        label.setText("Player 1");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Algerian", 35.0));

        label0.setLayoutX(503.0);
        label0.setLayoutY(468.0);
        label0.setPrefHeight(47.0);
        label0.setPrefWidth(168.0);
        label0.setText("Player 2");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("Algerian", 35.0));

        label1.setLayoutX(312.0);
        label1.setLayoutY(515.0);
        label1.setPrefHeight(47.0);
        label1.setPrefWidth(36.0);
        label1.setText("0");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("Algerian", 40.0));

        label2.setLayoutX(569.0);
        label2.setLayoutY(515.0);
        label2.setPrefHeight(47.0);
        label2.setPrefWidth(22.0);
        label2.setText("0");
        label2.setTextFill(javafx.scene.paint.Color.WHITE);
        label2.setFont(new Font("Algerian", 40.0));

        label3.setLayoutX(434.0);
        label3.setLayoutY(479.0);
        label3.setPrefHeight(47.0);
        label3.setPrefWidth(36.0);
        label3.setText("0");
        label3.setTextFill(javafx.scene.paint.Color.WHITE);
        label3.setFont(new Font("Algerian", 64.0));

        pane.getChildren().add(back);
        pane.getChildren().add(record);
        pane.getChildren().add(newGame);
        pane.getChildren().add(button2);
        pane.getChildren().add(button3);
        pane.getChildren().add(button4);
        pane.getChildren().add(button5);
        pane.getChildren().add(button6);
        pane.getChildren().add(button7);
        pane.getChildren().add(button8);
        pane.getChildren().add(button9);
        pane.getChildren().add(button10);
        pane.getChildren().add(label);
        pane.getChildren().add(label0);
        pane.getChildren().add(label1);
        pane.getChildren().add(label2);
        pane.getChildren().add(label3);
        getChildren().add(pane);

    }
}
