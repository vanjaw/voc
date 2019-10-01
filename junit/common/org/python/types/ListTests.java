package org.python.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.Python;
import org.junit.jupiter.api.Test;
import org.python.Object;
import org.python.exceptions.TypeError;
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

    @Test
    @DisplayName("Extend w. List")
    void testExtendList() {
        // create [1,2,3]
        org.python.types.List testList = new List(
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3)
            ))
        );

        // create [1,2,3,1,2,3]
        org.python.types.List facitList = new List(
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3),
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3)
            ))
        );

        // Extend to [1,2,3,1,2,3]
        testList.extend(testList);

        assertEquals(facitList.__str__(), testList.__str__());
    }

    @Test
    @DisplayName("Extend w. Tuple")
    void testExtendTuple() {
        // create [1,2,3]
        org.python.types.List testList = new List(
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3)
            ))
        );

        // create [4, world, hello]
        org.python.types.Tuple testTuple = new Tuple(
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(4),
                new Str("world"),
                new Str("hello")
            ))
        );

        // create [1,2,3,4,world,hello]
        org.python.types.List facitList = new List(
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3),
                Int.getInt(4),
                new Str("world"),
                new Str("hello")
            ))
        );

        // Extend to [1,2,3,1,2,3]
        testList.extend(testTuple);

        assertEquals(facitList.__str__(), testList.__str__());
    }

    @Test
    @DisplayName("Extend w. FrozenSet")
    void testExtendFrozenSet() {
        org.python.types.List testList = new List(
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3)
            ))
        );

        org.python.types.FrozenSet testFrozenSet = new FrozenSet(
            new java.util.HashSet(java.util.Arrays.asList(
                Int.getInt(8),
                new Str("theta")
            ))
        );

        org.python.types.List facitList = new List(
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3),
                Int.getInt(8),
                new Str("theta")
            ))
        );

        testList.extend(testFrozenSet);

        assertEquals(facitList.__str__(), testList.__str__());
    }

    @Test
    @DisplayName("Extend w. Set")
    void testExtendSet() {
        org.python.types.List testList = new List(
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3)
            ))
        );

        org.python.types.Set testSet = new Set(
            new java.util.HashSet(java.util.Arrays.asList(
                new Str("alpha"),
                new Str("beta")
            ))
        );

        org.python.types.List facitList = new List(
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3),
                new Str("alpha"),
                new Str("beta")
            ))
        );

        testList.extend(testSet);

        assertEquals(facitList.__str__(), testList.__str__());
    }

    @Test
    @DisplayName("Extend w. Dict")
    void testExtendDict() {
        org.python.types.List testList = new List(
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3)
            ))
        );

        java.util.HashMap tempMap = new java.util.HashMap();
        tempMap.put(new Str("alpha"), Int.getInt(4));
        tempMap.put(new Str("theta"), Int.getInt(6));
        tempMap.put(new Str("beta"), Int.getInt(5));
        org.python.types.Dict testDict = new Dict(tempMap);

        org.python.types.List facitList = new List(
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3),
                new Str("alpha"),
                new Str("theta"),
                new Str("beta")
            ))
        );

        testList.extend(testDict);

        assertEquals(facitList.__str__(), testList.__str__());
    }

    @Test
    @DisplayName("Extend w. Iterator")
    void testExtendIterator() {
        org.python.types.List testList = new List(
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3)
            ))
        );

        org.python.types.List testList2 = new List(
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(4),
                Int.getInt(5),
                Int.getInt(6)
            ))
        );

        org.python.types.List facitList = new List(
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3),
                Int.getInt(4),
                Int.getInt(5),
                Int.getInt(6)
            ))
        );

        testList.extend(org.Python.iter(testList2));

        assertEquals(facitList.__str__(), testList.__str__());
    }

    @Test
    @DisplayName("Extend w. Bytearray")
    void testExtendByteArray() {
        org.python.types.List testList = new List(
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3)
            ))
        );

        org.python.types.ByteArray testByteArray = new ByteArray(
            new byte[] {4,5,6}
        );

        org.python.types.List facitList = new List (
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3),
                Int.getInt(4),
                Int.getInt(5),
                Int.getInt(6)
            ))
        );

        testList.extend(testByteArray);

        assertEquals(facitList.__str__(), testList.__str__());
    }

    @Test
    @DisplayName("Extend w. Byte")
    void testExtendByte() {
        org.python.types.List testList = new List(
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3)
            ))
        );

        org.python.types.Bytes testBytes = new Bytes(
            "def"
        );

        org.python.types.List facitList = new List (
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3),
                Int.getInt(100),
                Int.getInt(101),
                Int.getInt(102)
            ))
        );

        testList.extend(testBytes);

        assertEquals(facitList.__str__(), testList.__str__());
    }

    @Test
    @DisplayName("Extend w. Str")
    void testExtendStr() {
        org.python.types.List testList = new List(
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3)
            ))
        );

        org.python.types.Str testStr = new Str("def");

        org.python.types.List facitList = new List (
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3),
                new Str("d"),
                new Str("e"),
                new Str("f")
            ))
        );

        testList.extend(testStr);

        assertEquals(facitList.__str__(), testList.__str__());
    }

    @Test
    @DisplayName("Extend w. Range")
    void testExtendRange() {
        org.python.types.List testList = new List(
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3)
            ))
        );

        org.python.types.Range testRange = new Range(
            Int.getInt(5)
        );

        org.python.types.List facitList = new List (
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3),
                Int.getInt(0),
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3),
                Int.getInt(4)
            ))
        );

        testList.extend(testRange);

        assertEquals(facitList.__str__(), testList.__str__());
    }

    @Test
    @DisplayName("Extend w. Non-Iteratable")
    void testExtendNonIter() {
        org.python.types.List testList = new List(
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3)
            ))
        );

        org.python.types.Int testInt = Int.getInt(5);

        org.python.types.List facitList = new List (
            new java.util.ArrayList(java.util.Arrays.asList(
                Int.getInt(1),
                Int.getInt(2),
                Int.getInt(3)
            ))
        );

        try {
            testList.extend(testInt);
            fail();
        } catch (TypeError e) {
            assertEquals(e.__str__().toString(), "'int' object is not iterable");
            assertEquals(facitList.__str__(), testList.__str__());
        }
    }
}
