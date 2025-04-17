package client;

public class NormalClient extends BaseClient{

    private static final int PRIORITY = 2;
    private static final double LIMIT = 10000;

    public NormalClient(double balance) {
        super(balance, PRIORITY, LIMIT);
    }
}
