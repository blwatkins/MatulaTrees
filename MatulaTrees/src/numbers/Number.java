// Number Class
// Stores the prime factorization and n-th prime position of some number

package numbers;

import java.util.ArrayList;

public class Number {
    private int value;
    private boolean isPrime;
    private int primeIndex;
    private ArrayList<Integer> primeFactors;

    public Number(int value) {
        this.value = value;
        isPrime = false;
        primeIndex = -1;
        primeFactors = null;
    }

}
