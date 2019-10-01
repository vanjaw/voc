package org.python.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class ListTests {
    // @Test
    // @DisplayName("setattr")
    // void testSetAttr() {
    //     org.python.types.List y = new org.python.types.List(
    //         new java.util.ArrayList(java.util.Arrays.asList(
    //             org.python.types.Int.getInt(1),
    //             org.python.types.Int.getInt(2),
    //             org.python.types.Int.getInt(3)
    //         ))
    //     );
    // }

    // @Test
    // @DisplayName("getattr")
    // void testGetAttr() {
    //     org.python.types.List y = new org.python.types.List(
    //         new java.util.ArrayList(java.util.Arrays.asList(
    //             org.python.types.Int.getInt(1),
    //             org.python.types.Int.getInt(2),
    //             org.python.types.Int.getInt(3)
    //         ))
    // }

    @Test
    @DisplayName("creation")
    void testCreationAttr() {
        org.python.types.List x = new org.python.types.List(
            new java.util.ArrayList()
        );
        assertEquals(x.__str__().toString(), "[]");

        org.python.types.List y = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(2),
                org.python.types.Int.getInt(3),
                org.python.types.Int.getInt(4),
                org.python.types.Int.getInt(5)
            ))
        );
        assertEquals(y.__str__().toString(), "[1, 2, 3, 4, 5]");

    }

    @Test
    @DisplayName("getItem")
    void testGetItem(){
        org.python.types.List x = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(2),
                org.python.types.Int.getInt(3),
                org.python.types.Int.getInt(4),
                org.python.types.Int.getInt(5)
            ))
        );
        org.python.Object y = x.__getitem__(org.python.types.Int.getInt(2));
        assertEquals(y.__str__().toString(), "3");

        org.python.Object y1 = x.__getitem__(org.python.types.Int.getInt(-2));
        assertEquals(y1.__str__().toString(), "4");
        
        try {
            org.python.Object y2 = x.__getitem__(org.python.types.Int.getInt(10));
            fail();
        }
        catch(org.python.exceptions.IndexError e) {
            assertEquals(e.__str__().toString(), "list index out of range");
        }

        try {
            org.python.Object y3 = x.__getitem__(org.python.types.Int.getInt(-10));
            fail();
        }
        catch(org.python.exceptions.IndexError e) {
            assertEquals(e.__str__().toString(), "list index out of range");
        }
    }
    
    @Test
    @DisplayName("setItem")
    void testSetItem() {
        org.python.types.List x = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1)
            ))
        );
        x.__setitem__(org.python.types.Int.getInt(0), org.python.types.Int.getInt(5));
        org.python.Object y = x.__getitem__(org.python.types.Int.getInt(0));
        assertEquals(y.__str__().toString(), "5");

        org.python.types.List x1 = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(2),
                org.python.types.Int.getInt(3)
            ))
        );
        x1.__setitem__(org.python.types.Int.getInt(1), new org.python.types.Str("hello"));
        x1.__setitem__(org.python.types.Int.getInt(2), new org.python.types.Str("there"));
        assertEquals(x1.__str__().toString(), "[1, 'hello', 'there']");

        org.python.types.List x2 = new org.python.types.List(
            new java.util.ArrayList()
        );
        try {
            x2.__setitem__(org.python.types.Int.getInt(0), org.python.types.Int.getInt(5));
            fail();
        }
        catch(org.python.exceptions.IndexError e){
            assertEquals(e.__str__().toString(), "list assignment index out of range");
        }

        org.python.types.List x3 = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1)
            ))
        );
        try {
            x3.__setitem__(org.python.types.Int.getInt(-2), org.python.types.Int.getInt(5));
            fail();
        }
        catch(org.python.exceptions.IndexError e){
            assertEquals(e.__str__().toString(), "list assignment index out of range");
        }
    }

    @Test
    @DisplayName("append")
    void testAppend() {
        org.python.types.List x = new org.python.types.List(
            new java.util.ArrayList()
        );
        x.append(new org.python.types.Str("hello"));
        x.append(org.python.types.Int.getInt(5));
        org.python.Object y1 = x.__getitem__(org.python.types.Int.getInt(0));
        assertEquals(y1.__str__().toString(), "hello");
        org.python.Object y2 = x.__getitem__(org.python.types.Int.getInt(1));
        assertEquals(y2.__str__().toString(), "5");

        org.python.types.List x1 = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(2),
                org.python.types.Int.getInt(3),
                org.python.types.Int.getInt(4)
            ))
        );
        x1.append(org.python.types.Int.getInt(5));
        x1.append(new org.python.types.Str("hello"));
        org.python.Object y3 = x1.__getitem__(org.python.types.Int.getInt(4));
        assertEquals(y3.__str__().toString(), "5");
        org.python.Object y4 = x1.__getitem__(org.python.types.Int.getInt(5));
        assertEquals(y4.__str__().toString(), "hello");
    }

    @Test
    @DisplayName("remove")
    void testRemove() {
        org.python.types.List x = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(2),
                org.python.types.Int.getInt(3)
            ))
        );
        x.remove(org.python.types.Int.getInt(1));
        assertEquals(x.__str__().toString(), "[2, 3]");

        org.python.types.List x1 = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(2),
                org.python.types.Int.getInt(2),
                org.python.types.Int.getInt(3),
                org.python.types.Int.getInt(2)
            ))
        );
        x1.remove(org.python.types.Int.getInt(2));
        assertEquals(x1.__str__().toString(), "[1, 2, 3, 2]");

        org.python.types.List x2 = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Bool.getBool(true),
                org.python.types.Bool.getBool(false),
                org.python.types.Bool.getBool(true),
                org.python.types.Bool.getBool(false)
            ))
        );
        x2.remove(org.python.types.Int.getInt(1));
        assertEquals(x2.__str__().toString(), "[False, True, False]");

        org.python.types.List x3 = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(2)
            ))
        );
        try {
            x3.remove(org.python.types.Int.getInt(3));
            fail();
        }
        catch(org.python.exceptions.ValueError e){
            assertEquals(e.__str__().toString(), "list.remove(x): x not in list");
        }
    }
}