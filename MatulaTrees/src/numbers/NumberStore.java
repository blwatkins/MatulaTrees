// NumberStore Class
// Stores a single instance of each number
// The NumberStore ensures that only one copy of every number exists in the environment
// This prevents multiple python requests from having to be made during the course of the program running
// The NumberStore can be output to a JSON Array and loaded in during the next program run
// This also prevents excess python requests from having to be made over multiple executions of the program

package numbers;

import java.util.HashMap;

import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;
import pythonRequests.NthPrimeRequester;

public class NumberStore {
    private static HashMap<Long, Number> numbers = new HashMap<>();
    private static HashMap<Long, Long> nthPrimes = new HashMap<>();

    public static Number getNumber(long value) {
        if (!hasNumber(value)) {
            addNumber(value);
        }

        return numbers.get(value);
    }

    public static long getNthPrimeNumber(long n) {
        if (!hasNthPrimeNumber(n)) {
            addNthPrimeNumber(n);
        }

        return nthPrimes.get(n);
    }

    private static void addNumber(long value) {
        createNumber(value);
    }

    private static void addNthPrimeNumber(long n) {
        long nthPrime = NthPrimeRequester.requestNthPrime(n);
        nthPrimes.put(n, nthPrime);
    }

    private static boolean hasNumber(long value) {
        return numbers.containsKey(value);
    }

    private static boolean hasNthPrimeNumber(long n) {
        return nthPrimes.containsKey(n);
    }

    private static void createNumber(long value) {
        System.out.println("-------------------------");
        System.out.println("CREATING NUMBER: " + value);
        Number number = new Number(value);

        if (number.getPrimeFactors() != null) {
            numbers.put(value, number);
            boolean addToNthPrimes = number.isPrime() && !hasNthPrimeNumber(number.getValue());

            if (addToNthPrimes) {
                nthPrimes.put(number.getPrimeIndex(), number.getValue());
            }

        }

    }

    public static void output() {

        for (long number: numbers.keySet()) {
            System.out.println(numbers.get(number));
        }

    }

    public static void loadNumbers(PApplet p) {
        JSONArray numberData = p.loadJSONArray("out/numbers.json");

        for (int i = 0; i < numberData.size(); i++) {
            JSONObject numberJSON = numberData.getJSONObject(i);
            Number number = new Number(numberJSON);
            long value = number.getValue();
            numbers.put(value, number);
        }

    }

    public static void saveNumbers(PApplet p) {
        JSONArray numberData = new JSONArray();

        for (long number: numbers.keySet()) {
            Number n = numbers.get(number);
            JSONObject numberJSON = n.getJSON();
            numberData.append(numberJSON);
        }

        p.saveJSONArray(numberData, "data/out/numbers.json");
    }

}
