package transaction;

import client.Client;
import exception.InsufficientFundsException;
import exception.TransactionLimitException;

public class TransferTransaction extends BaseTransaction{

    private static final String TYPE = "transfer";

    protected TransferTransaction(Client client, String type, double amount) {
        super(client, type, amount);
    }

    @Override
    public void perform() throws TransactionLimitException, InsufficientFundsException {

    }
}
