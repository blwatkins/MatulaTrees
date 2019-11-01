// NumberStore Class
// Stores a single instance of each number

package numbers;

import java.util.HashMap;

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

}
