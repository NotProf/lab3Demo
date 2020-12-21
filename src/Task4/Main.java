package Task4;

public class Main {
    public static void main(String[] args) {
        Sum sum = new Sum();
        Product product = new Product();
        System.out.println("ACTIVE THREADS - " + Thread.activeCount());
        sum.start();
        System.out.println("ACTIVE THREADS - " + Thread.activeCount());
        product.run();

    }
}

class Sum extends Thread {
    private int sum = 0;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            sum = +i;
            System.out.println("Thread SUM - " + i);
        }
        System.out.println("SUM = " + sum);
    }
}

class Product implements Runnable {
    private int product = 1;

    @Override
    public void run() {
        for (int i = 1; i < 20; i++) {
            product = product * i;
            System.out.println("Thread Product - " + i);
        }
        System.out.println("Product - " + product);
    }
}
