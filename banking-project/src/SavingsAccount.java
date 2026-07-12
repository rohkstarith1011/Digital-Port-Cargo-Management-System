public class SavingsAccount extends Account {
    private int MIN_BAL = 1000;

    public SavingsAccount(int acc_number, double balance, Customer customer) {
        super(acc_number, "Savings", balance, customer);
    }

    public String toString() {
        return super.toString();
    }

    public void withdraw(double amount) {
        if (this.getBalance() - amount < (double)this.MIN_BAL) {
            System.out.println("WITHDRAWAL IS VIOLATING THE MINIMUM BALANCE RULE!!!");
        }

        this.setBalance(this.getBalance() - amount);
        System.out.println("withdrawal successfull");
        System.out.println("updated balance:" + this.getBalance());
    }

    public double calculateInterest() {
        return this.getBalance() * 0.6;
    }
}