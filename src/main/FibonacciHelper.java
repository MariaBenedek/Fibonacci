package main;

/**
 * Helper class to find element of the Fibonacci series.
 */
public class FibonacciHelper {

    /**
     * Checks the n.
     * <br><br>
     * The value of n must be a number between 1 and 93, because:
     * <ul>
     *     <li>there are no negative or zero Fibonacci numbers</li>
     *     <li>the primitive data type {@code long} cannot store a Fibonacci number greater than 93</li>
     * </ul>
     * @param n is the number of Fibonacci element to find
     */
    public static void checkN(int n) {
        if (n < 1 || n > 93) {
            throw new ArithmeticException("Invalid Fibonacci serial number. Please give a number between 1 and 93.");
        }
    }

}
