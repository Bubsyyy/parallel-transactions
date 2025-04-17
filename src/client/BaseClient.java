package client;

import exception.InsufficientFundsException;
import exception.TransactionLimitException;

public abstract class BaseClient implements Client {

    private static int idCounter = 1;
    private final int id;
    private volatile double balance;
    private final int priority;
    private final double transactionLimit;

    public BaseClient(double balance, int priority, double transactionLimit) {

        id = idCounter++;
        this.balance = balance;
        this.priority = priority;
        this.transactionLimit = transactionLimit;

    }


    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    @Override
    public double getTransactionLimit() {
        return this.transactionLimit;
    }

    @Override
    public synchronized void withdraw(double amount) throws InsufficientFundsException, TransactionLimitException {

        if(amount > this.transactionLimit) {
            throw new TransactionLimitException(String.format("Client N:%d is trying to make transaction over the limit", this.id));
        }

        if (getBalance() < amount) {
            throw new InsufficientFundsException(String.format("Client N:%d does not have enough funds to withdraw", this.id));
        }
        this.balance -= amount;


    }

    @Override
    public synchronized void deposit(double amount) throws TransactionLimitException {

        if(amount > this.transactionLimit) {
            throw new TransactionLimitException(String.format("Client N:%d is trying to make transaction over the limit", this.id));
        }

        this.balance += amount;

    }



}
