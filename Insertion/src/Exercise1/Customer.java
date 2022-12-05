package Exercise1;

public class Customer implements Comparable<Customer> {
    private String name;
    private String address;
    private int zipcode;
    private String city;

    public Customer(String name, String address, int zipcode, String city) {
        this.name = name;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getName() {
        return name;
    }

    public void insertCustomer(Customer [] all, Customer c) {
        int size = findSize(all);
        if (size == 0)
        {
            all[0] = c;
            return;
        }
        // size > 0
        int idx = findIndex(all, size, c.getZipcode());
        for (int i = size-1; i >= idx; i--)
            all[i+1] = all[i];
        all[idx] = c;
    }

    private int findSize(Customer[] all) {
        int size = 0;
        for (Customer customer : all) {
            if (customer != null) {
                size++;
            }
        }
        return size;
    }

    private int findIndex(Customer[] all, int size, int value) {
        int res = 0;
        while (res < size && all[res].getZipcode() <= value)
            res++;
        return res;
    }

    @Override
    public String toString() {
        return name + " " + zipcode;
    }

    @Override
    public int compareTo(Customer c) {
        if (this.zipcode != c.getZipcode()) {
            return c.getZipcode() - this.zipcode;
        }
        return this.name.compareTo(c.getName());
    }
}
