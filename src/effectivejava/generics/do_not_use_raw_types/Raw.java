package effectivejava.generics.do_not_use_raw_types;
import java.util.*;

// Don't use raw types, as they are only present for legacy code compatibility reasons.

// Fails at runtime - unsafeAdd method uses a raw type (List)!  (Page 119)
public class Raw {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0); // Has compiler-generated cast
    }

    // Notice no parameterized type for the List.
    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}

