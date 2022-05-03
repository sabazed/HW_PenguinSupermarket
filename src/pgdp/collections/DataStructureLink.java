package pgdp.collections;

public class DataStructureLink<T> {

    // Create two variables to save connectors
    private final DataStructureConnector<T> first, second;

    // Assign connectors to variables
    public DataStructureLink(DataStructureConnector<T> first, DataStructureConnector<T> second) {
        if (first == null || second == null) ExceptionUtil.illegalArgument("Argument shouldn't be equal to null");
        this.first = first;
        this.second = second;
    }

    // Move a single element
    public boolean moveNextFromAToB() {
        // Check if it's possible to remove an element
        boolean condition = first.hasNextElement();
        if (condition) second.addElement(first.removeNextElement());
        return condition;
    }

    // Move all elements
    public void moveAllFromAToB() {
        while (first.hasNextElement()) {
            second.addElement(first.removeNextElement());
        }
    }

    @Override
    public String toString() {
        return "DataStructureLink{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

}
