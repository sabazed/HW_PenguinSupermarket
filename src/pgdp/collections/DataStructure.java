package pgdp.collections;

public interface DataStructure {

    // Add a method for checking the size
    int size();

    // Add a default method to check if the structure is empty
    default boolean isEmpty() {
        // Return true if the size equals to 0
        return size() == 0;
    }

}
