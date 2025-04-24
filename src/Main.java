import bank.Bank;
import bank.CloseBankTask;
import client.BudgetClient;
import client.Client;
import client.NormalClient;
import client.VipClient;
import transaction.DepositTransaction;
import transaction.Transaction;
import transaction.WithdrawTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        List<Client> clients = new ArrayList<>();

        Runnable closeBankTask = new CloseBankTask(bank);
        Thread closeBankTimerThread = new Thread(closeBankTask);
        closeBankTimerThread.start();

        initializeClients(clients);

        addTransactionsToBank(clients, bank);

    }

    private static void addTransactionsToBank(List<Client> clients, Bank bank) {
        try {
            for (int i = 1; i <= 100; i++) {
                Random random = new Random();
                Client client = clients.get(random.nextInt(clients.size())); // Random client
                double amount = 50 + random.nextDouble(50000); // Random transaction amount
                boolean isDeposit = random.nextBoolean(); // Random transaction type


                Transaction transaction;
                if (isDeposit) {
                    transaction = new DepositTransaction(client, amount);
                } else {
                    transaction = new WithdrawTransaction(client, amount);
                }


                bank.addTransaction(transaction);
                Thread.sleep(500); // 500ms delay between transactions
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    private static void initializeClients(List<Client> clients) {
        for (int i = 1; i <= 50; i++) {

            if (i % 3 == 0){

                clients.add(new VipClient(10000 + new Random().nextInt(10000)));

            } else if (i % 2 == 0){

                clients.add(new NormalClient(5000 + new Random().nextInt(10000)));

            }else{

                clients.add(new BudgetClient(2000 + new Random().nextInt(10000)));

            }


        }
    }

}
