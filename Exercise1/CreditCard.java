public class CreditCard extends PaymentMethod{
    private double creditLimit;

    public CreditCard(String accountHolder, double balance, double creditLimit) {
        super(accountHolder, balance);
        this.creditLimit = creditLimit;
    }

    @Override
    public void validateAccount() {

    }

    @Override
    public void processPayment(double amount) {
        if (amount > balance + creditLimit) {
            System.out.println("Transaction Declined.");
        } else {
            balance -= amount;
            totalTransaction++;
        }
    }

    @Override
    public String getPaymentStatus() {
        return "Balance: " + balance;
    }
}
