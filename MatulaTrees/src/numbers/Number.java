// Number Class
// Stores the prime factorization and n-th prime position of some number

package numbers;

import java.util.ArrayList;

import pythonRequests.NthPrimeRequester;
import pythonRequests.PrimeFactorizationRequester;
import pythonRequests.PrimeIndexRequester;

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

    public String toString() {
        String out = "Number \n";
        out += "    value = " + value + "\n";
        out += "    isPrime = " + isPrime + "\n";
        out += "    primeIndex = " + primeIndex + "\n";
        out += "    primeFactors = " + getPrimeFactorsString() + "\n";
        return out;
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

    private String getPrimeFactorsString() {
        String result  = "";

        for (int i = 0; i < primeFactors.size(); i++) {
            result += primeFactors.get(i);

            if (i != primeFactors.size() - 1) {
                result += ", ";
            }

        }

        return result;
    }

}
