package transaction;

import client.Client;
import exception.InsufficientFundsException;
import exception.TransactionLimitException;

public interface Transaction {

    Client getInitializer();
    String getType();
    void perform() throws TransactionLimitException, InsufficientFundsException;
    double getAmount();
}
