package bank;

import exception.InsufficientFundsException;
import exception.TransactionLimitException;
import transaction.Transaction;

public class Atm extends Thread {

    private Bank bank;

    public Atm(Bank bank) {
        this.bank = bank;
    }


    @Override
    public void run() {

        processTransaction();

    }

    private void processTransaction() {

        Transaction transaction;

        while ((transaction = bank.nextTransaction()) != null) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                transaction.perform();
            } catch (TransactionLimitException | InsufficientFundsException e) {
                System.out.println(e.getMessage());
            }
        }

    }


}
