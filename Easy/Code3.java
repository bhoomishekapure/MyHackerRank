import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
if (month == 1) {
            month = 11;
            year--;
        } else if (month == 2) {
            month = 12;
            year--;
        } else {
            month -= 2; 
        }

        int x = year % 100; 
        int y = year / 100; 
        int F = day + ((13 * month - 1) / 5) + x + (x / 4) + (y / 4) - 2 * y;

        while (F < 0) {
            F += 7;
        }

        String DAY;
        switch (F % 7) {
            case 0: DAY = "SUNDAY"; break;
            case 1: DAY = "MONDAY"; break;
            case 2: DAY = "TUESDAY"; break;
            case 3: DAY = "WEDNESDAY"; break;
            case 4: DAY = "THURSDAY"; break;
            case 5: DAY = "FRIDAY"; break;
            case 6: DAY = "SATURDAY"; break;
            default: DAY = "INVALID"; break;
        }

        return DAY;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
