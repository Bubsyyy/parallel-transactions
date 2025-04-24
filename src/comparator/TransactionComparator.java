package comparator;

import transaction.Transaction;

import java.util.Comparator;

public class TransactionComparator implements Comparator<Transaction> {
    @Override
    public int compare(Transaction o1, Transaction o2) {

        int priorityComparison = Integer.compare(
                o2.getInitializer().getPriority(),
                o1.getInitializer().getPriority()
        );

        if (priorityComparison != 0) {
            return priorityComparison;
        }


        return o1.getTimestamp().compareTo(o2.getTimestamp());

    }
}
