package client;

import exception.InsufficientFundsException;
import exception.TransactionLimitException;

public abstract class BaseClient implements Client {

    private static int idCounter = 1;
    private final int id;
    private double balance;
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
    public void withdraw(double amount) throws InsufficientFundsException, TransactionLimitException {

        checkLimit(amount);


        synchronized (this) {
            if (balance < amount) {
                throw new InsufficientFundsException(String.format("Client N:%d does not have enough funds to withdraw", this.id));
            }
            this.balance -= amount;

        }

        System.out.println("Withdraw " + amount + " to " + this.id);

    }

    @Override
    public void deposit(double amount) throws TransactionLimitException {

        checkLimit(amount);

        synchronized (this) {
            this.balance += amount;

        }

        System.out.println("Deposited " + amount + " to " + this.id);

    }

    private void checkLimit(double amount) throws TransactionLimitException {
        if(amount > this.transactionLimit) {
            throw new TransactionLimitException(String.format("Client N:%d is trying to make transaction over the limit", this.id));
        }
    }


    @Override
    public String toString() {
        return String.format("Client N:%d ", id);
    }
}
