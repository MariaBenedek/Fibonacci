package main;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciAlgorithmTest {

    @Test
    void findNthFibonacci() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = FibonacciAlgorithm.class.getMethod("findNthFibonacci", int.class);
        method.setAccessible(true);

        assertTrue(assertThrowException(method, 0));
        assertTrue(assertThrowException(method, -1));
        assertTrue(assertThrowException(method, 94));

        assertCorrect(method, 1, 0);
        assertCorrect(method, 2, 1);
        assertCorrect(method, 3, 1);
        assertCorrect(method, 4, 2);
        assertCorrect(method, 10, 34);
        assertCorrect(method, 11, 55);
        assertCorrect(method, 93, 7540113804746346429L);
    }

    @Test
    void findNthFibonacciRecursive() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = FibonacciAlgorithm.class.getMethod("findNthFibonacciRecursive", int.class);
        method.setAccessible(true);

        assertTrue(assertThrowException(method, 0));
        assertTrue(assertThrowException(method, -1));
        assertTrue(assertThrowException(method, 94));

        assertCorrect(method, 1, 0);
        assertCorrect(method, 2, 1);
        assertCorrect(method, 3, 1);
        assertCorrect(method, 4, 2);
        assertCorrect(method, 10, 34);
        assertCorrect(method, 11, 55);

        // do not try to run the test case below...
        //assertCorrect(method, 93, 7540113804746346429L);
    }

    private boolean assertThrowException(Method method, int n) {
        try {
            Object result = method.invoke(FibonacciAlgorithm.class, n);

            return false;
        } catch (InvocationTargetException e) {
            return true;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Something went wrong.");
        }
    }

    private void assertCorrect(Method method, int n, long expected) throws InvocationTargetException, IllegalAccessException {
        Object result = method.invoke(FibonacciAlgorithm.class, n);
        assertEquals(expected, (long) result);
    }

}