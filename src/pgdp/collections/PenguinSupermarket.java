package pgdp.collections;

public class PenguinSupermarket {

    // Create the attributes, constructor and its getter
    private List<Checkout> checkouts;
    private int open;

    // Create all checkouts as a list
    public PenguinSupermarket(int number) {
        if (number < 1) ExceptionUtil.illegalArgument("Number of checkouts should not be negative");
        open = number;
        checkouts = new List<>(new Checkout());
        List<Checkout> temp = checkouts;
        for (int i = 1; i < open; i++) {
            temp.setNext(new List<>(new Checkout()));
            temp = temp.getNext();
        }
    }

    // Put all checkouts in a new array
    public Checkout[] getCheckouts() {
        Checkout[] allcheckouts = new Checkout[open];
        List<Checkout> temp = checkouts;
        for (int i = 0; i < open; i++) {
            allcheckouts[i] = temp.getInfo();
            temp = temp.getNext();
        }
        return allcheckouts;
    }

    // Get the queue with the least amount of clients
    public Checkout getCheckoutWithSmallestQueue() {
        if (open > 1) {
            List<Checkout> smallQ = checkouts;
            List<Checkout> temp = checkouts.getNext();
            for (int i = 1; i < open; i++) {
                if (temp.getInfo().queueLength() < smallQ.getInfo().queueLength()) {
                    smallQ = temp;
                }
                temp = temp.getNext();
            }
            return smallQ.getInfo();
        }
        return checkouts.getInfo();
    }

    // Close the checkout and change the next link
    public void closeCheckout(int index) {
        if (index < 0) ExceptionUtil.illegalArgument("Index cannot be negative");
        else if (open < 2) ExceptionUtil.unsupportedOperation("Cannot close any more checkouts");
        List<Checkout> temp = checkouts;
        if (index != 0) {
            // Reach the last checkout
            for (int i = 1; i < index; i++) {
                temp = temp.getNext();
            }
        }
        // Copy the queue elements into a new queue
        QueueConnector<PenguinCustomer> penguins;
        if (index != 0) {
            penguins = new QueueConnector<>(temp.getNext().getInfo().getQueue());
        }
        else penguins = new QueueConnector<>(temp.getInfo().getQueue());
        StackConnector<PenguinCustomer> emptyQ = new StackConnector<>(new LinkedStack<>());
        DataStructureLink<PenguinCustomer> requeue = new DataStructureLink<>(penguins, emptyQ);
        requeue.moveAllFromAToB();
        // Unlink the checkout
        if (index != 0) {
            temp.setNext(temp.getNext().getNext());
        }
        else this.checkouts = checkouts.getNext();
        open--;
        // Copy the remaining clients into the smallest queue
        while (emptyQ.hasNextElement())
            emptyQ.removeNextElement().goToCheckout(this);
    }

    // Get the next row of customers
    public void serveCustomers() {
        List<Checkout> temp = checkouts;
        for (int i = 0; i < open; i++) {
            temp.getInfo().serveNextCustomer();
            temp = temp.getNext();
        }
    }

    @Override
    public String toString() {
        return "PenguinSupermarket{" +
                "checkouts=" + checkouts +
                ", open=" + open +
                '}';
    }

}