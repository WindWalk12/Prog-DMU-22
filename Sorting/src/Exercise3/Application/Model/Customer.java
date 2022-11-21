package Exercise3.Application.Model;

import java.util.Comparator;

public class Customer {

    public enum SizeCategory {UNKNOWN, MICRO, SMALL, MEDIUM, LARGE};
    String name;
    String street;
    String zip;
    String town;
    SizeCategory category;
    double balance;

    public Customer(String name, String street, String zip, String town, SizeCategory category, double balance) {
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.town = town;
        this.category = category;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getZip() {
        return zip;
    }

    public String getTown() {
        return town;
    }

    public SizeCategory getCategory() {
        return category;
    }

    public double getBalance() {
        return balance;
    }

    public String toString() {
        return getName()+", " + getStreet()+", " + getZip()+" "+getTown() + " Cat: " + getCategory();
    }

    public int compareTo(Customer c) {
        if (!this.name.equals(c.name)) {
            return this.name.compareTo(c.name);
        }
        return 0;
    }


    public static class CompareByName implements Comparator<Customer> {
        @Override
        public int compare(Customer c1, Customer c2) {
            return c1.getName().compareTo(c2.getName());
        }
    }

    public static class CompareByAddress implements Comparator<Customer> {
        @Override
        public int compare(Customer c1, Customer c2) {
            if (!c1.getStreet().split(" ", 2)[1].equals(c2.getStreet().split(" ", 2)[1])) {
                return c1.getStreet().split(" ", 2)[1].compareTo(c2.getStreet().split(" ", 2)[1]);
            } else if (!c1.getZip().equals(c2.getZip())) {
                return c1.getZip().compareTo(c2.getZip());
            }
            return c1.getTown().compareTo(c2.getTown());
        }
    }

    public static class CompareByCategory implements Comparator<Customer> {
        @Override
        public int compare(Customer c1, Customer c2) {
            if (!c1.getCategory().equals(c2.getCategory())) {
                return c1.getCategory().compareTo(c2.getCategory());
            }
            return c1.getName().compareTo(c2.getName());
        }
    }
}
