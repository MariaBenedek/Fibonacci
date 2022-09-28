package main;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciSerialTest {

    @Test
    void collectSequence() {
        assertTrue(assertThrowException(0));
        assertTrue(assertThrowException(-1));
        assertTrue(assertThrowException(94));

        assertEquals(Arrays.toString(new long[]{0}), sequenceToString(1));
        assertEquals(Arrays.toString(new long[]{0, 1}), sequenceToString(2));
        assertEquals(Arrays.toString(new long[]{0, 1, 1}), sequenceToString(3));
        assertEquals(Arrays.toString(new long[]{0, 1, 1, 2}), sequenceToString(4));
        assertEquals(Arrays.toString(new long[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34}), sequenceToString(10));
    }

    private boolean assertThrowException(int length) {
        try {
            new FibonacciSerial(length);

            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private String sequenceToString(int length) {
        return Arrays.toString(new FibonacciSerial(length).collectSequence());
    }

}