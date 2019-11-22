// Number Class
// Stores the value, prime factorization, and n-th prime position of some number
// Numbers can be converted to JSON for file output

package numbers;

import java.util.ArrayList;

import processing.data.JSONArray;
import processing.data.JSONObject;

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

    public Number(JSONObject number) {
        value = number.getLong("value");
        isPrime = number.getBoolean("isPrime");
        primeIndex = number.getLong("primeIndex");
        primeFactors = new ArrayList<>();
        loadPrimeFactors(number);
    }

    public long getValue() {
        return value;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public long getPrimeIndex() {
        return primeIndex;
    }

    public ArrayList<Long> getPrimeFactors() {
        return primeFactors;
    }

    public JSONObject getJSON() {
        JSONObject number = new JSONObject();
        number.setLong("value", getValue());
        number.setBoolean("isPrime", isPrime());
        number.setLong("primeIndex", getPrimeIndex());
        JSONArray primeFactors = createFactorsArray();
        number.setJSONArray("primeFactors", primeFactors);
        return number;
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
        boolean validResults = (possiblePrimeIndex != -1 && nthPrime != -1) || value == 1;

        if (validResults) {
            buildNumber(nthPrime, possiblePrimeIndex);
            primeFactors = PrimeFactorizationRequester.requestPrimeFactors(value);
            checkForValidPrimeFactors();
        }

    }

    private void buildNumber(long nthPrime, long possiblePrimeIndex) {
        if (value == nthPrime) {
            isPrime = true;
            primeIndex = possiblePrimeIndex;
        } else {
            isPrime = false;
            primeIndex = -1;
        }
    }

    private void checkForValidPrimeFactors() {
        if (primeFactors.isEmpty() && value != 1) {
            primeFactors = null;
        }
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

    private JSONArray createFactorsArray() {
        JSONArray factors = new JSONArray();

        for (long number: primeFactors) {
            factors.append(number);
        }

        return factors;
    }

    private void loadPrimeFactors(JSONObject number) {
        JSONArray primeFactorsJSON = number.getJSONArray("primeFactors");

        for (int i = 0; i < primeFactorsJSON.size(); i++) {
            long factor = primeFactorsJSON.getLong(i);
            primeFactors.add(factor);
        }

    }
}
