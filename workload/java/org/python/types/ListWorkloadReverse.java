package org.python.types;

import org.Python;

public class ListWorkloadReverse {
    public static void workload() {
        org.python.types.Range range = new org.python.types.Range(10000000);
        org.python.types.List list = new org.python.types.List(range);

        for(int i = 0; i<100; i++) {
            list.reverse();
        }
    }
}