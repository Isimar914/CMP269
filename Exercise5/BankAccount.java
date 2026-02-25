package Exercise5;

public class BankAccount {
    private int balance = 1000;
    
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                //empty
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " " + balance);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        Runnable task = () -> account.withdraw(700);

        Thread husband = new Thread(task, "Husband: ");
        Thread wife = new Thread(task, "Wife: ");

        husband.start();
        wife.start();

        long[] result = {0};
        Thread heavyTask = new Thread(() -> {
            for (long i = 0; i < 1000000000; i++) {
                result[0] += i;
            }
        });

        heavyTask.start();
        heavyTask.join();
        System.out.println("Calculation Finished: " + result[0]);
    }
}
