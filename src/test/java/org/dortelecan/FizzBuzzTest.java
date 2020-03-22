package org.dortelecan;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    @Test
    public void execute1() {
        List<String> data = FizzBuzz.execute1(100);
        for (int i = 0; i < data.size(); i++) {
            if (i % 15 == 0) {
                assertEquals("FizzBuzz", data.get(i));
            } else if (i % 3 == 0) {
                assertEquals("Fizz", data.get(i));
            } else if (i % 5 == 0) {
                assertEquals("Buzz", data.get(i));
            } else {
                assertEquals(String.valueOf(i), data.get(i));
            }
        }
    }

    @Test
    public void execute2() {
        List<String> data = FizzBuzz.execute2(100);
        for (int i = 0; i < data.size(); i++) {
            if (isFizz(i) && isBuzz(i)) {
                assertEquals("FizzBuzz", data.get(i));
            } else if (isFizz(i)) {
                assertEquals("Fizz", data.get(i));
            } else if (isBuzz(i)) {
                assertEquals("Buzz", data.get(i));
            } else {
                assertEquals(String.valueOf(i), data.get(i));
            }
        }
    }

    private boolean isBuzz(int i) {
        return divisibleOrContains(i, 5, '5');

    }

    private boolean isFizz(int i) {
        return divisibleOrContains(i, 3, '3');
    }

    private boolean divisibleOrContains(int i, int i2, char c) {
        return i % i2 == 0 || String.valueOf(i).indexOf(c) != -1;
    }
}