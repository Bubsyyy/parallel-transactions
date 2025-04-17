package transaction;

import client.Client;
import exception.InsufficientFundsException;
import exception.TransactionLimitException;

public abstract class BaseTransaction implements Transaction {

    private final Client client;
    private final String type;
    private final double amount;



    protected BaseTransaction(Client client, String type, double amount) {
        this.client = client;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public Client getInitializer() {
        return this.client;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public double getAmount() {
        return amount;
    }
}
