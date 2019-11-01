package primeRequests;

import java.util.ArrayList;

public class PrimeIndexRequester extends PythonScriptRunner {

    public static long requestPrimeIndex(long n) {
        ArrayList<Long> requestResult = runPythonScript("pi_of_n", n);
        long result = -1;

        if (requestResult != null) {
            result = requestResult.get(0);
        }

        return result;
    }

}
