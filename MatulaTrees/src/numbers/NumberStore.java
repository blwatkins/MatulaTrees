// NumberStore Class
// Stores a single instance of each number

package numbers;

import java.util.HashMap;

public class NumberStore {
    private static HashMap<Integer, Number> numbers = new HashMap<>();

    public static void addNumber(int n) {
        if (!hasNumber(n)) {
            createNumber(n);
        }
    }

    private static boolean hasNumber(int n) {
        return numbers.containsKey(n);
    }

    private static void createNumber(int n) {
        Number number = new Number(n);
        numbers.put(n, number);
    }

}
