package effectivejava.enums_and_annotations.use_enums_instead_of_int_constants;

public enum Product {
    MILK(1.5, 0.15),
    CHOCOLATE(5, 0.3),
    DEODORANT(5.2, 0.25),
    DETERGENT(8.7, 0.12);

    private final double price;
    private final double discount;

    Product(double price, double discount) {
        this.price = price;
        this.discount = discount;
    }

    public double calculateDiscountedPrice() {
        return this.price * (1 - discount);
    }
}
