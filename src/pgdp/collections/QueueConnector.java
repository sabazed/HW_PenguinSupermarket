package pgdp.collections;

public class QueueConnector<T> implements DataStructureConnector<T> {

    // Create a variable to save stack inside
    private final Queue<T> queue;

    // Create a constructor
    public QueueConnector(Queue<T> queue) {
        if (queue == null) ExceptionUtil.illegalArgument("Please input a valid argument");
        this.queue = queue;
    }

    // Override all the functions with their methods
    @Override
    public boolean hasNextElement() {
        return !queue.isEmpty();
    }

    @Override
    public void addElement(T t) {
        if (t == null) ExceptionUtil.illegalArgument("Invalid argument input for adding an element");
        queue.enqueue(t);
    }

    @Override
    public T removeNextElement() {
    return queue.dequeue();
    }

    @Override
    public String toString() {
        return "QueueConnector{" +
                "queue=" + queue +
                '}';
    }

}
