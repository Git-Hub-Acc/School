package ex1;

public class Main {

    public static void main(String[] args) {

        Hash_Pwds_JSON hpj = new Hash_Pwds_JSON(); // Create Hash_Pwds_JSON object.

        int num = 10;
        long[] durations = checkDuration(hpj, num); // Execute checkDuration() function 10 times.

        printArr(durations);

        long memUsed = checkMemUsage(hpj); // how much memory the program used.
        System.out.println("Memory used: " + memUsed + " Mbs.");

    }

    /* -------------------------------------------------
    Check time at the start of the program.
        Parameters:
            hpj - Hash_Pwds_JSON object to test.
            num - Number of times to check.
        Return:
            An array of run durations.
     -------------------------------------------------*/
    public static long[] checkDuration(Hash_Pwds_JSON hpj, int num) {
        long[] durations = new long[num];

        for (int i = 0; i < num; i++) {
            long startTime = System.currentTimeMillis();

            hpj.hash();

            // Check time at the end of the program.
            long endTime = System.currentTimeMillis();

            // Total running time of the program.
            long duration = endTime - startTime;

            durations[i] = duration;
        }
        return durations;
    }

    /* -------------------------------------------------
    Calculates the memory used by the program.
        Parameters:
            hpj - Hash_Pwds_JSON object to test.
        Return:
            The amount of memory used.
     -------------------------------------------------*/
    public static long checkMemUsage(Hash_Pwds_JSON hpj) {

        System.gc(); // Call garbage collector to get more accurate results.
        Runtime runTime = Runtime.getRuntime();
        long memBefore = runTime.totalMemory() - runTime.freeMemory(); // Memory used before the program execution.

        hpj.hash();

        // Check memory after the program's execution.
        long memAfter = runTime.totalMemory() - runTime.freeMemory();

        // Calculate memory usage.
        long memUsed = memAfter - memBefore;

        return memUsed;
    }

    // Function to print an array.
    public static void printArr(long[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            System.out.print(arr[i] + ", ");
        
        System.out.println(arr[arr.length - 1]);
    }
}
