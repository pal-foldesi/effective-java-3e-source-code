package effectivejava.classes_and_interfaces.minimize_the_accessibility_of_classes_and_members;

import java.util.Arrays;
import java.util.List;

public class TestFixedArrayHolder {
    public static void main(String[] args) {
        int[] fromArrayHolder = ArrayHolder.VALUES;

        //oops...
        fromArrayHolder[1] = 99;
        fromArrayHolder[2] = 837428324;

        List<Integer> fromArray = FixedArrayHolder.VALUES;
        Integer[] fromArray2 = FixedArrayHolder.values();

        System.out.println(fromArray);
        Arrays.stream(fromArray2).forEach(System.out::println);
    }
}
