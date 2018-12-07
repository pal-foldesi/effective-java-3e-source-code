package effectivejava.creating_and_destroying_objects.consider_a_builder_when_faced_with_many_constructor_parameters.hierarchicalbuilder;

// Subclass with hierarchical builder
public class BusinessSuit extends Garment {
    public enum Brand {
        GUCCI, ARMANI, BOSS
    }

    private Brand brand;

    public static class Builder extends Garment.Builder<Builder> {

        private Brand brand;

        public Builder brand(Brand brand) {
            this.brand = brand;
            return this;
        }

        @Override
        public BusinessSuit build() {
            return new BusinessSuit(this);
        }

        @Override protected Builder self() { return this; }
    }

    private BusinessSuit(Builder builder) {
        super(builder);
        brand = builder.brand;
    }

    @Override public String toString() {
        return String.format("Business suit of brand %s made from %s",
                brand, materials);
    }
}
