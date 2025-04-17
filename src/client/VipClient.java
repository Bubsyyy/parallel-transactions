package client;

public class VipClient extends BaseClient {

    private static final int PRIORITY = 3;
    private static final double LIMIT = 30000;


    public VipClient(double balance) {
        super(balance, PRIORITY, LIMIT);
    }
}
