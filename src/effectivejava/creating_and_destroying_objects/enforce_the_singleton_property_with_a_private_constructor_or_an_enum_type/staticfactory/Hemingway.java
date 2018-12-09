package creating_and_destroying_objects.enforce_the_singleton_property_with_a_private_constructor_or_an_enum_type.staticfactory;

// Singleton with static factory
public class Hemingway {
    private static final Hemingway INSTANCE = new Hemingway();
    private Hemingway() { }
    public static Hemingway getInstance() { return INSTANCE; }

    public void writeANovel() {
        System.out.println("Hemingway is writing a new novel!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Hemingway hemingway = Hemingway.getInstance();
        hemingway.writeANovel();
    }
}
