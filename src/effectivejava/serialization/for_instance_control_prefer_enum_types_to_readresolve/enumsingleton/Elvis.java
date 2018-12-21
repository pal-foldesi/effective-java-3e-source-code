package effectivejava.serialization.for_instance_control_prefer_enum_types_to_readresolve.enumsingleton;

import java.util.*;

// Enum singleton - the preferred approach
public enum Elvis {
    INSTANCE;
    private String[] favoriteSongs =
        { "Hound Dog", "Heartbreak Hotel" };
    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }
}