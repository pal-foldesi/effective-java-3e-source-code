package effectivejava.classes_and_interfaces.design_and_document_for_inheritance_or_else_prohibit_it;

// Class whose constructor invokes an overridable method. NEVER DO THIS!
public class Super {
    // Broken - constructor invokes an overridable method
    public Super() {
        overrideMe();
    }

    public void overrideMe() {
    }
}
