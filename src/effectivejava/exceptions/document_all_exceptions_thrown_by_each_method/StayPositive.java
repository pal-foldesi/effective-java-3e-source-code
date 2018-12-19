package effectivejava.exceptions.document_all_exceptions_thrown_by_each_method;

public class StayPositive {
    int value;

    /**
     * Constructor for {@link StayPositive} class.
     * @param value A positive integer value.
     * @throws IllegalArgumentException If the value provided is <= 0.
     */
    public StayPositive(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Value must be >0!");
        }
        this.value = value;
    }

    public static void main(String[] args) {
        StayPositive sp1 = new StayPositive(5);
        StayPositive sp2 = new StayPositive(-2);
    }
}