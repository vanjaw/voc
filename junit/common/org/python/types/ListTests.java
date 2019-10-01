package org.python.types;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.Python;
import org.junit.jupiter.api.Test;
import org.python.Object;
import org.junit.jupiter.api.DisplayName;



class ListTests {
    @Test
    @DisplayName("TEST")
    void testTest() {
        assertEquals(1, 1);
    }

    @Test
    @DisplayName("Extend List")
    void testExtendList() {
        java.util.ArrayList<org.python.Object> testList = new java.util.ArrayList<org.python.Object>();
        testList.add(Int.getInt(1));
        testList.add(Int.getInt(2));
        testList.add(Int.getInt(3));

        // Create [1,2,3]
        org.python.types.List pythonList = new org.python.types.List(testList);
        // Extend to [1,2,3,1,2,3]
        pythonList.extend(pythonList);

        testList.add(Int.getInt(1));
        testList.add(Int.getInt(2));
        testList.add(Int.getInt(3));

        // Create list [1,2,3,1,2,3]
        org.python.types.List pythonList2 = new org.python.types.List(testList);

        assertEquals(pythonList2.__str__(), pythonList.__str__());
    }

}