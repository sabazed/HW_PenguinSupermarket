package pgdp.collections;

public interface Stack<T> extends DataStructure {

    // Add a method for pushing the element to the stack
    void push(T value);
    // Add a method for popping the element from the stack
    T pop();

}
