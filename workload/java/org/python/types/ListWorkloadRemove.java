package org.python.types;

import org.python.types.List;

public class ListWorkloadRemove {
    public static void workload() {
      org.python.types.List x = new org.python.types.List(
                new java.util.ArrayList()
            );
      for(int i=1;i<=500000;i++){
          x.append(org.python.types.Int.getInt(1));
      };
      try{
        x.remove(org.python.types.Int.getInt(2));
      }
      catch(org.python.exceptions.ValueError e){
        ;

      }
      //long starttime = System.nanoTime();
      for(int i=1;i<=500000;i++){
          x.remove(org.python.types.Int.getInt(1));
      };

      //long endtime = System.nanoTime();
      //System.out.println(endtime-starttime);
    }
}
