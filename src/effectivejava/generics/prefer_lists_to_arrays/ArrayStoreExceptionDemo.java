package effectivejava.generics.prefer_lists_to_arrays;

public class ArrayStoreExceptionDemo {
    public static void main(String[] args) {
        // Fails at runtime!
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in"; // Throws ArrayStoreException
    }
}
