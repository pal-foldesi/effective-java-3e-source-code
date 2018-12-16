package effectivejava.classes_and_interfaces.prefer_class_hierarchies_to_tagged_classes.hierarchy;

public class Banknote extends PaperProduct {

    private final int denomination;
    private final String front;
    private final String back;

    public Banknote(int width, int height, int denomination, String front, String back) {
        this.width = width;
        this.height = height;
        this.denomination = denomination;
        this.front = front;
        this.back = back;
    }

    public void make() {
        String makingProcess = String.format("Press a sheet of size %.2f x %.2f. Apply motif %s to the front and motif %s to the back," +
                        " then apply the denomination %d to the sheet.",
                this.width, this.height, this.front, this.back, this.denomination);
        System.out.println(makingProcess);
    }
}
