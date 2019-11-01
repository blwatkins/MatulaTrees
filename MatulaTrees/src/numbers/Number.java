// Number Class
// Stores the prime factorization and n-th prime position of some number

package numbers;

import java.util.ArrayList;

import primeRequests.NthPrimeRequester;
import primeRequests.PrimeFactorizationRequester;
import primeRequests.PrimeIndexRequester;

public class Number {
    private long value;
    private boolean isPrime;
    private long primeIndex;
    private ArrayList<Long> primeFactors;

    public Number(long value) {
        this.value = value;
        isPrime = false;
        primeIndex = -1;
        primeFactors = null;
        buildNumber();
    }

    public Number(long value, boolean isPrime, long primeIndex, ArrayList<Long> primeFactors) {
        this.value = value;
        this.isPrime = isPrime;
        this.primeIndex = primeIndex;
        this.primeFactors = primeFactors;
    }

    private void buildNumber() {
        long possiblePrimeIndex = PrimeIndexRequester.requestPrimeIndex(value);
        long nthPrime = NthPrimeRequester.requestNthPrime(possiblePrimeIndex);

        if (value == nthPrime) {
            isPrime = true;
            primeIndex = possiblePrimeIndex;
        } else {
            isPrime = false;
            primeIndex = -1;
        }

        primeFactors = PrimeFactorizationRequester.requestPrimeFactors(value);
    }

}
