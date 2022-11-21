package Exercise3.Application.Controller;

import Exercise3.Application.Model.Customer;
import Exercise3.Storage.CustomerStorage;
import javafx.scene.control.RadioButton;

import java.util.ArrayList;

public class CustomerController {

    public static ArrayList<Customer> getCustomers() {
        return new ArrayList<Customer>(CustomerStorage.getAll());
    }

    public static ArrayList<Customer> filterByName(String name) {
        ArrayList<Customer> customersBySearch = new ArrayList<>();
        for (Customer c: CustomerController.getCustomers()) {
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {
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

    public static ArrayList<Customer> selectionSortName(ArrayList<Customer> customers) {
        for (int i = 0; i < customers.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < customers.size(); j++) {
                if (customers.get(j).compareTo(customers.get(index)) < 0) {
                    index = j;
                }
            }
            Customer temp = customers.get(index);
            customers.set(index, customers.get(i));
            customers.set(i, temp);
        }
        return customers;
    }
}
