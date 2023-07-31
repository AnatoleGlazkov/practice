package ru.algorithms.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * The type CountPrimesTest
 * {@link <a href="https://leetcode.com/problems/count-primes/">...</a>}
 */
public class CountPrimesTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(10, 4),
            Arguments.of(0, 0),
            Arguments.of(1, 0),
            Arguments.of(3, 1),
            Arguments.of(4, 2),
            Arguments.of(10000, 1229)
        );
    }

    @DisplayName("204. Count Primes")
    @ParameterizedTest
    @MethodSource("source")
    void countPrimes(
        int n,
        int expected
    ) {

        boolean[] isComposite = new boolean[n];

        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!isComposite[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    isComposite[i * j] = true;
                }
            }
        }

//        return count;

//        int counter= 0;
//        for (int i = 0; i < n; i++) {
//            if(checkPrime(i)){
//                counter++;
//            }
//        }

        Assertions.assertEquals(expected, count);
    }

    private boolean checkPrime(int n) {
        if (n < 2) {
            return false;
        }

        double s = Math.sqrt(n);
        for (int i = 2; i <= s; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }


    public static int countPrimes(int n) {
        boolean[] isComposite = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!isComposite[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    isComposite[i * j] = true;
                }
            }
        }

        return count;
    }
}
