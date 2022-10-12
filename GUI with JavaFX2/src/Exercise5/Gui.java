package Exercise5;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Boys and girls");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final ListView<String> lvwNames = new ListView<>();
    private final ArrayList<String> boysNames = new ArrayList<>();
    private final ArrayList<String> girlsNames = new ArrayList<>();
    private final ToggleGroup group = new ToggleGroup();
    private final RadioButton rbBoy = new RadioButton("Boy");
    private final RadioButton rbGirl = new RadioButton("Girl");

    private void initContent(GridPane pane) {

        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 2);

        // add a label to the pane (at col=0, row=1)
        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 1);
        GridPane.setValignment(lblNames, VPos.TOP);

        // add a text field to the pane (at col=1, row=0)
        pane.add(txfName, 1, 2, 3, 1);

        // add a listView to the pane(at col=1, row=1)
        pane.add(lvwNames, 1, 1, 3,1);
        lvwNames.setPrefWidth(200);
        lvwNames.setPrefHeight(200);

        ChangeListener<String> listener = (ov, oldString, newString) -> this.selectionChanged();
        lvwNames.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwNames.getSelectionModel().clearSelection();

        HBox box = new HBox();
        pane.add(box, 1, 0);
        box.getChildren().add(rbBoy);
        box.getChildren().add(rbGirl);
        rbBoy.setToggleGroup(group);
        rbGirl.setToggleGroup(group);

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 4, 2);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());
        rbBoy.setOnAction(event -> this.rbSelectionChanged());
        rbGirl.setOnAction(event -> this.rbSelectionChanged());
    }

    // -------------------------------------------------------------------------

    private void addAction() {
        String name = txfName.getText().trim();
        if (name.length() > 0 && (rbBoy.isSelected() || rbGirl.isSelected())) {
            if (rbBoy.isSelected()) {
                boysNames.add(name);
                lvwNames.getItems().setAll(boysNames);
                txfName.clear();
            } else if (rbGirl.isSelected()) {
                girlsNames.add(name);
                lvwNames.getItems().setAll(girlsNames);
                txfName.clear();
            }
        }
    }

    // -------------------------------------------------------------------------
    // Selection changed actions

    private void selectionChanged() {
        String selected = lvwNames.getSelectionModel().getSelectedItem();
        if (selected != null) {
            txfName.setText(selected);
        } else {
            txfName.clear();
        }
    }

    private void rbSelectionChanged() {
        if (rbBoy.isSelected()) {
            lvwNames.getItems().setAll(boysNames);
        } else if (rbGirl.isSelected()) {
            lvwNames.getItems().setAll(girlsNames);
        }
    }
}
