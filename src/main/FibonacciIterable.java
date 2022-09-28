package main;

import java.util.Iterator;

/**
 * {@link Iterable} class to find the first n elements of the Fibonacci series.
 */
public class FibonacciIterable implements Iterable<FibonacciIterable> {

    /** Length of the Fibonacci series. */
    private static int sequenceLength;

    /** Position of the current Fibonacci number. */
    private int index;

    /** The current Fibonacci number. */
    private long value;

    /** The previous Fibonacci number. */
    private long prevValue;

    /**
     *
     * @param length {@link FibonacciIterable#sequenceLength}
     */
    public FibonacciIterable(int length) {
        FibonacciHelper.checkN(length);

        sequenceLength = length;
    }

    /**
     *
     * @return {@link FibonacciIterable#value}
     */
    public long getValue() {
        return value;
    }

    /**
     *
     * @return the string
     */
    @Override
    public String toString() {
        return index + ". " + value;
    }

    /**
     *
     * @return the {@link FibonacciIterator}
     */
    @Override
    public Iterator<FibonacciIterable> iterator() {
        return new FibonacciIterator(this);
    }

    /**
     * {@link Iterator} class for {@link FibonacciIterable}.
     */
    static class FibonacciIterator implements Iterator<FibonacciIterable> {

        /** {@link FibonacciIterable}. */
        private final FibonacciIterable fibonacci;

        /**
         *
         * @param fibonacci {@link FibonacciIterator#fibonacci}
         */
        public FibonacciIterator(FibonacciIterable fibonacci) {
            this.fibonacci = fibonacci;
        }

        /**
         *
         * @return true if the current Fibonacci serial number is lesser than the expected
         */
        @Override
        public boolean hasNext() {
            return fibonacci.index < sequenceLength;
        }

        /**
         *
         * @return the next number of the Fibonacci series
         */
        @Override
        public FibonacciIterable next() {
            int nextIndex = fibonacci.index + 1;

            if (fibonacci.index == 1) {
                fibonacci.value = 1;
            } else if (fibonacci.index > 1) {
                long nextValue = fibonacci.value + fibonacci.prevValue;
                fibonacci.prevValue = fibonacci.value;
                fibonacci.value = nextValue;
            }

            fibonacci.index = nextIndex;

            return fibonacci;
        }
    }

}
