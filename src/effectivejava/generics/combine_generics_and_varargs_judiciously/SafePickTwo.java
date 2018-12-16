package effectivejava.generics.combine_generics_and_varargs_judiciously;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// Safe version of PickTwo using lists instead of arrays (Page 150)
public class SafePickTwo {
    static <T> List<T> pickTwo(T a, T b, T c) {
        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return List.of(a, b);
            case 1: return List.of(a, c);
            case 2: return List.of(b, c);
        }
        throw new AssertionError();
    }

    public static void main(String[] args) {
        List<String> attributes = pickTwo("Good", "Fast", "Cheap");
        System.out.println(attributes);
    }
}
