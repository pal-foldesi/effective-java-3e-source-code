package effectivejava.methods_common_to_all_objects.obey_the_general_contract_when_overriding_equals.inheritance;
import obey_the_general_contract_when_overriding_equals.Point;

import java.util.*;

// Test program that uses CounterPoint as Point
public class CounterPointTest {
    // Initialize unitCircle to contain all Points on the unit circle
    private static final Set<Point> unitCircle = Set.of(
            new Point( 1,  0), new Point( 0,  1),
            new Point(-1,  0), new Point( 0, -1));

    public static boolean onUnitCircle(Point p) {
        return unitCircle.contains(p);
    }

    public static void main(String[] args) {
        Point p1 = new Point(1,  0);
        Point p2 = new CounterPoint(1,  0);

        // Prints true
        System.out.println(onUnitCircle(p1));

        // Should print true, but doesn't if Point uses getClass-based equals
        System.out.println(onUnitCircle(p2));
    }
}
