package transaction;

import client.Client;
import exception.TransactionLimitException;

public class DepositTransaction extends BaseTransaction {

    private static final String TYPE = "deposit";

    public DepositTransaction(Client client, double amount) {
        super(client, TYPE, amount);
    }


    @Override
    public void perform() throws TransactionLimitException {


        super.getInitializer().deposit(super.getAmount());

    }
}
