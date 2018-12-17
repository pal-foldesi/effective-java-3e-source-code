package effectivejava.enums_and_annotations.use_enums_instead_of_int_constants;

public class DiscountedPriceTable {
    public static void main(String[] args) {
        for (Product product : Product.values())
            System.out.printf("Discounted price of product %10s is %.2f%n",
                    product, product.calculateDiscountedPrice());
    }
}
