package pgdp.collections;

public class PenguinCustomer {

    // Create all attributes
    private final String name;
    private int money;
    // Products variable is a stack with FP class objects
    private final Stack<FishyProduct> products;

    // Create a constructor for all attributes
    public PenguinCustomer(String name, int initialMoney) {
        if (name == null || initialMoney < 0) ExceptionUtil.illegalArgument("Please provide valid arguments for the customer");
        this.name = name;
        this.money = initialMoney;
        this.products = new LinkedStack<>();
    }

    // Create proper getters
    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public Stack<FishyProduct> getProducts() {
        return products;
    }

    // Push the new product into the stack
    public void addProductToBasket(FishyProduct product) {
        if (product == null) ExceptionUtil.illegalArgument("Please provide valid arguments for the customer");
        else products.push(product);
    }

    // Unload all products from the basket
    public void placeAllProductsOnBand(Queue<FishyProduct> belt) {
        if (belt == null) ExceptionUtil.illegalArgument("Non-valid argument input for 'placeAllProductsFromBand'");
        // Create connectors for current products and unloading queue
        StackConnector<FishyProduct> inventory = new StackConnector<>(products);
        QueueConnector<FishyProduct> load = new QueueConnector<>(belt);
        // Create a link between two structures
        DataStructureLink<FishyProduct> transfer = new DataStructureLink<>(inventory, load);
        // Unload all products into queue
        transfer.moveAllFromAToB();
    }

    // Load all products into the basket
    public void takeAllProductsFromBand(Queue<FishyProduct> belt) {
        if (belt == null) ExceptionUtil.illegalArgument("Non-valid argument input for 'takeAllProductsFromBand'");
        // Create connectors for current products and loading queue
        StackConnector<FishyProduct> inventory = new StackConnector<>(products);
        QueueConnector<FishyProduct> load = new QueueConnector<>(belt);
        // Create a link between two structures
        DataStructureLink<FishyProduct> transfer = new DataStructureLink<>(load, inventory);
        // Load all products into stack
        transfer.moveAllFromAToB();
    }

    // Pay the required amount
    public void pay(int amount) {
        // Throw an exception if the money is negative
        if (amount < 0) ExceptionUtil.illegalArgument("Products' price cannot be negative");
        else if (money - amount < 0) ExceptionUtil.unsupportedOperation("Client doesn't have enough money");
        money -= amount;
    }

    // Go to the queue with the least number of customers
    public void goToCheckout(PenguinSupermarket supermarket) {
        if (supermarket == null) ExceptionUtil.illegalArgument("Non-valid supermarket argument input");
        Checkout first = supermarket.getCheckoutWithSmallestQueue();
        if (first == null) ExceptionUtil.unsupportedOperation("The returned checkout is not valid");
        first.getQueue().enqueue(this);
    }

    @Override
    public String toString() {
        return "PenguinCustomer{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", products=" + products +
                '}';
    }

}
