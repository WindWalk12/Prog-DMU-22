package Exercise3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Split extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Split text");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final TextField txtName = new TextField();
    private final TextField txtLastname = new TextField();
    private final TextField txtSplit = new TextField();
    private final Button btnSplit = new Button("Split");

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        txtName.setEditable(false);
        txtName.setPrefWidth(120);
        txtName.setPrefHeight(20);
        pane.add(txtName, 0,1);

        txtLastname.setEditable(false);
        txtLastname.setPrefWidth(120);
        txtLastname.setPrefHeight(20);
        pane.add(txtLastname, 1,1);

        txtSplit.setEditable(true);
        txtSplit.setPrefWidth(240);
        txtSplit.setPrefHeight(20);
        pane.add(txtSplit, 0,0, 2, 1);

        pane.add(btnSplit, 0,2);

        btnSplit.setOnAction(event -> this.combine());
    }

    private void combine() {
        if (txtSplit != null) {
            String[] split = txtSplit.getText().split(" ");
            txtName.setText(split[0]);
            txtLastname.setText(split[1]);
        }
    }
}
