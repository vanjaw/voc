package org.python.types;

import org.python.types.List;

public class ListWorkloadInsert {
    public static void workload() {
        long startTime = System.nanoTime();

        org.python.types.List x = new org.python.types.List(
            new java.util.ArrayList()
        );
        for(int i=0; i < 72000; i++) {
            x.insert(
                org.python.types.Int.getInt(0),
                org.python.types.Int.getInt(i)
            );
        }

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Time elapsed: " + timeElapsed);
    }
}
