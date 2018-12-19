package effectivejava.exceptions.use_exceptions_only_for_exceptional_conditions;

import java.util.concurrent.ThreadLocalRandom;

public class MisusedException {
    public static void main(String[] args) {
        final double ONE_MILLION = 1_000_000.0;

        ThreadLocalRandom random = ThreadLocalRandom.current();

        int arrSize = random.nextInt(100, 1000);

        int[] arr1 = new int[arrSize];
        int[] arr2 = new int[arrSize];

        long start1 = System.nanoTime();

        // Horrible abuse of exceptions. Don't ever do this!
        try {
            int i = 0;
            while(true)
                arr1[i++] = random.nextInt();
        } catch (ArrayIndexOutOfBoundsException e) { }

        long end1 = System.nanoTime();

        long start2 = System.nanoTime();

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = random.nextInt();
        }

        long end2 = System.nanoTime();

        System.out.println("With while loop and exception: " + (end1 - start1) / ONE_MILLION + " s");

        System.out.println("With for loop: " + (end2 - start2) / ONE_MILLION + " s");

        /*for (int x : arr1) {
            System.out.printf("%2d", x);
        }

        System.out.println();

        for (int x : arr2) {
            System.out.printf("%2d", x);
        }*/
    }
}