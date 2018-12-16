package effectivejava.classes_and_interfaces.prefer_class_hierarchies_to_tagged_classes.taggedclass;

public class PaperProduct {
    enum Product {
        ROLL_PAPER, BANKNOTE
    }

    final Product product;

    double width;
    double height;

    int layerCount;

    int denomination;
    String front;
    String back;

    public PaperProduct(double width, double height, int layerCount) {
        this.product = Product.ROLL_PAPER;
        this.width = width;
        this.height = height;
        this.layerCount = layerCount;
    }

    public PaperProduct(double width, double height, int denomination, String front, String back) {
        this.product = Product.BANKNOTE;
        this.width = width;
        this.height = height;
        this.denomination = denomination;
        this.front = front;
        this.back = back;
    }

    public void make() {
        switch (this.product) {
            case ROLL_PAPER:
                System.out.println(
                        String.format("%d times, make a sheet of size %.2f x %.2f.",
                        this.layerCount, this.width, this.height)
                );
                break;
            case BANKNOTE:
                System.out.println(
                        String.format("Make a sheet of size %.2f x %.2f. Apply motif %s to the front and motif %s to the back," +
                                        " then apply the denomination %d onto the sheet.",
                                this.width, this.height, this.front, this.back, this.denomination)
                );
                break;
            default :
                throw new AssertionError(this.product);
        }
    }
}
