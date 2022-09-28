package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    private static int sum(int x, int y) {
        return x + y;
    }

    @Test
    void sample() {
        int result = sum(1, 1);
        int expected = 2;
        assertEquals(expected, result);

        result = sum(1, 2);
        expected = 3;
        assertEquals(expected, result);
    }

    @Test
    void fibonacciTest() {
        assertEquals("Volt exception, juhú!", throwException(0));
        assertEquals("Volt exception, juhú!", throwException(94));
        
        assertEquals(0, FibonacciAlgorithm.findNthFibonacci(1));
        assertEquals(1, FibonacciAlgorithm.findNthFibonacci(2));
        assertEquals(34, FibonacciAlgorithm.findNthFibonacci(10));
        assertEquals(7540113804746346429L,
                FibonacciAlgorithm.findNthFibonacci(93));
    }

    private String throwException(int nth) {
        try {
            long result = FibonacciAlgorithm.findNthFibonacci(nth);
            return "Nem volt exception!";
        } catch (Exception e) {
            return "Volt exception, juhú!";
        }
    }

}