package effectivejava.creating_and_destroying_objects.consider_a_builder_when_faced_with_many_constructor_parameters.hierarchicalbuilder;

// Subclass with hierarchical builder (Page 15)
public class SuperheroCostume extends Garment {
    private final String nameOnFront;

    public static class Builder extends Garment.Builder<Builder> {
        private String nameOnFront;

        public Builder(String nameOnFront) {
            this.nameOnFront = nameOnFront;
        }

        @Override public SuperheroCostume build() {
            return new SuperheroCostume(this);
        }

        @Override protected Builder self() { return this; }
    }

    private SuperheroCostume(Builder builder) {
        super(builder);
        nameOnFront = builder.nameOnFront;
    }

    @Override public String toString() {
        return String.format("SuperheroCostume for %s made from materials %s",
                nameOnFront, materials);
    }
}
