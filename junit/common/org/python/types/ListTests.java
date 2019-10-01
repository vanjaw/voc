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
    }
}