package Exercise1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class Combine extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Combine name");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final TextField txtName = new TextField();
    private final TextField txtLastname = new TextField();
    private final TextField txtCombined = new TextField();
    private final Button btnCombine = new Button("Combine");

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        txtName.setEditable(true);
        txtName.setPrefWidth(120);
        txtName.setPrefHeight(20);
        pane.add(txtName, 0,0);

        txtLastname.setEditable(true);
        txtLastname.setPrefWidth(120);
        txtLastname.setPrefHeight(20);
        pane.add(txtLastname, 1,0);

        txtCombined.setEditable(false);
        txtCombined.setPrefWidth(240);
        txtCombined.setPrefHeight(20);
        pane.add(txtCombined, 0,1, 2, 1);

        pane.add(btnCombine, 0,2);

        btnCombine.setOnAction(event -> this.combine());
    }

    private void combine() {
        if (txtName != null && txtLastname != null) {
            String combined = txtName.getText() + " " + txtLastname.getText();
            txtCombined.setText(combined);
        }
    }
}
