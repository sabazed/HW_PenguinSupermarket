package pgdp.collections;

public class LinkedQueue<T> implements Queue<T> {

    // Keep track of the size
    private int size;
    // Save first and last elements
    private List<T> head, tail;

    // Create a constructor for public usage
    public LinkedQueue() {
        size = 0;
        head = tail = null;
    }

    // Return the size of the stack
    public int size() {
        return size;
    }

    public void enqueue(T t) {
        if (t == null) ExceptionUtil.illegalArgument("Please input a valid argument");
        // Check if the last object is null
        if (head == null) {
            // Link the old element to this one
            head = new List<>(t);
        }
        else if (tail == null) {
            tail = new List<>(t);
            head.setNext(tail);
        }
        else {
            tail.setNext(new List<>(t));
            tail = tail.getNext();

        }
        // Increase the size
        size++;
    }

    public T dequeue() {
        // Check if the last object is null
            if (head != null) {
                T result = head.getInfo();
                head = head.getNext();
                if (head == tail) tail = null;
                // Decrease the stack size
                size--;
                return result;
            }
            return null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        return "" + head;
    }

}
