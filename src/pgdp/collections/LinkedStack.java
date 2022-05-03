package pgdp.collections;

public class LinkedStack<T> implements Stack<T> {

    // Keep track of the size
    private int size;
    private List<T> last;

    // Create a constructor for public usage
    public LinkedStack() {
        size = 0;
        last = null;
    }

    // Return the size of the stack
    public int size() {
        return size;
    }

    // Push a new element to the stack
    public void push(T t) {
        if (t == null) ExceptionUtil.illegalArgument("Please input a valid argument");
        // Check if the last object is null
        if (last != null) {
            // Link the old element tao this one
            last = new List<>(t, last);
        }
        else last = new List<>(t);
        // Increase the size
        size++;
    }


    // Pop an element from the stack
    public T pop() {
        // Check if the last object is null
        if (last != null) {
            T result = last.getInfo();
            last = last.getNext();
            // Decrease the stack size
            size--;
            return result;
        }
        return null;
    }

    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public String toString() {
        return "" + last;
    }

}
