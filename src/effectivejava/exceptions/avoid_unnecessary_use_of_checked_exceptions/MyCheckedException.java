package effectivejava.exceptions.avoid_unnecessary_use_of_checked_exceptions;

public class MyCheckedException extends Exception {

    public static void main(String[] args) {

        // Example 1
        try {
            performDangerousOperation();
        } catch (MyCheckedException e) {
            throw new AssertionError(); // Can't happen!
        }

        // Example 2
        try {
            performDangerousOperation();
        } catch (MyCheckedException e) {
            e.printStackTrace(); // Oh well, we lose.
            System.exit(1);
        }
    }

    public static void performDangerousOperation() throws MyCheckedException {
        throw new MyCheckedException();
    }

}