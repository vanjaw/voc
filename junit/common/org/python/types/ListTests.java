package org.python.types;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class ListTests {
    @Test
    @DisplayName("TEST")
    void testInsert() {
        org.python.types.List x = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(2),
                org.python.types.Int.getInt(3)
            ))
        );
        x.insert(
            org.python.types.Int.getInt(0),
            org.python.types.Int.getInt(4)
        );
        assertEquals(x.__str__().toString(), "[4, 1, 2, 3]");

        x.insert(
            org.python.types.Int.getInt(1),
            org.python.types.Int.getInt(5)
        );

        assertEquals(x.__str__().toString(), "[4, 5, 1, 2, 3]");

        x.insert(
            x.__len__(),
            org.python.types.Int.getInt(6)
        );

        assertEquals(x.__str__().toString(), "[4, 5, 1, 2, 3, 6]");

        x.insert(
            org.python.types.Int.getInt(200),
            org.python.types.Int.getInt(7)
        );

        assertEquals(x.__str__().toString(), "[4, 5, 1, 2, 3, 6, 7]");
	
        x.insert(
            org.python.types.Int.getInt(-1),
            org.python.types.Int.getInt(8)
        );

        assertEquals(x.__str__().toString(), "[4, 5, 1, 2, 3, 6, 8, 7]");

        x.insert(
            x.__len__().__invert__(),
            org.python.types.Int.getInt(9)
        );

        assertEquals(x.__str__().toString(), "[9, 4, 5, 1, 2, 3, 6, 8, 7]");

        x.insert(
            org.python.types.Int.getInt(-200),
            org.python.types.Int.getInt(10)
        );

        assertEquals(x.__str__().toString(), "[10, 9, 4, 5, 1, 2, 3, 6, 8, 7]");
    }

    @Test
    @DisplayName("List insert string")
    void testInsert2()
    {
        org.python.types.List x = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(2),
                org.python.types.Int.getInt(3)
            ))
        );
        x.insert(
            org.python.types.Int.getInt(0),
            new org.python.types.Str("hello")
        );
        assertEquals(x.__str__().toString(), "['hello', 1, 2, 3]");
    }
}
