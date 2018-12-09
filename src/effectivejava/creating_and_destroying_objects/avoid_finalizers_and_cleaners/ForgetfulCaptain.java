package effectivejava.creating_and_destroying_objects.avoid_finalizers_and_cleaners;

// Ill-behaved client of resource with cleaner safety-net
public class ForgetfulCaptain {
    public static void main(String[] args) {
        new ShipHull(true);
        System.out.println("Peace out");

        // Uncomment next line and retest behavior, but note that you MUST NOT depend on this behavior!
//      System.gc();
    }
}
