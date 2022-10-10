package Exercise5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CelsiusToF extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Celsius to Fehrenheit");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final TextField txtCelsius = new TextField();
    private final TextField txtFahrenheit = new TextField();
    private final Label labelCelsius = new Label("Celsius");
    private final Label labelFahrenheit = new Label("Fahrenheit");
    private final Button btnCelsius = new Button("Calc Fahrenheit");
    private final Button btnFahrenheit = new Button("Calc Celsius");

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        txtCelsius.setEditable(true);
        txtCelsius.setPrefWidth(120);
        txtCelsius.setPrefHeight(20);
        pane.add(txtCelsius, 1,1);

        txtFahrenheit.setEditable(true);
        txtFahrenheit.setPrefWidth(120);
        txtFahrenheit.setPrefHeight(20);
        pane.add(txtFahrenheit, 1,2);

        pane.add(labelCelsius, 0, 1);
        pane.add(labelFahrenheit, 0, 2);


        pane.add(btnCelsius, 0,3);
        pane.add(btnFahrenheit, 1, 3);

        btnCelsius.setOnAction(event -> this.calcFehrenheit());
        btnFahrenheit.setOnAction(event -> this.calcCelsius());
    }

    private void calcFehrenheit() {
        double c = Double.parseDouble(txtCelsius.getText());
        double f = (c * 9.0/5.0) + 32.0;;
        txtFahrenheit.setText(String.valueOf(f));
    }

    private void calcCelsius() {
        double f = Double.parseDouble(txtFahrenheit.getText());
        double c = (f - 32.0) * 5.0/9.0;
        txtCelsius.setText(String.valueOf(c));
    }
}
