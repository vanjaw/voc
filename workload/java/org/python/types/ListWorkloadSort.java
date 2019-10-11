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

        long start = System.currentTimeMillis();
        test_list.sort(null,null);
        long finish = System.currentTimeMillis();
        System.out.println("Duration: " + (start-finish));

    }
}



/*
Conjecture of dreams :

Considering a significant list size with a significant amount of elements then :
When using a LinkedList datatype implementation, the sorting should perform worse considering
the cost of traversing the list each time when making comparisons between the different elements.


Tests pass after changing to LinkedList ...

*/
