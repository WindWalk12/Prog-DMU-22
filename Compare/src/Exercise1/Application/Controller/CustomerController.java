package Exercise1.Application.Controller;

import Exercise1.Application.Model.Customer;
import Exercise1.Storage.CustomerStorage;

import java.util.ArrayList;

public class CustomerController {

    public static ArrayList<Customer> getCustomers() {
        return new ArrayList<Customer>(CustomerStorage.getAll());
    }
}
