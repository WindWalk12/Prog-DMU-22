package Exercise1.Gui;

import Exercise1.Application.Controller.CustomerController;
import Exercise1.Application.Model.Customer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class CompanyPane extends GridPane {
	private ListView<Customer> lvwCompanies;
	private TextField txfByName;
	private final ToggleGroup group = new ToggleGroup();
	private final RadioButton rbMicro = new RadioButton("Micro");
	private final RadioButton rbSmall = new RadioButton("Small");
	private final RadioButton rbMedium = new RadioButton("Medium");
	private final RadioButton rbLarge = new RadioButton("Large");

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

		HBox hbxSearchByName = new HBox(10);
		this.add(hbxSearchByName, 0, 5);

		Button btnSearchByName = new Button("Search by name");
		hbxSearchByName.getChildren().add(btnSearchByName);
		btnSearchByName.setOnAction(event -> this.searchByName(txfByName.getText()));

		txfByName = new TextField();
		txfByName.setPrefWidth(100);
		hbxSearchByName.getChildren().add(txfByName);

		HBox hbxSearchByCategory = new HBox(10);
		this.add(hbxSearchByCategory, 0, 6);

		Button btnSearchByCategory = new Button("Search by Category");
		hbxSearchByName.getChildren().add(btnSearchByCategory);
		btnSearchByCategory.setOnAction(event -> this.searchByCategory());
		hbxSearchByName.getChildren().add(rbMicro);
		hbxSearchByName.getChildren().add(rbSmall);
		hbxSearchByName.getChildren().add(rbMedium);
		hbxSearchByName.getChildren().add(rbLarge);
		rbMicro.setToggleGroup(group);
		rbMicro.setUserData(Customer.SizeCategory.MICRO);
		rbSmall.setToggleGroup(group);
		rbSmall.setUserData(Customer.SizeCategory.SMALL);
		rbMedium.setToggleGroup(group);
		rbMedium.setUserData(Customer.SizeCategory.MEDIUM);
		rbLarge.setToggleGroup(group);
		rbLarge.setUserData(Customer.SizeCategory.LARGE);

	}

	// -------------------------------------------------------------------------

	private void orderByName() {
		lvwCompanies.getItems().sort(new Customer.CompareByName());
	}

	private void orderByAddress() {
		lvwCompanies.getItems().sort(new Customer.CompareByAddress());
	}

	private void orderBySizeCategory() {
		lvwCompanies.getItems().sort(new Customer.CompareByCategory());
	}

	private void searchByName(String name) {
		ArrayList<Customer> customersBySearch = new ArrayList<>();
		for (Customer c: CustomerController.getCustomers()) {
			if (c.getName().contains(name)) {
				customersBySearch.add(c);
			}
		}
		lvwCompanies.getItems().setAll(customersBySearch);
	}

	private void searchByCategory() {
		if (group.getSelectedToggle() != null) {
			ArrayList<Customer> customersByCategory = new ArrayList<>();
			RadioButton rb = (RadioButton) group.getSelectedToggle();
			for (Customer c: CustomerController.getCustomers()) {
				if (c.getCategory() == rb.getUserData()) {
					customersByCategory.add(c);
				}
			}
			lvwCompanies.getItems().setAll(customersByCategory);
			group.selectToggle(null);
		}
	}
}
