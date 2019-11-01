package primeRequests;

import java.util.ArrayList;

public class PrimeFactorizationRequester extends PythonScriptRunner {

    public static ArrayList<Long> requestPrimeFactors(long num) {
        ArrayList<Long> requestResult = runPythonScript("prime_factors_of_n", num);

        if (requestResult == null) {
            requestResult = new ArrayList<>();
        }

        return requestResult;
    }
}