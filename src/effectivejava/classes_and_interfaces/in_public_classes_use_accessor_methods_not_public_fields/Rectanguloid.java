package effectivejava.classes_and_interfaces.in_public_classes_use_accessor_methods_not_public_fields;

// Public class with exposed immutable fields - questionable
public class Rectanguloid {
    public final int width;
    public final int height;
    public final int length;

    public Rectanguloid(int width, int height, int length) {
        if (width <= 0 || height <= 0 || length <= 0) {
            throw new IllegalArgumentException("All dimensions must be >0!");
        }
        this.width = width;
        this.height = height;
        this.length = length;
    }
}