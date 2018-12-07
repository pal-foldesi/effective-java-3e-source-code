package effectivejava.creating_and_destroying_objects.consider_a_builder_when_faced_with_many_constructor_parameters.bean;

// JavaBeans Pattern - allows inconsistency, mandates mutability
public class BloodTestResult {
    private String firstName        = "";
    private String lastName         = "";
    private double redBloodCells    = -1;   // (count * 10^12/L)
    private double whiteBloodCells  = -1;   // (count * 10^9/L)
    private int hemoglobin;                 // (g/L)
    private double hematocrit;              // (vol%)
    private int platelets;                  // (count * 10^9/L)

    public BloodTestResult() { }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRedBloodCells(double redBloodCells) {
        this.redBloodCells = redBloodCells;
    }

    public void setWhiteBloodCells(double whiteBloodCells) {
        this.whiteBloodCells = whiteBloodCells;
    }

    public void setHemoglobin(int hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    public void setHematocrit(double hematocrit) {
        this.hematocrit = hematocrit;
    }

    public void setPlatelets(int platelets) {
        this.platelets = platelets;
    }

    public static void main(String[] args) {
        BloodTestResult afterVenison = new BloodTestResult();
        afterVenison.setFirstName("John");
        afterVenison.setLastName("Doe");
        afterVenison.setRedBloodCells(4.8);
        afterVenison.setWhiteBloodCells(7.23);
        afterVenison.setHemoglobin(145);
        afterVenison.setHematocrit(0.52);
        afterVenison.setPlatelets(381);
    }
}
