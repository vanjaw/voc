package org.python.types;

import org.python.types.List;

public class ListWorkloadRemove {
    public static void workload() {
      org.python.types.List x = new org.python.types.List(
                new java.util.ArrayList()
            );

      // Add ints to list
      for(int i=1;i<=500000;i++){
          x.append(org.python.types.Int.getInt(1));
      };

      // Try to find int that doesn't exist
      try{
        x.remove(org.python.types.Int.getInt(2));
      }
      catch(org.python.exceptions.ValueError e){
        ;
      }

      // Remove all ints in list one by one
      for(int i=1;i<=500000;i++){
          x.remove(org.python.types.Int.getInt(1));
      };
    }
}
