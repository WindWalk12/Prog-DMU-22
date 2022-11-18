package Exercise1.Application.Controller;

import Exercise1.Application.Model.Customer;
import Exercise1.Storage.CustomerStorage;
import javafx.scene.control.RadioButton;

import java.util.ArrayList;

public class CustomerController {

    public static ArrayList<Customer> getCustomers() {
        return new ArrayList<Customer>(CustomerStorage.getAll());
    }

    public static ArrayList<Customer> filterByName(String name) {
        ArrayList<Customer> customersBySearch = new ArrayList<>();
        for (Customer c: CustomerController.getCustomers()) {
            if (c.getName().contains(name)) {
                customersBySearch.add(c);
            }
        }
        return customersBySearch;
    }

    public static ArrayList<Customer> filterByCategory(RadioButton rb) {
        ArrayList<Customer> customersByCategory = new ArrayList<>();
        for (Customer c: getCustomers()) {
            if (c.getCategory() == rb.getUserData()) {
                customersByCategory.add(c);
            }
        }
        return customersByCategory;
    }
}
