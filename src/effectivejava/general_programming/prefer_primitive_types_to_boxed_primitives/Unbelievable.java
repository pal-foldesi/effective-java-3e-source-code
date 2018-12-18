package effectivejava.general_programming.prefer_primitive_types_to_boxed_primitives;

// What does this program do?
public class Unbelievable {
    static Integer i;

    public static void main(String[] args) {
        if (i == 42) //i is null, and thus auto-unboxing results in a NPE.
            System.out.println("Unbelievable");
    }
}