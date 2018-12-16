package effectivejava.classes_and_interfaces.in_public_classes_use_accessor_methods_not_public_fields;

// Encapsulation of data by accessor methods and mutators
public class CellPhone {
    private String brand;
    private double price;

    public CellPhone(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}