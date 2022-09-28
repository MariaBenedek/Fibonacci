package main;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciIterableTest {

    @Test
    void fibonacciIterable() {
        assertTrue(assertThrowException(0));
        assertTrue(assertThrowException(-1));
        assertTrue(assertThrowException(94));

        assertCorrect(new long[]{0}, 1);
        //assertCorrect(new long[]{0, 1}, 2);
        assertCorrect(new long[]{0, 1, 1}, 3);
        assertCorrect(new long[]{0, 1, 1, 2}, 4);
        assertCorrect(new long[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34}, 10);
    }

    private boolean assertThrowException(int length) {
        try {
            new FibonacciIterable(length);

            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private void assertCorrect(long[] expected, int length) {
        long[] result = getSequence(length);

        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }

    private long[] getSequence(int length) {
        FibonacciIterable fibonacci = new FibonacciIterable(length);

        long[] sequence = new long[length];

        int index = 0;
        for (FibonacciIterable elem : fibonacci) {
            sequence[index] = elem.getValue();
            index++;
        }

        return sequence;
    }

}