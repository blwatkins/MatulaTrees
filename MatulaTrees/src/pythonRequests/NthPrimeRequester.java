package pythonRequests;

import java.util.ArrayList;

public class NthPrimeRequester extends PythonScriptRunner {

    public static long requestNthPrime(long num) {
        ArrayList<Long> requestResult = runPythonScript("nth_prime", num);
        long result = -1;

        if (requestResult != null) {
            result = requestResult.get(0);
        }

        System.out.println("SCRIPT RESULT : " + result);
        return result;
    }

}
