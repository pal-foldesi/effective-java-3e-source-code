package effectivejava.methods_common_to_all_objects.obey_the_general_contract_when_overriding_equals.inheritance;
import obey_the_general_contract_when_overriding_equals.Point;

import java.util.concurrent.atomic.*;

// Trivial subclass of Point - doesn't add a value component
public class CounterPoint extends Point {
    private static final AtomicInteger counter =
            new AtomicInteger();

    public CounterPoint(int x, int y) {
        super(x, y);
        counter.incrementAndGet();
    }
    public static int numberCreated() { return counter.get(); }
}
