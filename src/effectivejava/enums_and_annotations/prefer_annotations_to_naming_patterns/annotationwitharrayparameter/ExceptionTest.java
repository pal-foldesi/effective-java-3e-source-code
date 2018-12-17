package effectivejava.enums_and_annotations.prefer_annotations_to_naming_patterns.annotationwitharrayparameter;
import java.lang.annotation.*;

// Annotation type with an array parameter
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
    Class<? extends Exception>[] value();
}