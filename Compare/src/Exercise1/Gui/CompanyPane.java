package Exercise1.Gui;

import Exercise1.Application.Controller.CustomerController;
import Exercise1.Application.Model.Customer;
import Exercise1.Storage.CustomerStorage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Collections;

public class CompanyPane extends GridPane {
	private ListView<Customer> lvwCompanies;

	public CompanyPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblComp = new Label("Companies");
		this.add(lblComp, 0, 0);

		lvwCompanies = new ListView<>();
		this.add(lvwCompanies, 0, 1, 1, 3);
		lvwCompanies.setPrefWidth(600);
		lvwCompanies.setPrefHeight(300);
		lvwCompanies.getItems().setAll(CustomerController.getCustomers());


		HBox hbxButtons = new HBox(40);
		this.add(hbxButtons, 0, 4, 3, 1);
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_CENTER);

		Button btnCreate = new Button("By Name");
		hbxButtons.getChildren().add(btnCreate);
		btnCreate.setOnAction(event -> this.orderByName());

		Button btnUpdate = new Button("By Address");
		hbxButtons.getChildren().add(btnUpdate);
		btnUpdate.setOnAction(event -> this.orderByAddress());

		Button btnDelete = new Button("By Category");
		hbxButtons.getChildren().add(btnDelete);
		btnDelete.setOnAction(event -> this.orderBySizeCategory());

	}

	// -------------------------------------------------------------------------

	private void orderByName() {
		Collections.sort(lvwCompanies.getItems());
	}

	private void orderByAddress() {
	}

	private void orderBySizeCategory() {
	}

}
