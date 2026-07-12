//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public abstract class Account implements BankOperations {
    private int acc_number;
    private String acc_type;
    private double balance;
    private Customer customer;

    public Account(int acc_number, String acc_type, double balance, Customer customer) {
        this.acc_number = acc_number;
        this.acc_type = acc_type;
        this.balance = balance;
        this.customer = customer;
    }

    public String toString() {
        return "Account created successfully{acc_number=" + this.acc_number + ", acc_type='" + this.acc_type + "', balance=" + this.balance + ", customer=" + this.customer + "}";
    }

    public void deposit(double amount) {
        if (amount < 0.0) {
            System.out.println("invalid deposit");
        }

        this.balance += amount;
        System.out.println("deposit successful");
        System.out.println("Updated balance:" + this.balance);
    }

    public void deposit(double amount, String mode) {
        this.balance += amount;
        System.out.println("" + amount + "deposited through " + mode);
        System.out.println("Updated balance:" + this.balance);
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double checkBalance() {
        return this.balance;
    }

    public abstract double calculateInterest();
}
