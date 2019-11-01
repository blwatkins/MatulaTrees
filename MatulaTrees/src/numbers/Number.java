// Number Class
// Stores the prime factorization and n-th prime position of some number

package numbers;

import java.util.ArrayList;

public class Number {
    private long value;
    private boolean isPrime;
    private long primeIndex;
    private ArrayList<Integer> primeFactors;

    public Number(long value) {
        this.value = value;
        isPrime = false;
        primeIndex = -1;
        primeFactors = null;
    }

    public Number(long value, boolean isPrime, long primeIndex, ArrayList<Integer> primeFactors) {
        this.value = value;
        this.isPrime = isPrime;
        this.primeIndex = primeIndex;
        this.primeFactors = primeFactors;
    }

}
