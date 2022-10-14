package Exercise3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Person administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        addPersonWindow = new addPersonInputWindow("Create a person", stage);
    }

    // -------------------------------------------------------------------------

    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();
    private addPersonInputWindow addPersonWindow;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // add a listView to the pane(at col=1, row=0)
        pane.add(lvwPersons, 1, 0, 2, 5);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);

        Button btnAddPerson = new Button("Add person");
        pane.add(btnAddPerson, 6, 2);
        GridPane.setMargin(btnAddPerson, new Insets(10, 10, 0, 10));
        btnAddPerson.setOnAction(event -> this.addPerson());

    }

    // -----------------------------------------------------
    // Button action

    private void addPerson() {
        addPersonWindow.showAndWait();

        // wait for the dialog to close ...

        if (addPersonWindow.getActualPerson() != null) {
            Person newPerson = addPersonWindow.getActualPerson();
            persons.add(newPerson);
            lvwPersons.getItems().setAll(persons);
        }
    }
}
