/*-----------------------
* Submitted by: 036016368
-----------------------*/
package ex1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

    public static void main(String[] args) {

        Hash_Passwords_JSON hpj = new Hash_Passwords_JSON();

        int num = 10;
        long[] durations = checkDuration(hpj, num);

        printArr(durations);

        long memUsed = checkMemUsage(hpj);
        System.out.println("Memory used: " + memUsed);

    }

    /* Check time at the start of the program.
    Parameters:
        hpj - Hash_Passwords_JSON object to test.
        num - Number of times to check.
    Return:
        An array of run durations.
     */
    public static long[] checkDuration(Hash_Passwords_JSON hpj, int num) {
        long[] durations = new long[num];

        for (int i = 0; i < num; i++) {
            long startTime = System.currentTimeMillis();

            hpj.hash();

            // Check time at the end of the program.
            long endTime = System.currentTimeMillis();

            //System.out.println("starTime: " + startTime); //DEBUG
            //System.out.println("endTime: " + endTime); //DEBUG

            // Total running time of the program.
            long duration = endTime - startTime;
            //System.out.println("Duration of the program: " + duration); //DEBUG

            durations[i] = duration;
        }

        return durations;
    }

    // Check memory before the program runs.
    public static long checkMemUsage(Hash_Passwords_JSON hpj) {

        System.gc(); // Call garbage collector to get more accurate results.
        Runtime runTime = Runtime.getRuntime();
        long memBefore = runTime.totalMemory() - runTime.freeMemory();

        hpj.hash();

        // Check memory after the program runs.
        long memAfter = runTime.totalMemory() - runTime.freeMemory();

        // Calculate memory usage.
        long memUsed = memAfter - memBefore;

        //System.out.println("memBefore: " + memBefore); //DEBUG
        //System.out.println("memAfter: " + memAfter); //DEBUG
        //System.out.println("Memory used: " + memUsed); //DEBUG
        
        return memUsed;
    }
    
    // Function to print an array.
    public static void printArr(long[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1]);
    }
}
