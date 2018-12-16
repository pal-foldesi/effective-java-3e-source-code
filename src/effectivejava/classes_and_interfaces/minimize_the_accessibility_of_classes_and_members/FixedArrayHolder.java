package effectivejava.classes_and_interfaces.minimize_the_accessibility_of_classes_and_members;

import java.util.Collections;
import java.util.List;

public class FixedArrayHolder {
    private static final Integer[] PRIVATE_VALUES = {1, 2, 3};

    //Solution 1
    public static final List<Integer> VALUES = Collections.unmodifiableList(List.of(PRIVATE_VALUES));

    //Solution 2
    public static Integer[] values() {
        return PRIVATE_VALUES.clone();
    }
}
