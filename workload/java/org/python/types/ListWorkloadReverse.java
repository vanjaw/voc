package org.python.types;

public class ListWorkloadReverse implements ListWorkload.Workload {
    public String name() {
        return "reverse";
    }

    public void workload() {
        org.python.types.Range range = new org.python.types.Range(Int.getInt(10000));
        org.python.Object[] objArray = {range};
        org.python.types.List list = new org.python.types.List(objArray, null);

        for(int i = 0; i<10000; i++) {
            list.reverse();
        }
    }
}