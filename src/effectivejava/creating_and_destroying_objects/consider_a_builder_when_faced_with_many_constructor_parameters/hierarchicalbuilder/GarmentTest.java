package effectivejava.creating_and_destroying_objects.consider_a_builder_when_faced_with_many_constructor_parameters.hierarchicalbuilder;

import static effectivejava.creating_and_destroying_objects.consider_a_builder_when_faced_with_many_constructor_parameters.hierarchicalbuilder.Garment.Material.*;
import static effectivejava.creating_and_destroying_objects.consider_a_builder_when_faced_with_many_constructor_parameters.hierarchicalbuilder.BusinessSuit.Brand.GUCCI;

// Using the hierarchical builder
public class GarmentTest {
    public static void main(String[] args) {
        SuperheroCostume batman = new SuperheroCostume.Builder("Batman").addMaterial(SPANDEX).addMaterial(POLYESTER).build();
        BusinessSuit salesman = new BusinessSuit.Builder().brand(GUCCI).addMaterial(COTTON).build();

        System.out.println(batman);
        System.out.println(salesman);
    }
}
