package Exercise1;

/**
 * Modelles a BankAccount.
 */
public class BankAccount {
    private double balance;
    private static int id = 0;

    /**
     * Initialize a new BankAccount with a balance.
     * @param balance
     * Pre: balance >= 0
     */
    public BankAccount(double balance) {
        BankAccount.id++;
        this.balance = balance;
    }

    /**
     * Register new balance
     * @param amount
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Register new balance
     * @param amount
     */
    public void withdraw(double amount) {
        balance -= amount;
    }

    /**
     * Returns balance amount
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns number of id
     * @return id
     */
    public static int getId() {
        return id;
    }
}
