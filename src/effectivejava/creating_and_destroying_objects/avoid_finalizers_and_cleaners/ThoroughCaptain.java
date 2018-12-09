package effectivejava.creating_and_destroying_objects.avoid_finalizers_and_cleaners;

// Well-behaved client of resource with cleaner safety-net
public class ThoroughCaptain {
    public static void main(String[] args) {
        try (ShipHull hull = new ShipHull(true)) {
            System.out.println("Goodbye");
        }
    }
}
