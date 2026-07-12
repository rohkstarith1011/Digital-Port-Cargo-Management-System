public class CurrentAccount extends Account{

    public double calculateInterest() {
        return this.getBalance() * 0.1;
    }

    public void withdraw(double amount) {
        this.setBalance(this.getBalance() - amount);
        System.out.println("withdrawal successful");
    }

    public String toString() {
        return super.toString();
    }

    public CurrentAccount(int acc_number, double balance, Customer customer) {
        super(acc_number, "Current Account", balance, customer);
    }

}
