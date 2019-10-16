package org.python.types;

import org.python.types.List;
import java.util.Random;

public class ListWorkloadSort {
    private static int list_size = 1000000;

    public static void workload() {
        // Workload here

        List test_list = new List();

        Random rand = new Random();

        for(int i = 0; i < list_size; i++){
          int randint = rand.nextInt(100);
          test_list.append(Int.getInt(randint));
        }
        /*
        long start = System.currentTimeMillis();
        test_list.sort(null,null);
        long finish = System.currentTimeMillis();
        System.out.println("Duration: " + (start-finish));
        */
    }
}
