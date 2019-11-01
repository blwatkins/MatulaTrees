package primeRequests;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;

public abstract class PythonScriptRunner {

    public static ArrayList<Long> runPythonScript(String scriptName, long num) {
        ArrayList<Long> result = null;

        String command = "python python/" + scriptName + ".py " + num;

        try {
            Process p = Runtime.getRuntime().exec(command);
            result = getProcessOutput(p);
        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }

    private static ArrayList<Long> getProcessOutput(Process p) {
        ArrayList<Long> result = null;

        try {
            InputStream inputStream = p.getInputStream();
            InputStreamReader iStreamReader = new InputStreamReader(inputStream);
            BufferedReader input = new BufferedReader(iStreamReader);
            String resultString = input.readLine();
            result = parseResultString(resultString);
        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }

    private static ArrayList<Long> parseResultString(String string){
        ArrayList<Long> result = new ArrayList<>();
        String[] longs = string.split(" ");

        for (String longString: longs) {
            Long num = Long.parseLong(longString);
            result.add(num);
        }

        return result;
    }

}
