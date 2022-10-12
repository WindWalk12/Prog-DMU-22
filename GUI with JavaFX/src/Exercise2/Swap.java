package Exercise2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Swap extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Swap text");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final TextField txtfield1 = new TextField();
    private final TextField txtfield2 = new TextField();
    private final Button btnSwap = new Button("Swap");

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        txtfield1.setEditable(true);
        txtfield1.setPrefWidth(120);
        txtfield1.setPrefHeight(20);
        pane.add(txtfield1, 0,0);

        txtfield2.setEditable(true);
        txtfield2.setPrefWidth(120);
        txtfield2.setPrefHeight(20);
        pane.add(txtfield2, 0,1);


        pane.add(btnSwap, 0,2);

        btnSwap.setOnAction(event -> this.swap());
    }

    private void swap() {
        if (txtfield1.getText().trim().isEmpty() && txtfield2.getText().trim().isEmpty()) {
            String temp = txtfield2.getText();
            txtfield2.setText(txtfield1.getText());
            txtfield1.setText(temp);
        }
    }
}
