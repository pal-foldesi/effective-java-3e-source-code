package effectivejava.creating_and_destroying_objects.consider_a_builder_when_faced_with_many_constructor_parameters.builder;

// Builder Pattern
public class BloodTestResult {
    private String firstName;
    private String lastName;
    private final double redBloodCells;     // (count * 10^12/L)
    private final double whiteBloodCells;   // (count * 10^9/L)
    private final int hemoglobin;           // (g/L)
    private final double hematocrit;        // (vol%)
    private final int platelets;            // (count * 10^9/L)

    public static class Builder {
        // Required parameters
        private final String firstName;
        private final String lastName;
        private final double redBloodCells;
        private final double whiteBloodCells;

        // Optional parameters - initialized to default values
        private int hemoglobin      = 0;
        private double hematocrit   = 0;
        private int platelets       = 0;

        public Builder(String firstName, String lastName, double redBloodCells, double whiteBloodCells) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.redBloodCells = redBloodCells;
            this.whiteBloodCells = whiteBloodCells;
        }

        public Builder hemoglobin(int val) {
            this.hemoglobin = val;
            return this;
        }

        public Builder hematocrit(double val) {
            this.hematocrit = val;
            return this;
        }

        public Builder platelets(int val) {
            this.platelets = val;
            return this;
        }

        public BloodTestResult build() {
            return new BloodTestResult(this);
        }
    }

    private BloodTestResult(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.redBloodCells = builder.redBloodCells;
        this.whiteBloodCells = builder.whiteBloodCells;
        this.hemoglobin = builder.hemoglobin;
        this.hematocrit = builder.hematocrit;
        this.platelets = builder.platelets;
    }

    public static void main(String[] args) {
        BloodTestResult afterVenison = new Builder("John", "Doe",
                4.8, 7.23).hemoglobin(145)
                .hematocrit(0.52).platelets(381).build();
    }
}