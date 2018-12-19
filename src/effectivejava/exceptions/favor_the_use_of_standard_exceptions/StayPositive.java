package effectivejava.exceptions.favor_the_use_of_standard_exceptions;

public class StayPositive {
    int value;

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