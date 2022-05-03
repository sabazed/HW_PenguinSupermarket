package pgdp.collections;

public class FishyProduct {

    // Create final attributes
    private final String name;
    private final int price;

    // Create a constructor for both attributes
    public FishyProduct(String name, int price) {
        if (name == null || price <= 0) ExceptionUtil.illegalArgument("Please provide valid arguments for the product");
        this.name = name;
        this.price = price;
    }

    // Create proper getters
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "FishyProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
