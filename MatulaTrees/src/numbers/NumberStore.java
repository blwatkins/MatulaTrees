// NumberStore Class
// Stores a single instance of each number

package numbers;

import java.util.HashMap;

import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

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

        for (int i = 0; i < numberData.size(); i++) {
            JSONObject numberJSON = numberData.getJSONObject(i);
            //Number n = new Number(numberJSON);
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
