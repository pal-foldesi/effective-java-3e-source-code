package creating_and_destroying_objects.enforce_the_singleton_property_with_a_private_constructor_or_an_enum_type.enumtype;

// Enum singleton - the preferred approach
public enum Hemingway {
    INSTANCE;

    public void writeANovel() {
        System.out.println("Hemingway is writing a new novel!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Hemingway hemingway = Hemingway.INSTANCE;
        hemingway.writeANovel();
    }
}
