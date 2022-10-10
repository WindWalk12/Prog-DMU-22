package Exercise4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Count extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Count");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final TextField txtNumber = new TextField();
    private final Button btnPlus = new Button("+");
    private final Button btnMinus = new Button("-");

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        txtNumber.setEditable(false);
        txtNumber.setPrefWidth(120);
        txtNumber.setPrefHeight(20);
        txtNumber.setText("50");
        pane.add(txtNumber, 0,1);


        pane.add(btnPlus, 1,0);
        pane.add(btnMinus, 1, 2);

        btnPlus.setOnAction(event -> this.plus());
        btnMinus.setOnAction(event -> this.minus());
    }

    private void plus() {
        int number = Integer.parseInt(txtNumber.getText());
        number++;
        txtNumber.setText(String.valueOf(number));
    }

    private void minus() {
        int number = Integer.parseInt(txtNumber.getText());
        number--;
        txtNumber.setText(String.valueOf(number));
    }
}
