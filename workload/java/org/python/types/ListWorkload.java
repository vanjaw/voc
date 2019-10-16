package org.python.types;

public class ListWorkload {
    public static void main(String[] args) {
        Workload[] workloads = {
            new ListWorkloadSort(),
            new ListWorkloadSlice(),
            new ListWorkloadReverse(),
            new ListWorkloadRemove()
        };

        long maxLength = 0;

        for (int i = 0; i < workloads.length; i++) {
            maxLength = Math.max(maxLength, workloads[i].name().length());
        }

        for (int i = 0; i < workloads.length; i++) {
            long start = System.currentTimeMillis();
            workloads[i].workload();
            long end = System.currentTimeMillis();

            System.out.println(String.format("[ %-" + maxLength + "s ] %f s", workloads[i].name(), (end - start) / 1000.0f));
        }
    }

    public interface Workload {
        public String name();

        public void workload();
    }
}
