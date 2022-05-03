package pgdp.collections;

public interface Queue<T> extends DataStructure {

    // Add methods for enqueuing/dequeuing elements
    void enqueue(T t);
    T dequeue();

}
