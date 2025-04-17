package client;

public class BudgetClient extends BaseClient{

    private static final int PRIORITY = 1;
    private static final double LIMIT = 5000;

    public BudgetClient(double balance) {
        super(balance, PRIORITY, LIMIT);
    }
}
