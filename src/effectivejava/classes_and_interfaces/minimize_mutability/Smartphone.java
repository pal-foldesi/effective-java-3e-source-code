package effectivejava.classes_and_interfaces.minimize_mutability;

//Immutable class
public final class Smartphone {
    private final String brand;
    private final double price;

    public Smartphone(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public Smartphone newPrice(double price) {
        return new Smartphone(this.brand, price);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Smartphone)) {
            return false;
        }
        Smartphone that = (Smartphone)o;
        return this.brand.equals(that.brand) && this.price == that.price;
    }

    @Override
    public int hashCode() {
        return 31 * brand.hashCode() + Double.hashCode(this.price);
    }

    @Override
    public String toString() {
        return String.format("Smartphone of brand %s price %.2f", this.brand, this.price);
    }
}