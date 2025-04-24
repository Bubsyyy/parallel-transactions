package transaction;

import client.Client;

import java.time.LocalDateTime;

public abstract class BaseTransaction implements Transaction {

    private final Client client;
    private final String type;
    private final double amount;
    private final LocalDateTime timestamp;



    protected BaseTransaction(Client client, String type, double amount) {
        this.client = client;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
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

    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
