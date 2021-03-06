package org.dortelecan;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

    public static void main(String[] args) {
        System.out.println("Step 1");
        execute1(100);

        System.out.println("Step 1");
        execute2(100);
    }

    /*
    This implements step1 requirements, multiples of 3 buzz, multiples of 5 fizz, multiples of 15 FizzBuzz
     */
    public static List<String> execute1(int max) {
        return execute(max, FizzBuzz::isFizz, FizzBuzz::isBuzz);
    }

    /*
    This implements step2 requirements, multiples of 3 or numbers with 3 in them -> buzz,
    multiples of 5 or numbers with 5 in them fizz, multiples of 15 or numbers with 3 or 5 -> FizzBuzz
     */
    public static List<String> execute2(int max) {
        return execute(max, FizzBuzz::isFizz2, FizzBuzz::isBuzz2);
    }

    public static List<String> execute(int max, Predicate<Integer> fizz, Predicate<Integer> buzz) {
        return IntStream.range(0, max)
                .mapToObj(x -> map(x, fizz, buzz))
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    private static String map(int x, Predicate<Integer> fizz, Predicate<Integer> buzz) {
        boolean isfizz = fizz.test(x);
        boolean isbuzz = buzz.test(x);
        if (isbuzz && isfizz) {
            return "FizzBuzz";
        } else if (isfizz) {
            return "Fizz";
        } else if (isbuzz) {
            return "Buzz";
        } else {
            return String.valueOf(x);
        }
    }

    private static boolean isFizz2(int n) {
        return isFizzOrBuzz2(n, 3);
    }

    private static boolean isBuzz2(int n) {
        return isFizzOrBuzz2(n, 5);
    }

    /*
     * when testing I use return i % i2 == 0 || String.valueOf(i).indexOf(c) != -1;
     * But it is slower than the below.
     */
    private static boolean isFizzOrBuzz2(int n, int div) {
        if (n % div == 0) {
            return true;
        }

        int x = n;
        while (x > 0) {
            if (x % 10 == div) {
                return true;
            }
            x /= 10;
        }
        return false;
    }

    private static boolean isFizz(int n) {
        return n % 3 == 0;
    }

    private static boolean isBuzz(int n) {
        return n % 5 == 0;
    }
}
