package Exercise1;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Customer[] customers = new Customer[10];

        Customer c1 = new Customer("Mads", "Strandvjen 32", 8230, "Somewhere");
        c1.insertCustomer(customers, c1);

        Customer c2 = new Customer("Anders", "Strandvjen 33", 8230, "Somewhere");
        c2.insertCustomer(customers, c2);

        Customer c3 = new Customer("Andrea", "Idk", 8232, "Somewhere");
        c3.insertCustomer(customers, c3);

        System.out.println(Arrays.toString(customers));

        Customer c4 = new Customer("Andreas", "Idk", 8231, "Somewhere");
        c4.insertCustomer(customers, c4);

        System.out.println(Arrays.toString(customers));
    }
}
