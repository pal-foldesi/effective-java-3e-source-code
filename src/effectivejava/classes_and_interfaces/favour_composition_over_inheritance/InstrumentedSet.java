package effectivejava.classes_and_interfaces.favour_composition_over_inheritance;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

// Wrapper class - uses composition in place of inheritance
public class InstrumentedSet<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override public boolean add(E e) {
        addCount++;
        return super.add(e);
    }
    @Override public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }
    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedSet<String> s = new InstrumentedSet<>(new HashSet<>());
        s.addAll(List.of("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());
    }
}
