package org.python.types;

import org.python.types.List;

public class ListWorkloadRemove implements ListWorkload.Workload {
    public String name() {
        return "remove";
    }

    public void workload() {
      org.python.types.List x = new org.python.types.List(
                new java.util.LinkedList()
            );

      // Add ints to list
      for(int i=1;i<=50000;i++){
          x.append(org.python.types.Int.getInt(i));
      };

      // Remove all ints in list one by one in order
      for(int i=1;i<=50000;i++){
          x.remove(org.python.types.Int.getInt(i));
      };

      // Add ints to list
      for(int i=1;i<=50000;i++){
          x.append(org.python.types.Int.getInt(i));
      };

      // Remove all ints in list one by one in reverse-order
      for(int i=1;i<=50000;i++){
          x.append(org.python.types.Int.getInt(50001-i));
      };
    }
}
