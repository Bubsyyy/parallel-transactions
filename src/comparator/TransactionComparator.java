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

        // Tie-breaker: compare by client ID (lower ID first)
        return Integer.compare(
                o1.getInitializer().getId(),
                o2.getInitializer().getId()
        );
    }
}
