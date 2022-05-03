package pgdp.collections;

public class StackConnector<T> implements DataStructureConnector<T> {

    // Create a variable to save stack inside
    private final Stack<T> stack;

    // Create a constructor
    public StackConnector(Stack<T> stack) {
        if (stack == null) ExceptionUtil.illegalArgument("Please input a valid argument");
        this.stack = stack;
    }

    // Override all the functions with their methods
    @Override
    public boolean hasNextElement() {
        return !stack.isEmpty();
    }

    @Override
    public void addElement(T t) {
        if (t == null) ExceptionUtil.illegalArgument("Invalid argument input for adding an element");
        stack.push(t);
    }

    @Override
    public T removeNextElement() {
        return stack.pop();
    }

    @Override
    public String toString() {
        return "StackConnector{" +
                "stack=" + stack +
                '}';
    }

}
