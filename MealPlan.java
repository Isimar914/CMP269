public class MealPlan extends PaymentMethod {
    public MealPlan (String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
    public void validateAccount() {

    }

    @Override
    public void processPayment(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient meal plan balance.");
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
