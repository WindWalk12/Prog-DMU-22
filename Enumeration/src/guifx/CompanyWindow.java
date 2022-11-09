package guifx;

import application.controller.Controller;
import application.model.Company;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CompanyWindow extends Stage {
	private Company company;

	public CompanyWindow(String title, Company company) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.company = company;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public CompanyWindow(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------------

	private TextField txfName, txfHours;
	private Label lblError, lblSizes;

	private final ToggleGroup group = new ToggleGroup();

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblName = new Label("Name");
		pane.add(lblName, 0, 0);

		txfName = new TextField();
		pane.add(txfName, 0, 1);
		txfName.setPrefWidth(200);

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 7);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 0, 7);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> this.okAction());

		lblError = new Label();
		pane.add(lblError, 0, 6);
		lblError.setStyle("-fx-text-fill: red");

		String[] sizeNames = {"Micro", "Small", "Medium", "Big"};
		Company.Sizes[] sizes = Company.Sizes.values();
		lblSizes = new Label("Company size");
		pane.add(lblSizes, 0, 4);
		VBox box = new VBox();
		pane.add(box, 0, 5);
		for (int i = 0; i < Company.Sizes.values().length; i++) {
			RadioButton rb = new RadioButton();
			box.getChildren().add(rb);
			rb.setText(sizeNames[i]);
			rb.setUserData(sizes[i]);
			rb.setToggleGroup(group);
		}

		this.initControls();
	}

	private void initControls() {
		if (company != null) {
			txfName.setText(company.getName());
		} else {
			txfName.clear();
		}
	}

	// -------------------------------------------------------------------------

	private void cancelAction() {
		this.hide();
	}

	private void okAction() {
		String name = txfName.getText().trim();
		if (name.length() == 0) {
			lblError.setText("Name is empty");
		} else {
			int hours = -1;
			try {
				hours = Integer.parseInt(txfHours.getText().trim());
			} catch (NumberFormatException ex) {
				// do nothing
			}
			if (group.getSelectedToggle() == null) {
				lblError.setText("No company size is chosen");
			} else {
				RadioButton rb = (RadioButton) group.getSelectedToggle();
				Company.Sizes sizes = (Company.Sizes) rb.getUserData();
				if (hours < 0) {
					lblError.setText("Hours is not a positive number");
				} else {
					// Call application.controller methods
					if (company != null) {
						Controller.updateCompany(company, name, sizes);
					} else {
						Controller.createCompany(name, sizes);
					}

					this.hide();
				}
			}
		}
	}

}
