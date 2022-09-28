package main;

/**
 * Class to collect the first n elements of the Fibonacci series.
 */
public class FibonacciSerial {

    /** Length of the Fibonacci series. */
    private static int sequenceLength;

    /** Position of the current Fibonacci number. */
    private final int index;

    /** The current Fibonacci number. */
    private final long value;

    /** The previous Fibonacci number. */
    private long prevValue;

    /**
     *
     * @param length {@link FibonacciSerial#sequenceLength}
     */
    public FibonacciSerial(int length) {
        FibonacciHelper.checkN(length);

        sequenceLength = length;
        index = 1;
        value = 0;
    }

    /**
     * Private constructor to calculate the next element of the Fibonacci series.
     *
     * @param index {@link FibonacciSerial#index}
     * @param value {@link FibonacciSerial#value}
     */
    private FibonacciSerial(int index, long value) {
        this.index = index;
        this.value = value;
    }

    /**
     * Private constructor to calculate the next element of the Fibonacci series.
     *
     * @param index {@link FibonacciSerial#index}
     * @param value {@link FibonacciSerial#value}
     * @param prevValue {@link FibonacciSerial#prevValue}
     */
    private FibonacciSerial(int index, long value, long prevValue) {
        this(index, value);
        this.prevValue = prevValue;
    }

    /**
     *
     * @return the next element of the Fibonacci series
     */
    private FibonacciSerial next() {
        if (this.index < sequenceLength) {
            int nextIndex = this.index + 1;
            if (this.index == 1) {
                return new FibonacciSerial(nextIndex, 1);
            } else {
                long nextValue = this.value + this.prevValue;
                return new FibonacciSerial(nextIndex, nextValue, this.value);
            }
        }

        return null;
    }

    /**
     * Calculates the required Fibonacci series, and collects the numbers
     * into an array.
     *
     * @return the collected Fibonacci numbers
     */
    public long[] collectSequence() {
        long[] sequence = new long[sequenceLength];

        FibonacciSerial next = next();

        while (next != null) {
            sequence[next.index - 1] = next.value;
            next = next.next();
        }

        return sequence;
    }

}
