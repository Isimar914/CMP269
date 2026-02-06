import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Payable> paymentQueue = new ArrayList<>();

        CreditCard cc = new CreditCard("Student", 100.0, 200.0);
        MealPlan mp = new MealPlan("Student", 80.0);

        paymentQueue.add(cc);
        paymentQueue.add(mp);

        for (Payable p : paymentQueue) {
            p.processPayment(50.0);
            System.out.println(p.getPaymentStatus());
        }

        System.out.println("Total Transaction: " + PaymentMethod.getTotalTransactions());
    }
}
