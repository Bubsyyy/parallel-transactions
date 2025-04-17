package client;

import exception.InsufficientFundsException;
import exception.TransactionLimitException;

public interface Client {

    int getId();
    double getBalance();
    int getPriority();
    double getTransactionLimit();
    void withdraw(double amount) throws InsufficientFundsException, TransactionLimitException;
    void deposit(double amount) throws TransactionLimitException;

}
