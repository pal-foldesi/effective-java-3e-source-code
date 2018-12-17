package effectivejava.lambdas_and_streams.use_caution_when_making_streams_parallel;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class ParallelPrimeCounting {
    // Prime-counting stream pipeline - parallel version
    static long pi(long n) {
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    public static void main(String[] args) {
        System.out.println(pi(10_000_000));
    }
}
