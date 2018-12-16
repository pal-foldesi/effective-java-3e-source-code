package effectivejava.classes_and_interfaces.prefer_class_hierarchies_to_tagged_classes.hierarchy;

public class RollPaper extends PaperProduct {
    int layerCount;

    public RollPaper(int width, int height, int layerCount) {
        this.width = width;
        this.height = height;
        this.layerCount = layerCount;
    }

    public void make() {
        String makingProcess = String.format("%d times, press a sheet of size %.2f x %.2f.",
                this.layerCount, this.width, this.height);
        System.out.println(makingProcess);
    }
}
