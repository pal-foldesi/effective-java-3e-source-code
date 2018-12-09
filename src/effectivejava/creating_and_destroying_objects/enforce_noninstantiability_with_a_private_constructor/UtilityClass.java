package effectivejava.creating_and_destroying_objects.enforce_noninstantiability_with_a_private_constructor;

// Noninstantiable utility class
public class UtilityClass {
    // Suppress default constructor for noninstantiability
    private UtilityClass() {
        throw new AssertionError();
    }

    // Remainder omitted
}
