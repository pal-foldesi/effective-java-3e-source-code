package effectivejava.methods.use_overloading_judiciously;

import java.util.List;

// Classification using method overrriding
public class Overriding {
    public static void main(String[] args) {
        List<Animal> animals = List.of(
                new Animal(), new Fish(), new Shark());

        for (Animal animal : animals)
            System.out.println(animal.name());
    }
}
