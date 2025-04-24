package bank;

import java.util.Random;

public class CloseBankTask implements Runnable {
    private final Bank bank;

    public CloseBankTask(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            int delay = 40000 + random.nextInt(10000); // Random delay between 40000ms (40s) and 55000ms (55s)
            System.out.println("Waiting for " + (delay / 1000) + " seconds before closing the bank...");
            Thread.sleep(delay); // Wait before closing the bank

            // Close the bank after the delay
            System.out.println("Bank is closed after " + (delay / 1000) + " seconds.");
            bank.close();

            System.out.println("No more transactions will be processed.");

            System.exit(0);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}