public class TransactionReciept {
    public TransactionReciept() {
    }

    public static void reciept(Account account, String operation, double amount) {
        System.out.println("============ACCOUNT DETAILS DISPLAYED SUCESSFULLY============");
        System.out.println(account);
        System.out.println(operation);
        System.out.println("amount:" + amount);
        System.out.println("=============================================================");
    }
}