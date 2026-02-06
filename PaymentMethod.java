public abstract class PaymentMethod implements Payable{
    protected String accountHolder;
    protected double balance;
    protected static int totalTransaction;
    
    public PaymentMethod(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public static int getTotalTransactions() {
        return totalTransaction;
    }

    public abstract void validateAccount();
}
