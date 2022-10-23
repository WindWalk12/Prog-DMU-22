package Exercise1;

public class App {
    public static void main(String[] args) {
        BankAccount b = new BankAccount(0);
        System.out.println(b.getBalance());
        b.deposit(100);
        System.out.println(b.getBalance());
        b.withdraw(50);
        System.out.println(b.getBalance());
        System.out.println(BankAccount.getId());
        BankAccount b2 = new BankAccount(0);
        System.out.println(BankAccount.getId());
    }
}
