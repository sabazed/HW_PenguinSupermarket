package pgdp.collections;

public class Checkout {

    // Create queues for penguins and their products
    private final Queue<PenguinCustomer> clients;
    private final Queue<FishyProduct> belt, tape ;

    public Checkout() {
        this.clients = new LinkedQueue<>();
        this.belt = new LinkedQueue<>();
        this.tape = new LinkedQueue<>();
    }

    // Create all getters
    public Queue<PenguinCustomer> getQueue() {
        return clients;
    }

    public Queue<FishyProduct> getBandBeforeCashier() {
        return belt;
    }

    public Queue<FishyProduct> getBandAfterCashier() {
        return tape;
    }

    // Return the amount of all clients
    public int queueLength() {
        return clients.size();
    }

    // Dequeue client
    public void serveNextCustomer() {
        // Remove a customer from the queue
        PenguinCustomer current = clients.dequeue();
        if (current == null) return;
        // Unload all the products
        current.placeAllProductsOnBand(belt);
        // Store price of all products
        int amount = 0;
        while (!belt.isEmpty()) {
            FishyProduct product = belt.dequeue();
            amount += product.getPrice();
            tape.enqueue(product);
        }
        // Load all the products back
        current.takeAllProductsFromBand(tape);
        // Ask the client to pay up
        current.pay(amount);
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "clients=" + clients +
                ", belt=" + belt +
                ", tape=" + tape +
                '}';
    }
}
