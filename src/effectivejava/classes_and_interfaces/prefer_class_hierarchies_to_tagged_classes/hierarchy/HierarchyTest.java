package effectivejava.classes_and_interfaces.prefer_class_hierarchies_to_tagged_classes.hierarchy;

public class HierarchyTest {
    public static void main(String[] args) {
        PaperProduct paperRollInstance = new RollPaper(40, 20,
                3);
        paperRollInstance.make();
        PaperProduct banknoteInstance = new Banknote(14, 7,
                1000,
                "Mark Twain",
                "Huckleberry Finn");
        banknoteInstance.make();
    }
}
