package org.python.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class ListTests {
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
    @DisplayName("List insert list")
    void testInsert3()
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
    void testInsert4()
    {
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
    void testLtReflected()
    {
        org.python.types.Object x = new org.python.types.Object()
        {
            public org.python.Object __gt__(org.python.Object other)
            {
                return org.python.types.Bool.getBool(true);
            }
        };

        org.python.types.Object y = new org.python.types.Object()
        {
            public org.python.Object __gt__(org.python.Object other)
            {
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
    void testLeReflected()
    {
        org.python.types.Object x = new org.python.types.Object()
        {
            public org.python.Object __ge__(org.python.Object other)
            {
                return org.python.types.Bool.getBool(true);
            }
        };

        org.python.types.Object y = new org.python.types.Object()
        {
            public org.python.Object __ge__(org.python.Object other)
            {
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
    void testGtReflected()
    {
        org.python.types.Object x = new org.python.types.Object()
        {
            public org.python.Object __lt__(org.python.Object other)
            {
                return org.python.types.Bool.getBool(true);
            }
        };

        org.python.types.Object y = new org.python.types.Object()
        {
            public org.python.Object __lt__(org.python.Object other)
            {
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
    void testGeReflected()
    {
        org.python.types.Object x = new org.python.types.Object()
        {
            public org.python.Object __le__(org.python.Object other)
            {
                return org.python.types.Bool.getBool(true);
            }
        };

        org.python.types.Object y = new org.python.types.Object()
        {
            public org.python.Object __le__(org.python.Object other)
            {
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
    void testEqReflected()
    {
        org.python.types.Object x = new org.python.types.Object()
        {
            public org.python.Object __eq__(org.python.Object other)
            {
                return org.python.types.Bool.getBool(true);
            }
        };

        org.python.types.Object y = new org.python.types.Object()
        {
            public org.python.Object __eq__(org.python.Object other)
            {
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
    void testReversed()
    {
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

        try
        {
            while (true)
            {
                l.append(org.Python.next(
                    reverse,
                    null
                ));
            }
        }
        catch (org.python.exceptions.StopIteration e)
        {
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
    void testTooManyArguments()
    {
        try
        {
            new org.python.types.List(
                new org.python.Object[] {
                    org.python.types.Int.getInt(1),
                    org.python.types.Int.getInt(2),
                    org.python.types.Int.getInt(3)
                },
                new java.util.HashMap()
            );
            fail();
        }
        catch (org.python.exceptions.TypeError err)
        {
            assertEquals(
                err.__str__().toString(),
                "list() takes at most 1 argument (3 given)"
            );
        }
    }
}
