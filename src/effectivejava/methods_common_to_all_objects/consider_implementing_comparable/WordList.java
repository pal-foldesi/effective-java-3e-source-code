package effectivejava.methods_common_to_all_objects.consider_implementing_comparable;
import java.util.*;

// The benefits of implementing Comparable
public class WordList {
    public static void main(String[] args) {
        Set<String> s = new TreeSet<>();
        Collections.addAll(s, args);
        System.out.println(s);
    }
}
