package gui;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Yatzy;

public class YatzyGui extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // Shows the face values of the 5 dice.
    private TextField[] txfValues = new TextField[5];
    // Shows the hold status of the 5 dice.
    private CheckBox[] chbHolds = new CheckBox[5];
    // Shows the results previously selected .
    // For free results (results not set yet), the results
    // corresponding to the actual face values of the 5 dice are shown.
    private TextField[] txfResults = new TextField[15];
    // Shows points in sums, bonus and total.
    private TextField txfSumSame, txfBonus, txfSumOther, txfTotal;
    // Shows the number of times the dice has been rolled.
    private Label lblRolled, lblSumsSame, lblBonus, lblSumOther, lblTotal;

    private Button btnRoll = new Button("Roll");
    private boolean isFirstRound = true;
    private boolean gotBonus = false;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        // initialize txfValues, chbHolds, btnRoll and lblRolled
        for (int i = 0; i < txfValues.length; i++) {
            txfValues[i] = new TextField();
            txfValues[i].setPrefSize(70, 70);
            txfValues[i].setFont(Font.font("Comic Sans", FontWeight.BOLD, 35));
            txfValues[i].setAlignment(Pos.CENTER);
            txfValues[i].setEditable(false);
            dicePane.add(txfValues[i], i, 0);
            chbHolds[i] = new CheckBox("Hold");
            chbHolds[i].setDisable(true);
            dicePane.add(chbHolds[i], i, 1);
        }
        btnRoll.setFont(Font.font(20));
        dicePane.add(btnRoll, 3, 2);
        lblRolled = new Label("Rolled: " + yatzy.getThrowCount());
        dicePane.add(lblRolled, 4, 2);

        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int w = 50; // width of the text fields

        // Initialize labels for results, txfResults,
        // labels and text fields for sums, bonus and total.
        String[] nameArray = {"One's:", "Two's:", "Three's:", "Four's:", "Five's", "six's", "One pair:", "Two pairs", "Three of a kind:", "Four of a kind:", "Full house:", "Small straight:", "Large straight", "Chance:", "Yatzy:"};
        for (int i = 0; i < nameArray.length; i++) {
            Label gameName = new Label(nameArray[i]);
            scorePane.add(gameName, 0, i);
            txfResults[i] = new TextField();
            txfResults[i].setEditable(false);
            txfResults[i].setPrefWidth(60);
            txfResults[i].setAlignment(Pos.CENTER_RIGHT);
            txfResults[i].setDisable(true);
            txfResults[i].setId(String.valueOf(i));
            scorePane.add(txfResults[i], 1, i);
            txfResults[i].setOnMouseClicked(event -> fieldAction(event));
        }

        txfSumSame = new TextField("0");
        txfSumSame.setAlignment(Pos.CENTER_RIGHT);
        txfSumSame.setPrefWidth(60);
        txfSumSame.setEditable(false);
        scorePane.add(txfSumSame, 3, 5);

        txfBonus = new TextField("0");
        txfBonus.setAlignment(Pos.CENTER_RIGHT);
        txfBonus.setPrefWidth(60);
        txfBonus.setEditable(false);
        scorePane.add(txfBonus, 5, 5);

        txfSumOther = new TextField("0");
        txfSumOther.setAlignment(Pos.CENTER_RIGHT);
        txfSumOther.setPrefWidth(60);
        txfSumOther.setEditable(false);
        scorePane.add(txfSumOther, 3, 14);

        txfTotal = new TextField("0");
        txfTotal.setAlignment(Pos.CENTER_RIGHT);
        txfTotal.setPrefWidth(60);
        txfTotal.setEditable(false);
        scorePane.add(txfTotal, 5, 14);

        lblSumsSame = new Label("Sum:");
        scorePane.add(lblSumsSame, 2, 5);

        lblBonus = new Label("Bonus:");
        scorePane.add(lblBonus, 4, 5);

        lblSumOther = new Label("Sum:");
        scorePane.add(lblSumOther, 2, 14);

        lblTotal = new Label("Total:");
        scorePane.add(lblTotal, 4, 14);

        btnRoll.setOnAction(event -> this.buttonAction());
    }

    // -------------------------------------------------------------------------

    private Yatzy yatzy = new Yatzy();

    // Create a method for btnRoll's action.
    // Hint: Create small helper methods to be used in the action method.
    public void buttonAction() {
        if (isFirstRound) {
            for (int i = 0; i < chbHolds.length; i++) {
                chbHolds[i].setDisable(false);
            }
            for (int i = 0; i < txfResults.length; i++) {
                txfResults[i].setDisable(false);
            }
            isFirstRound = false;
        }
        boolean[] holdArray = new boolean[chbHolds.length];
        for (int i = 0; i < chbHolds.length; i++) {
            holdArray[i] = chbHolds[i].isSelected();
        }
        yatzy.throwDice(holdArray);
        int[] valueArray = yatzy.getValues();
        for (int i = 0; i < valueArray.length; i++) {
            txfValues[i].setText(String.valueOf(valueArray[i]));
        }
        lblRolled.setText("Rolled: " + yatzy.getThrowCount());

        if (yatzy.getThrowCount() == 3) {
            btnRoll.setDisable(true);
        }

        int[] results = yatzy.getResults();
        for (int i = 0; i < txfResults.length; i++) {
            if (!txfResults[i].isDisable()) {
                txfResults[i].setText(String.valueOf(results[i]));
            }
        }
    }

    // -------------------------------------------------------------------------

    // Create a method for mouse click on one of the text fields in txfResults.
    // Hint: Create small helper methods to be used in the mouse click method.
    public void fieldAction(Event event) {
        TextField txf = (TextField) event.getSource();
        yatzy.addTotalScore(Integer.parseInt(txf.getText()));
        txf.setDisable(true);
        if (Integer.parseInt(txf.getId()) >= 0 && Integer.parseInt(txf.getId()) <= 5) {
            yatzy.addSumUpper(Integer.parseInt(txf.getText()));
        } else {
            yatzy.addSumLower(Integer.parseInt(txf.getText()));
        }
        if (yatzy.getSumUpper() >= 63 && !gotBonus) {
            yatzy.addTotalScore(50);
            txfBonus.setText("50");
            gotBonus = true;
        }
        txfSumSame.setText(String.valueOf(yatzy.getSumUpper()));
        txfSumOther.setText(String.valueOf(yatzy.getSumLower()));
        txfTotal.setText(String.valueOf(yatzy.getTotalScore()));
        yatzy.resetThrowCount();
        btnRoll.setDisable(false);
        for (int i = 0; i < chbHolds.length; i++) {
            chbHolds[i].setSelected(false);
        }
        buttonAction();
    }

}
