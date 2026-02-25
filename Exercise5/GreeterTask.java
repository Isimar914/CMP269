package Exercise5;

public class GreeterTask implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello from " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                //empty
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new GreeterTask(), "Lehamn-Thread-1");
        Thread t2 = new Thread(new GreeterTask(), "Lehamn-Thread-2");

        t1.start();
        t2.start();

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                //empty
            }
        });

        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        Thread.sleep(500);
        System.out.println(thread.getState());
        thread.join();
        System.out.println(thread.getState());
    }
}
