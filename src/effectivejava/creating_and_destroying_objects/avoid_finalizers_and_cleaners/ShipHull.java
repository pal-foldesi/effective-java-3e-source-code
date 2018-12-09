package effectivejava.creating_and_destroying_objects.avoid_finalizers_and_cleaners;

import java.lang.ref.Cleaner;

// An autocloseable class using a cleaner as a safety net
public class ShipHull implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();

    // Resource that requires cleaning. Must not refer to ShipHull!
    private static class State implements Runnable {
        boolean hasBarnaclesAttached;

        State(boolean hasBarnaclesAttached) {
            this.hasBarnaclesAttached = hasBarnaclesAttached;
        }

        // Invoked by close method or cleaner
        @Override public void run() {
            System.out.println("Removing barnacles from hull");
            this.hasBarnaclesAttached = false;
        }
    }

    // The state of this ship hull, shared with our cleanable
    private final State state;

    // Our cleanable. Cleans the ship hull when it’s eligible for gc
    private final Cleaner.Cleanable cleanable;

    public ShipHull(boolean hasBarnaclesAttached) {
        state = new State(hasBarnaclesAttached);
        cleanable = cleaner.register(this, state);
    }

    @Override public void close() {
        cleanable.clean();
    }
}
