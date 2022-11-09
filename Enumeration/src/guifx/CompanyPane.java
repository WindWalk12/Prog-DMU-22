package guifx;

import application.controller.Controller;
import application.model.Company;
import application.model.Customer;
import application.model.Employee;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Optional;

public class CompanyPane extends GridPane {
	private TextField txfName, txfHours;
	private TextArea txaEmps, txaCustomers;
	private ListView<Company> lvwCompanies;
	private final ToggleGroup group = new ToggleGroup();

	public CompanyPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblComp = new Label("Companies");
		this.add(lblComp, 0, 0);

		lvwCompanies = new ListView<>();
		this.add(lvwCompanies, 0, 1, 1, 3);
		lvwCompanies.setPrefWidth(200);
		lvwCompanies.setPrefHeight(150);
		lvwCompanies.getItems().setAll(Controller.getCompanies());

		ChangeListener<Company> listener = (ov, oldCompany, newCompany) -> this.selectedCompanyChanged();
		lvwCompanies.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblName = new Label("Name:");
		this.add(lblName, 1, 1);

		txfName = new TextField();
		this.add(txfName, 2, 1);
		txfName.setEditable(false);

		Label lblEmps = new Label("Employees:");
		this.add(lblEmps, 1, 3);
		GridPane.setValignment(lblEmps, VPos.BASELINE);
		lblEmps.setPadding(new Insets(4, 0, 4, 0));

		txaEmps = new TextArea();
		this.add(txaEmps, 2, 3);
		txaEmps.setPrefWidth(200);
		txaEmps.setPrefHeight(100);
		txaEmps.setEditable(false);

		Label lblCustomers = new Label("Customers:");
		this.add(lblCustomers, 1, 4);
		GridPane.setValignment(lblCustomers, VPos.BASELINE);
		lblCustomers.setPadding(new Insets(4, 0, 4, 0));

		txaCustomers = new TextArea();
		this.add(txaCustomers, 2, 4);
		txaCustomers.setPrefWidth(200);
		txaCustomers.setPrefHeight(100);
		txaCustomers.setEditable(false);

		HBox hbxButtons = new HBox(20);
		this.add(hbxButtons, 1, 6, 3, 1);
		//hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_LEFT);

		Button btnCreateCustomer = new Button("Create customer");
		hbxButtons.getChildren().add(btnCreateCustomer);
		btnCreateCustomer.setOnAction(event -> this.createCustomer());

		Button btnCreate = new Button("Create");
		hbxButtons.getChildren().add(btnCreate);
		btnCreate.setOnAction(event -> this.createAction());

		Button btnUpdate = new Button("Update");
		hbxButtons.getChildren().add(btnUpdate);
		btnUpdate.setOnAction(event -> this.updateAction());

		Button btnDelete = new Button("Delete");
		hbxButtons.getChildren().add(btnDelete);
		btnDelete.setOnAction(event -> this.deleteAction());

		if (lvwCompanies.getItems().size() > 0) {
			lvwCompanies.getSelectionModel().select(0);
		}

		Button btnClose = new Button("Close");
		btnClose.setOnAction(event -> this.closeAction());
		this.add(btnClose, 0,6);

		String[] sizeNames = {"Micro", "Small", "Medium", "Big"};
		Company.Sizes[] sizes = Company.Sizes.values();
		VBox box = new VBox();
		this.add(box, 0, 4);
		for (int i = 0; i < Company.Sizes.values().length; i++) {
			RadioButton rb = new RadioButton();
			box.getChildren().add(rb);
			rb.setText(sizeNames[i]);
			rb.setUserData(sizes[i]);
			rb.setToggleGroup(group);
			rb.setOnAction(event -> this.updateCompaniesList());
		}
		RadioButton rbAll = new RadioButton("All");
		box.getChildren().add(rbAll);
		rbAll.setToggleGroup(group);
		rbAll.setOnAction(event -> this.updateCompaniesList());
	}

	// -------------------------------------------------------------------------

	private void createAction() {
		CompanyWindow dia = new CompanyWindow("Create Company");
		dia.showAndWait();

		// Wait for the modal dialog to close

		lvwCompanies.getItems().setAll(Controller.getCompanies());
		int index = lvwCompanies.getItems().size() - 1;
		lvwCompanies.getSelectionModel().select(index);
	}

	private void createCustomer() {
		CustomerWindow dia = new CustomerWindow("Create customer");
		dia.showAndWait();

		// Wait for the modal dialog to close

		this.updateControls();
	}

	private void updateAction() {
		Company company = lvwCompanies.getSelectionModel().getSelectedItem();
		if (company != null) {

			CompanyWindow dia = new CompanyWindow("Update Company", company);
			dia.showAndWait();

			// Wait for the modal dialog to close

			int selectIndex = lvwCompanies.getSelectionModel().getSelectedIndex();
			lvwCompanies.getItems().setAll(Controller.getCompanies());
			lvwCompanies.getSelectionModel().select(selectIndex);
		}
	}

	private void deleteAction() {
		Company company = lvwCompanies.getSelectionModel().getSelectedItem();
		if (company != null) {

			if (company.employeesCount() == 0) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Delete Company");
				// alert.setContentText("Are you sure?");
				alert.setHeaderText("Are you sure?");
				Optional<ButtonType> result = alert.showAndWait();
				if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
					Controller.deleteCompany(company);
					lvwCompanies.getItems().setAll(Controller.getCompanies());
					this.updateControls();
				}

			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Delete Company");
				alert.setHeaderText("Can't delete a company that has employees");
				// wait for the modal dialog to close
				alert.show();
			}
		}
	}

	private void closeAction() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Delete Employee");
		alert.setHeaderText("Are you sure?");
		Optional<ButtonType> result = alert.showAndWait();

		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
			Platform.exit();
		}
	}

	// -------------------------------------------------------------------------

	private void selectedCompanyChanged() {
		this.updateControls();
	}

	public void updateCompaniesList() {
		if (group.getSelectedToggle() != null) {
			RadioButton rb = (RadioButton) group.getSelectedToggle();
			Company.Sizes sizes = (Company.Sizes) rb.getUserData();
			if (sizes != null) {
				switch (sizes) {
					case MICRO:
						lvwCompanies.getItems().setAll(Controller.getCompaniesBySize(Company.Sizes.MICRO));
						break;
					case SMALL:
						lvwCompanies.getItems().setAll(Controller.getCompaniesBySize(Company.Sizes.SMALL));
						break;
					case MEDIUM:
						lvwCompanies.getItems().setAll(Controller.getCompaniesBySize(Company.Sizes.MEDIUM));
						break;
					case BIG:
						lvwCompanies.getItems().setAll(Controller.getCompaniesBySize(Company.Sizes.BIG));
						break;
					default:
						lvwCompanies.getItems().setAll(Controller.getCompanies());
						break;
				}
			} else {
				lvwCompanies.getItems().setAll(Controller.getCompanies());
			}
		}
	}
	public void updateControls() {
		Company company = lvwCompanies.getSelectionModel().getSelectedItem();
		if (company != null) {
			txfName.setText(company.getName());
			StringBuilder sb = new StringBuilder();
			for (Employee emp : company.getEmployees()) {
				sb.append(emp + "\n");
			}
			txaEmps.setText(sb.toString());
			StringBuilder sb2 = new StringBuilder();
			for (Customer customer :company.getCustomers()) {
				sb2.append(customer + "\n");
			}
			txaCustomers.setText(sb2.toString());
		} else {
			txfName.clear();
			txaEmps.clear();
			txaCustomers.clear();
		}
	}

}
