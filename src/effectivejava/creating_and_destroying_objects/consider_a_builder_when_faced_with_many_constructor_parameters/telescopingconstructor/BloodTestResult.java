package effectivejava.creating_and_destroying_objects.consider_a_builder_when_faced_with_many_constructor_parameters.telescopingconstructor;

// Telescoping constructor pattern - does not scale well!
public class BloodTestResult {
    private final String firstName;
    private final String lastName;
    private final double redBloodCells;     // (count * 10^12/L)
    private final double whiteBloodCells;   // (count * 10^9/L)
    private final int hemoglobin;           // (g/L)
    private final double hematocrit;        // (vol%)
    private final int platelets;            // (count * 10^9/L)

    public BloodTestResult(String firstName, String lastName, double redBloodCells, double whiteBloodCells) {
        this(firstName, lastName, redBloodCells, whiteBloodCells, 0, 0, 0);
    }

    public BloodTestResult(String firstName, String lastName, double redBloodCells, double whiteBloodCells, int hemoglobin) {
        this(firstName, lastName, redBloodCells, whiteBloodCells, hemoglobin, 0, 0);
    }

    public BloodTestResult(String firstName, String lastName, double redBloodCells, double whiteBloodCells, int hemoglobin, double hematocrit) {
        this(firstName, lastName, redBloodCells, whiteBloodCells, hemoglobin, hematocrit, 0);
    }

    public BloodTestResult(String firstName, String lastName, double redBloodCells, double whiteBloodCells, int hemoglobin, double hematocrit, int platelets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.redBloodCells = redBloodCells;
        this.whiteBloodCells = whiteBloodCells;
        this.hemoglobin = hemoglobin;
        this.hematocrit = hematocrit;
        this.platelets = platelets;
    }

    public static void main(String[] args) {
        BloodTestResult afterVenison = new BloodTestResult("John", "Doe",
                4.8, 7.23, 145, 0.52, 381);
    }
}