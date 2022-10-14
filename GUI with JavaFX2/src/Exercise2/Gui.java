package Exercise2;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;

public class Gui extends Application {

  
    @Override
    public void start(Stage stage) {
        stage.setTitle("Person administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();
    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final CheckBox chkSenior = new CheckBox();

    private void initContent(GridPane pane) {

        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        Label lblTitle = new Label("Title:");
        pane.add(lblTitle, 0,1);

        Label lblNames = new Label("Persons:");
        pane.add(lblNames, 0, 3);

        pane.add(txfName, 1, 0, 2, 1);
        pane.add(txfTitle, 1,1,2,1);

        pane.add(chkSenior, 1,2);
        Label lblSenior = new Label("Senior");
        pane.add(lblSenior, 2,2);

        // add a listView to the pane(at col=1, row=0)
        pane.add(lvwPersons, 1, 3, 2, 5);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);

        ChangeListener<Person> listener = (ov, oldPerson, newPerson) -> this.selectionChanged();
        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwPersons.getSelectionModel().clearSelection();

        Button btnAdd = new Button("Add person");
        pane.add(btnAdd, 3, 2);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());

    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {
        String name = "";
        String title = "";
        if (txfName.getText().trim().isEmpty()) {
            Dialog<String> dialogName = new TextInputDialog();
            dialogName.setTitle("No name");
            dialogName.setHeaderText("You need to enter a name");
            Optional<String> resultName = dialogName.showAndWait();

            String inputName = "";
            if (resultName.isPresent()) {
                inputName = resultName.get();
                if (inputName.length() > 0) {
                    name = inputName.trim();
                }
            }
        } else {
            name = txfName.getText().trim();
        }
        if (txfTitle.getText().trim().isEmpty()) {
            Dialog<String> dialogTitle = new TextInputDialog();
            dialogTitle.setTitle("No title");
            dialogTitle.setHeaderText("You need to enter a title");
            Optional<String> resultTitle = dialogTitle.showAndWait();

            String inputTitle = "";
            if (resultTitle.isPresent()) {
                inputTitle = resultTitle.get();
                if (inputTitle.length() > 0) {
                    title = inputTitle.trim();
                }
            }
        } else {
            title = txfTitle.getText().trim();
        }
        if (name.length() > 0 && title.length() > 0) {
            Person p = new Person(name, title, chkSenior.isSelected());
            persons.add(p);
            lvwPersons.getItems().setAll(persons);
        }
    }

    // -------------------------------------------------------------------------
    // Selection changed action

    private void selectionChanged() {
        Person newPerson = lvwPersons.getSelectionModel().getSelectedItem();
        if (newPerson != null) {
            txfName.setText(newPerson.getFirstName());
            txfTitle.setText(newPerson.getTitle());
            chkSenior.setSelected(newPerson.isSenior());
        } else {
            txfName.clear();
            txfTitle.clear();
        }
    }
}
