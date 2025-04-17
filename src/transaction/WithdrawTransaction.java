package transaction;

import client.Client;
import exception.InsufficientFundsException;
import exception.TransactionLimitException;

public class WithdrawTransaction extends BaseTransaction {


    private static final String TYPE = "withdraw";

    protected WithdrawTransaction(Client client, double amount) {
        super(client, TYPE, amount);
    }

    @Override
    public void perform() throws TransactionLimitException, InsufficientFundsException {

        super.getInitializer().withdraw(super.getAmount());

    }
}
