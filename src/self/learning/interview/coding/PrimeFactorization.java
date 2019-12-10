package publicis.sapient.answer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Return an array containing prime numbers whose product is x
 * Examples:
 * primeFactorization( 6 ) == [2,3]
 * primeFactorization( 5 ) == [5]
 */
public class PrimeFactorization {
    private static List<Integer> primeFactorization(final int number) {
        int counter = 2;
        while (counter <= number / 2) {
            if (number % counter == 0 && isPrime(counter) && isPrime(number / counter))
                return Arrays.asList(counter, number / counter);
            counter++;
        }
        return Collections.singletonList(number);
    }

    private static boolean isPrime(final int number) {
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }

    public static void main(String[] args) {
        if (primeFactorization(6).equals(Arrays.asList(2, 3))
                &&
                primeFactorization(5).equals(Collections.singletonList(5))
                &&
                primeFactorization(35).equals(Arrays.asList(5, 7))
        ) {
            System.out.println("All passed");
        } else {
            System.out.println("Failed");
        }

    }

}
