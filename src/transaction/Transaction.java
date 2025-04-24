package transaction;

import client.Client;
import exception.InsufficientFundsException;
import exception.TransactionLimitException;

import java.time.LocalDateTime;

public interface Transaction {

    Client getInitializer();
    String getType();
    void perform() throws TransactionLimitException, InsufficientFundsException;
    double getAmount();
    LocalDateTime getTimestamp();
}
