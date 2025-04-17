package bank;

import comparator.TransactionComparator;
import transaction.Transaction;

import java.util.PriorityQueue;
import java.util.Queue;

public class Bank {

    private static final int NUMBER_OF_ATMS = 5;
    private Queue<Transaction> transactionsQueue;
    private Atm[] atms;
    private volatile boolean isClosed = false;


    public Bank() {

        transactionsQueue = new PriorityQueue<>(new TransactionComparator());
        startAtms();
    }

    private void startAtms() {
        atms = new Atm[NUMBER_OF_ATMS];

        for (int i = 0; i < NUMBER_OF_ATMS; i++) {
            atms[i] = new Atm(this);
            atms[i].start();
        }
    }


    public synchronized void addTransaction(Transaction transaction) {
        transactionsQueue.add(transaction);
        this.notify();
    }

    public synchronized Transaction nextTransaction() {
        while (transactionsQueue.isEmpty()) {

            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        return (isClosed || transactionsQueue.isEmpty()) ? null : transactionsQueue.poll();
    }


    public synchronized void close() {
        this.isClosed = true;
        this.notifyAll();
    }
}
