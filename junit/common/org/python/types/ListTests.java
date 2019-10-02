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
    @DisplayName("List slice")
    void testSlice() {
        org.python.types.List x = new org.python.types.List(
        new java.util.ArrayList(java.util.Arrays.asList(
            org.python.types.Int.getInt(1),
            org.python.types.Int.getInt(2),
            org.python.types.Int.getInt(3),
            org.python.types.Int.getInt(4),
            org.python.types.Int.getInt(5)
        ))
        );
        // Full slice
        org.python.Object s1 = new Slice(null);
        org.python.Object s1List = x.__getitem__(s1);
        assertEquals(s1List.__str__().toString(), "[1, 2, 3, 4, 5]");

        // Left bound slice
        org.python.Object s2 = new Slice(Int.getInt(1), Int.getInt(5));
        org.python.Object s2List = x.__getitem__(s2);
        assertEquals(s2List.__str__().toString(), "[2, 3, 4, 5]");

        // Right bound slice
        org.python.Object s3 = new Slice(Int.getInt(0), Int.getInt(4));
        org.python.Object s3List = x.__getitem__(s3);
        assertEquals(s3List.__str__().toString(), "[1, 2, 3, 4]");

        // Slice bound in both directions
        org.python.Object s4 = new Slice(Int.getInt(1), Int.getInt(4));
        org.python.Object s4List = x.__getitem__(s4);
        assertEquals(s4List.__str__().toString(), "[2, 3, 4]");

        // Slice bound in both directions with end out of bounds
        org.python.Object s5 = new Slice(Int.getInt(1), Int.getInt(6));
        org.python.Object s5List = x.__getitem__(s5);
        assertEquals(s5List.__str__().toString(), "[2, 3, 4, 5]");

        // Slice bound in both directions with start out of bounds
        org.python.Object s6 = new Slice(Int.getInt(6), Int.getInt(7));
        org.python.Object s6List = x.__getitem__(s6);
        assertEquals(s6List.__str__().toString(), "[]");
    }

    @Test
    @DisplayName("List slice with zero steps")
    void testSliceZeroSteps()
    {
        org.python.types.List x = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(2),
                org.python.types.Int.getInt(3),
                org.python.types.Int.getInt(4),
                org.python.types.Int.getInt(5)
            ))
        );
        // When step is 0
        org.python.Object s1 = new Slice(Int.getInt(1), Int.getInt(3), Int.getInt(0));
        try {
            org.python.Object s1List = x.__getitem__(s1);
            fail();
        } catch(org.python.exceptions.ValueError e) {
            assertEquals(e.__str__().toString(), "slice step cannot be zero");
        }
    }

    @Test
    @DisplayName("List slice in reverse")
    void testSliceInReverse()
    {
        org.python.types.List x = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(2),
                org.python.types.Int.getInt(3),
                org.python.types.Int.getInt(4),
                org.python.types.Int.getInt(5)
            ))
        );
        // Left bound slice with a negative step
        org.python.Object s2 = new Slice(Int.getInt(4), Int.getInt(0), Int.getInt(-1));
        org.python.Object s2List = x.__getitem__(s2);
        assertEquals(s2List.__str__().toString(), "[5, 4, 3, 2]");

        // Right bound slice with a negative step
        org.python.Object s3 = new Slice(Int.getInt(3), Int.getInt(1), Int.getInt(-2));
        org.python.Object s3List = x.__getitem__(s3);
        assertEquals(s3List.__str__().toString(), "[4]");

        // Right bound and left bound slice with a negative step
        org.python.Object s4 = new Slice(Int.getInt(4), Int.getInt(1), Int.getInt(-1));
        org.python.Object s4List = x.__getitem__(s4);
        assertEquals(s4List.__str__().toString(), "[5, 4, 3]");
    }

    @Test
    @DisplayName("List count")
    void testCount()
    {
        // Normal count
        org.python.types.List x = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(4),
                org.python.types.Int.getInt(5)
            ))
        );
        assertEquals(x.count(Int.getInt(1)).toString(), "3");

        // Bool count
        org.python.types.List x2 = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(1),
                org.python.types.Bool.getBool(true),
                org.python.types.Bool.getBool(false),
                org.python.types.Int.getInt(2),
                org.python.types.Bool.getBool(true)
            ))
        );
        assertEquals(x2.count(Int.getInt(1)).toString(), "4");

        // Element doesn't exist count
        assertEquals(x2.count(Int.getInt(3)).toString(), "0");
    }

    @Test
    @DisplayName("List contains")
    void testContains()
    {
        org.python.types.List x = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(2),
                org.python.types.Int.getInt(3),
                org.python.types.Int.getInt(4),
                org.python.types.Int.getInt(5)
            ))
        );
        // Normal contains
        assertEquals(x.__contains__(Int.getInt(1)).toString(), "True");

        // Element doesn't exist
        assertEquals(x.__contains__(Int.getInt(0)).toString(), "False");

        // Checking for booleans
        org.python.types.List x2 = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Bool.getBool(true),
                org.python.types.Bool.getBool(false)
            ))
        );
        assertEquals(x2.__contains__(Int.getInt(0)).toString(), "True");
        assertEquals(x2.__contains__(Int.getInt(1)).toString(), "True");
    }


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

    @Test
    @DisplayName("List insert")
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
    void testInsert2() {
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
    @DisplayName("List insert list")
    void testInsert3() {
        org.python.types.List x = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(2),
                org.python.types.Int.getInt(3)
            ))
        );

        x.insert(
            org.python.types.Int.getInt(0),
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    org.python.types.Int.getInt(1),
                    org.python.types.Int.getInt(2)
                ))
            )
        );

        assertEquals(x.__str__().toString(), "[[1, 2], 1, 2, 3]");
    }

    @Test
    @DisplayName("List insert TypeError")
    void testInsert4() {
        org.python.types.List x = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(2),
                org.python.types.Int.getInt(3)
            ))
        );

        try {
            x.insert(
                new org.python.types.Str("a"),
                org.python.types.Int.getInt(4)
            );
            fail();
        } catch (org.python.exceptions.TypeError e) {
            assertEquals(e.__str__().toString(), "'str' object cannot be interpreted as an integer");
        }

        x = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(2),
                org.python.types.Int.getInt(3)
            ))
        );

        try {
            x.insert(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        org.python.types.Int.getInt(1),
                        org.python.types.Int.getInt(2),
                        org.python.types.Int.getInt(3)
                    ))
                ),
                org.python.types.Int.getInt(4)
            );
            fail();
        } catch (org.python.exceptions.TypeError e) {
            assertEquals(e.__str__().toString(), "'list' object cannot be interpreted as an integer");
        }
    }

    @Test
    @DisplayName("List lt reflected")
    void testLtReflected() {
        org.python.types.Object x = new org.python.types.Object() {
            public org.python.Object __gt__(org.python.Object other) {
                return org.python.types.Bool.getBool(true);
            }
        };

        org.python.types.Object y = new org.python.types.Object() {
            public org.python.Object __gt__(org.python.Object other) {
                return org.python.types.Bool.getBool(true);
            }
        };

        assertEquals(x.__lt__(x).__str__().toString(), "NotImplemented");

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x
                ))
            ).__lt__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        x
                    ))
                )
            ).__str__().toString(),
            "False"
        );

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x
                ))
            ).__lt__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        y
                    ))
                )
            ).__str__().toString(),
            "True"
        );

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x, y
                ))
            ).__lt__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        y
                    ))
                )
            ).__str__().toString(),
            "True"
        );

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x, y
                ))
            ).__lt__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        x
                    ))
                )
            ).__str__().toString(),
            "False"
        );

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x
                ))
            ).__lt__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        x, y
                    ))
                )
            ).__str__().toString(),
            "True"
        );
    }

    @Test
    @DisplayName("List le reflected")
    void testLeReflected() {
        org.python.types.Object x = new org.python.types.Object() {
            public org.python.Object __ge__(org.python.Object other) {
                return org.python.types.Bool.getBool(true);
            }
        };

        org.python.types.Object y = new org.python.types.Object() {
            public org.python.Object __ge__(org.python.Object other) {
                return org.python.types.Bool.getBool(true);
            }
        };

        assertEquals(x.__le__(x).__str__().toString(), "NotImplemented");

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x
                ))
            ).__le__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        x
                    ))
                )
            ).__str__().toString(),
            "True"
        );

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x
                ))
            ).__le__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        y
                    ))
                )
            ).__str__().toString(),
            "True"
        );

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x, y
                ))
            ).__le__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        y
                    ))
                )
            ).__str__().toString(),
            "True"
        );

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x, y
                ))
            ).__le__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        x
                    ))
                )
            ).__str__().toString(),
            "False"
        );

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x
                ))
            ).__le__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        x, y
                    ))
                )
            ).__str__().toString(),
            "True"
        );
    }

    @Test
    @DisplayName("List gt reflected")
    void testGtReflected() {
        org.python.types.Object x = new org.python.types.Object() {
            public org.python.Object __lt__(org.python.Object other) {
                return org.python.types.Bool.getBool(true);
            }
        };

        org.python.types.Object y = new org.python.types.Object() {
            public org.python.Object __lt__(org.python.Object other) {
                return org.python.types.Bool.getBool(true);
            }
        };

        assertEquals(x.__gt__(x).__str__().toString(), "NotImplemented");

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x
                ))
            ).__gt__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        x
                    ))
                )
            ).__str__().toString(),
            "False"
        );

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x
                ))
            ).__gt__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        y
                    ))
                )
            ).__str__().toString(),
            "True"
        );

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x, y
                ))
            ).__gt__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        y
                    ))
                )
            ).__str__().toString(),
            "True"
        );

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x, y
                ))
            ).__gt__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        x
                    ))
                )
            ).__str__().toString(),
            "True"
        );

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x
                ))
            ).__gt__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        x, y
                    ))
                )
            ).__str__().toString(),
            "False"
        );
    }

    @Test
    @DisplayName("List ge reflected")
    void testGeReflected() {
        org.python.types.Object x = new org.python.types.Object() {
            public org.python.Object __le__(org.python.Object other) {
                return org.python.types.Bool.getBool(true);
            }
        };

        org.python.types.Object y = new org.python.types.Object() {
            public org.python.Object __le__(org.python.Object other) {
                return org.python.types.Bool.getBool(true);
            }
        };

        assertEquals(x.__ge__(x).__str__().toString(), "NotImplemented");

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x
                ))
            ).__ge__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        x
                    ))
                )
            ).__str__().toString(),
            "True"
        );

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x
                ))
            ).__ge__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        y
                    ))
                )
            ).__str__().toString(),
            "True"
        );

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x, y
                ))
            ).__ge__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        y
                    ))
                )
            ).__str__().toString(),
            "True"
        );

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x, y
                ))
            ).__ge__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        x
                    ))
                )
            ).__str__().toString(),
            "True"
        );

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x
                ))
            ).__ge__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        x, y
                    ))
                )
            ).__str__().toString(),
            "False"
        );
    }

    @Test
    @DisplayName("List eq reflected")
    void testEqReflected() {
        org.python.types.Object x = new org.python.types.Object() {
            public org.python.Object __eq__(org.python.Object other) {
                return org.python.types.Bool.getBool(true);
            }
        };

        org.python.types.Object y = new org.python.types.Object() {
            public org.python.Object __eq__(org.python.Object other) {
                return org.python.types.Bool.getBool(false);
            }
        };

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x
                ))
            ).__eq__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        x
                    ))
                )
            ).__str__().toString(),
            "True"
        );

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x, x
                ))
            ).__eq__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        x
                    ))
                )
            ).__str__().toString(),
            "False"
        );

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    x
                ))
            ).__eq__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        y
                    ))
                )
            ).__str__().toString(),
            "True"
        );

        assertEquals(
            new org.python.types.List(
                new java.util.ArrayList(java.util.Arrays.asList(
                    y
                ))
            ).__eq__(
                new org.python.types.List(
                    new java.util.ArrayList(java.util.Arrays.asList(
                        x
                    ))
                )
            ).__str__().toString(),
            "False"
        );
    }

    @Test
    @DisplayName("List reversed")
    void testReversed() {
        org.python.types.List list = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(123),
                new org.python.types.Str("xyz"),
                new org.python.types.Str("abc")
            ))
        );

        org.python.types.List reversedList = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                new org.python.types.Str("abc"),
                new org.python.types.Str("xyz"),
                org.python.types.Int.getInt(123)
            ))
        );

        org.python.types.List l = new org.python.types.List(
            new java.util.ArrayList()
        );

        org.python.Object reverse = list.__reversed__();

        try {
            while (true) {
                l.append(org.Python.next(
                    reverse,
                    null
                ));
            }
        } catch (org.python.exceptions.StopIteration e) {
            assertEquals(
                l.__eq__(reversedList).__str__().toString(),
                "True"
            );
        }

        org.python.types.List origList = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(123),
                new org.python.types.Str("xyz"),
                new org.python.types.Str("abc")
            ))
        );

        assertEquals(
            list.__eq__(origList).__str__().toString(),
            "True"
        );
    }

    @Test
    @DisplayName("List too many arguments")
    void testTooManyArguments() {
        try {
            new org.python.types.List(
                new org.python.Object[] {
                    org.python.types.Int.getInt(1),
                    org.python.types.Int.getInt(2),
                    org.python.types.Int.getInt(3)
                },
                new java.util.HashMap()
            );
            fail();
        } catch (org.python.exceptions.TypeError err) {
            assertEquals(
                err.__str__().toString(),
                "list() takes at most 1 argument (3 given)"
            );
        }
    }
}
