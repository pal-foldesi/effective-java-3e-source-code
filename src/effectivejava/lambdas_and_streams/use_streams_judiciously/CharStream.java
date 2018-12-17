package effectivejava.lambdas_and_streams.use_streams_judiciously;

// Refrain from using streams to process char values
public class CharStream {
    public static void main(String[] args) {
        // Does not produce the expected result
        "Hello world!".chars().forEach(System.out::print);
        System.out.println();

        // Fixes the problem
        "Hello world!".chars().forEach(x -> System.out.print((char) x));
        System.out.println();
    }
}
