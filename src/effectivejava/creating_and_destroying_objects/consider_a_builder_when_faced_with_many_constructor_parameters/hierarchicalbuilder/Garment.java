package effectivejava.creating_and_destroying_objects.consider_a_builder_when_faced_with_many_constructor_parameters.hierarchicalbuilder;

// Builder pattern for class hierarchies

// Note that the underlying "simulated self-type" idiom  allows for arbitrary fluid hierarchies, not just builders

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Garment {
    public enum Material { COTTON, ELASTANE, SPANDEX, ACRYLIC, POLYESTER }
    final Set<Material> materials;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Material> materials = EnumSet.noneOf(Material.class);

        public T addMaterial(Material material) {
            materials.add(Objects.requireNonNull(material));
            return self();
        }

        abstract Garment build();

        // Subclasses must override this method to return "this"
        protected abstract T self();
    }

    Garment(Builder<?> builder) {
        materials = builder.materials.clone(); // See Item 50
    }
}
