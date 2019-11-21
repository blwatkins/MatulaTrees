// NumberStore Class
// Stores a single instance of each number

package numbers;

import java.util.ArrayList;
import java.util.HashMap;

import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

// TODO: Transfer creation of JSON object to Number class

public class NumberStore {
    private static HashMap<Long, Number> numbers = new HashMap<>();

    public static void addNumber(long n) {
        if (!hasNumber(n)) {
            createNumber(n);
        }
    }

    private static boolean hasNumber(long n) {
        return numbers.containsKey(n);
    }

    private static void createNumber(long n) {
        Number number = new Number(n);
        numbers.put(n, number);
    }

    public static void output() {

        for (long number: numbers.keySet()) {
            System.out.println(numbers.get(number));
        }

    }

    public static void loadNumbers(PApplet p) {
        JSONArray numberData = p.loadJSONArray("numbers.json");
    }

    public static void saveNumbers(PApplet p) {
        JSONArray numberData = new JSONArray();

        for (long number: numbers.keySet()) {
            JSONObject numberJSON = new JSONObject();
            Number n = numbers.get(number);
            numberJSON.setLong("value", n.getValue());
            numberJSON.setBoolean("isPrime", n.isPrime());
            numberJSON.setLong("primeIndex", n.getPrimeIndex());
            JSONArray primeFactors = createFactorsArray(n.getPrimeFactors());
            numberJSON.setJSONArray("primeFactors", primeFactors);
            numberData.append(numberJSON);
        }

        p.saveJSONArray(numberData, "data/out/numbers.json");
    }

    private static JSONArray createFactorsArray(ArrayList<Long> primeFactors) {
        JSONArray factors = new JSONArray();

        for (long number: primeFactors) {
            factors.append(number);
        }

        return factors;
    }

}
