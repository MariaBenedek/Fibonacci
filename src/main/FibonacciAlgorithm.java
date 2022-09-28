package main;

/**
 * Contains methods to find the nth element of the Fibonacci series.
 */
public class FibonacciAlgorithm {

    /**
     * Standard algorithm for finding the nth Fibonacci element.
     *
     * @param nth is the number of Fibonacci element to find
     * @return the nth Fibonacci element
     */
    public static long findNthFibonacci(int nth) {
        FibonacciHelper.checkN(nth);

        int serialNumber = 1;
        long value = 0;
        long nextValue = 1;

        while (serialNumber < nth) {
            long current = value + nextValue;
            value = nextValue;
            nextValue = current;

            serialNumber++;
        }

        return value;
    }

    /**
     * Recursive algorithm for finding the nth Fibonacci element.
     * <br><br>
     * <strong>BEWARE!</strong>
     * This algorithm may lead to long runtimes.
     *
     * @param nth is the number of Fibonacci element to find
     * @return the nth Fibonacci element
     */
    public static long findNthFibonacciRecursive(int nth) {
        if (nth == 1) {
            return 0;
        }

        if (nth == 2) {
            return 1;
        }

        FibonacciHelper.checkN(nth);

        return findNthFibonacciRecursive(nth - 1) + findNthFibonacciRecursive(nth - 2);
    }

}
