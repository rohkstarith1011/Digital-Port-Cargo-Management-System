public class FixedDepositAccount extends Account {
    private boolean matured;

    public double calculateInterest() {
        return this.getBalance() * 0.8;
    }

    public String toString() {
        return "interest calculated Successfully";
    }

    public FixedDepositAccount(int acc_number, double balance, Customer customer, boolean matured) {
        super(acc_number, "Fixed Deposit Account", balance, customer);
        this.matured = matured;
    }

    public void withdraw(double amount) {
        if (!this.matured) {
            System.out.println("FD not matured yet");
        } else {
            this.setBalance(this.getBalance() - amount);
        }

    }
}