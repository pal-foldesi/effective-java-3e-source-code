package effectivejava.classes_and_interfaces.design_and_document_for_inheritance_or_else_prohibit_it;

import java.time.Instant;

// Demonstration of what can go wrong when you override a method  called from constructor
public final class Sub extends Super {
    // Blank final, set by constructor
    private final Instant instant;

    Sub() {
        instant = Instant.now();
    }

    // Overriding method invoked by superclass constructor
    @Override public void overrideMe() {
        instant.hashCode();
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
