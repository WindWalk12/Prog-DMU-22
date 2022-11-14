package Exercise3;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        Product p1 = new Product(21, "Milk", 24.0);
        Product p2 = new Product(45, "Eggs", 10.97);
        Product p3 = new Product(12, "Candy worms", 15.0);
        Product p4 = new Product(190, "Candy bar", 43.97);
        Product p5 = new Product(1000, "Cola", 14.99);

        Customer c1 = new Customer("Bent", LocalDate.of(1985, 4, 25));
        Customer c2 = new Customer("Bob", LocalDate.of(2000, 11, 9));

        Order o1 = new Order(1);
        Order o2 = new Order(2);
        Order o3 = new Order(3);
        Order o4 = new Order(4);
        Order o5 = new Order(5);
        Order o6 = new Order(6);

        // Order 1
        o1.createOrderLine(4, p1);
        o1.createOrderLine(1, p4);

        // Order 2
        o2.createOrderLine(6, p2);
        o2.createOrderLine(1, p3);

        // Order 3
        o3.createOrderLine(2, p5);
        o3.createOrderLine(5, p2);

        // Order 4
        o4.createOrderLine(4, p1);
        o4.createOrderLine(10, p3);

        // Order 5
        o5.createOrderLine(19, p4);
        o5.createOrderLine(10, p4);

        // Order 6
        o6.createOrderLine(1, p1);
        o6.createOrderLine(2, p5);

        c1.addOrder(o2);
        c1.addOrder(o6);

        c2.addOrder(o1);
        c2.addOrder(o3);
        c2.addOrder(o4);
        c2.addOrder(o5);

        PercentDiscount pd1 = new PercentDiscount(15);
        FixedDiscount fd1 = new FixedDiscount(250, 1000);

        c1.setDiscount(pd1);
        c2.setDiscount(fd1);

        System.out.println("Total price without discount for c1");
        System.out.println(c1.totalBuy());
        System.out.println("Total price with discount for c1");
        System.out.println(c1.totalBuyWithDiscount());
        System.out.println();

        System.out.println("Total price without discount for c2");
        System.out.println(c2.totalBuy());
        System.out.println("Total price with discount for c2");
        System.out.println(c2.totalBuyWithDiscount());
    }
}
