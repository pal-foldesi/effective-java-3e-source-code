package effectivejava.lambdas_and_streams.use_caution_when_making_streams_parallel;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.*;

// Parallel stream-based program to generate the first 20 Mersenne primes - HANGS!!!
public class ParallelMersennePrimes {
    public static void main(String[] args) {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .parallel()
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
}
