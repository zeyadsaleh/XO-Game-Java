package TicTacToe;

import java.util.Vector;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Record extends AnchorPane {

    protected final Pane pane;
    protected final Button back;
    protected final ScrollPane scrollPane;
    protected final VBox vBox;
    protected final ImageView imageView;
    protected Button record;
    public int playerid1;
    public String playername1;

    protected Vector<Button> recordBtns = new Vector<>();
    DbFunctions theGame = new DbFunctions();

    public Record() {

        pane = new Pane();
        back = new Button();
        scrollPane = new ScrollPane();
        vBox = new VBox();
        imageView = new ImageView();

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
        back.setLayoutX(28.0);
        back.setLayoutY(447.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(47.0);
        back.setPrefWidth(168.0);
        back.setText("Back");

        scrollPane.setId("scrollpane");
        scrollPane.setLayoutX(268.0);
        scrollPane.setLayoutY(243.0);
        scrollPane.setPrefHeight(271.0);
        scrollPane.setPrefWidth(362.0);

        vBox.setPrefHeight(268.0);
        vBox.setPrefWidth(340.0);

        scrollPane.setContent(vBox);

        imageView.setFitHeight(151.0);
        imageView.setFitWidth(480.0);
        imageView.setLayoutX(114.0);
        imageView.setLayoutY(70.0);
        imageView.setImage(new Image(getClass().getResource("logooo.png").toExternalForm()));

        pane.getChildren().add(back);
        pane.getChildren().add(scrollPane);
        getChildren().add(pane);
        getChildren().add(imageView);

        back.setOnAction((Action) -> {
            AllPanes.viewPane(AllPanes.mainMenu);
        });

    }

    public void addRecord(String r) {

        record = new Button();
        record.setId("record");
        record.setMnemonicParsing(false);
        scrollPane.setLayoutX(280.0);
        scrollPane.setLayoutY(243.0);
        record.setPrefHeight(46.0);
        record.setPrefWidth(340.0);
        
        record.setText(r);
        recordBtns.add(record);
        addActionToButtons();
        vBox.getChildren().add(record);

    }

    public void addActionToButtons() {

        for (Button recordbtn : recordBtns) {
            recordbtn.addEventHandler(ActionEvent.ACTION, e -> {
                actionPerformed(e);
            });
        }
    }

    public void actionPerformed(ActionEvent e) {
        Button clickedButton = (Button) e.getSource();
        String x = clickedButton.getText();
        String[] date_name = x.split("     ");
        AllPanes.xoRecords.moves = theGame.returnGame(date_name[1], playerid1, date_name[0]);
        AllPanes.xoRecords.playername2 = date_name[0];
        AllPanes.xoRecords.playername1 = playername1;
        AllPanes.viewPane(AllPanes.xoRecords);

    }
}
