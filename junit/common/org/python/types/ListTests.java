package org.python.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class ListTests {
    //////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////

    @Test
    @DisplayName("List sort")
    void test_sort() {
      org.python.types.List x = new org.python.types.List(
          new java.util.ArrayList(java.util.Arrays.asList(
              org.python.types.Int.getInt(9),
              org.python.types.Int.getInt(9),
              org.python.types.Int.getInt(1),
              org.python.types.Int.getInt(9)
          ))
      );

      x.sort(null,null);
      assertEquals(x.__str__().toString(), "[1, 9, 9, 9]");


      org.python.types.List x2 = new org.python.types.List(
          new java.util.ArrayList(java.util.Arrays.asList(
              new org.python.types.Str("aa"),
              new org.python.types.Str("tt"),
              new org.python.types.Str("bb")
          ))
      );

      org.python.types.List y = new org.python.types.List(
          new java.util.ArrayList(java.util.Arrays.asList(
              new org.python.types.Str("aa"),
              new org.python.types.Str("bb"),
              new org.python.types.Str("tt")
          ))
      );

      x2.sort(null,null);
      assertEquals(x2, y);


      }

      //////////////////////////////////////////////////////////////////////////////////
      //////////////////////////////////////////////////////////////////////////////////

      @Test
      @DisplayName("List pop")
      void test_pop(){
        org.python.types.List x = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(2),
                org.python.types.Int.getInt(3),
                org.python.types.Int.getInt(4),
                org.python.types.Int.getInt(5)
            ))
        );

        x.pop(null);
        assertEquals(x.__str__().toString(), "[1, 2, 3, 4]");

        org.python.types.List x2 = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(2),
                org.python.types.Int.getInt(3),
                org.python.types.Int.getInt(4)
            ))
        );

        x2.pop(org.python.types.Int.getInt(0));
        assertEquals(x2.__str__().toString(), "[2, 3, 4]");

        x2.pop(org.python.types.Int.getInt(0));
        assertEquals(x2.__str__().toString(), "[3, 4]");



        org.python.types.List x3 = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
                org.python.types.Int.getInt(1),
                org.python.types.Int.getInt(2),
                org.python.types.Int.getInt(3)
            ))
        );

        assertEquals(x3.pop(org.python.types.Int.getInt(-2)).__str__().toString(), "2");


      }

      //////////////////////////////////////////////////////////////////////////////////
      //////////////////////////////////////////////////////////////////////////////////

      @Test
      @DisplayName("List pop exceptions")
      void test_pop_exceptions(){
        org.python.types.List x = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
            ))
        );

        try{
          org.python.Object y = x.pop(null);
          fail();
        }
        catch(org.python.exceptions.IndexError e){
          assertEquals(e.__str__().toString(), "pop from empty list");
        }


        org.python.types.List x2 = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
            org.python.types.Int.getInt(1),
            org.python.types.Int.getInt(2),
            org.python.types.Int.getInt(3)
            ))
        );

        try{
          org.python.Object y = x2.pop(org.python.types.Int.getInt(3));
          fail();
        }
        catch(org.python.exceptions.IndexError e){
          assertEquals(e.__str__().toString(), "pop index out of range");
        }


        org.python.types.List x3 = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
            org.python.types.Int.getInt(1),
            org.python.types.Int.getInt(2),
            org.python.types.Int.getInt(3)
            ))
        );

        try{
          org.python.Object y = x3.pop(org.python.types.Int.getInt(-4));
          fail();
        }
        catch(org.python.exceptions.IndexError e){
          assertEquals(e.__str__().toString(), "pop index out of range");
        }

      }


    //////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////

    @Test
    @DisplayName("List copy")
    void test_copy() {
      org.python.types.List x = new org.python.types.List(
          new java.util.ArrayList(java.util.Arrays.asList(
          org.python.types.Int.getInt(1),
          org.python.types.Int.getInt(2),
          org.python.types.Int.getInt(3)
          ))
      );

      org.python.Object y = x.copy();
      assertEquals(x, y);


      org.python.types.List x2 = new org.python.types.List(
          new java.util.ArrayList(java.util.Arrays.asList(
          org.python.types.Int.getInt(1),
          org.python.types.Int.getInt(2),
          org.python.types.Int.getInt(3)
          ))
      );

      org.python.Object y2 = x2.copy();
      assertEquals(y2.__str__().toString(), "[1, 2, 3]");

      }




      //////////////////////////////////////////////////////////////////////////////////
      //////////////////////////////////////////////////////////////////////////////////

      @Test
      @DisplayName("List index")
      void test_index() {
        org.python.types.List x = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
            org.python.types.Int.getInt(1),
            org.python.types.Int.getInt(2),
            org.python.types.Int.getInt(3)
            ))
        );

        org.python.Object y = x.index(org.python.types.Int.getInt(2),null,null);
        assertEquals(y.__str__().toString(), "1");


        org.python.types.List x2 = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
            org.python.types.Int.getInt(1),
            org.python.types.Int.getInt(2),
            org.python.types.Int.getInt(1),
            org.python.types.Int.getInt(1),
            org.python.types.Int.getInt(5),
            org.python.types.Int.getInt(1)
            ))
        );

        org.python.Object y2 = x2.index(org.python.types.Int.getInt(1),org.python.types.Int.getInt(1),null);
        assertEquals(y2.__str__().toString(), "2");



        org.python.types.List x3 = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
            org.python.types.Int.getInt(1),
            org.python.types.Int.getInt(2),
            org.python.types.Int.getInt(6),
            org.python.types.Int.getInt(1),
            org.python.types.Int.getInt(6),
            org.python.types.Int.getInt(1)
            ))
        );

        org.python.Object y3 = x3.index(org.python.types.Int.getInt(6),org.python.types.Int.getInt(3),org.python.types.Int.getInt(5));
        assertEquals(y3.__str__().toString(), "4");




        org.python.types.List x4 = new org.python.types.List(
            new java.util.ArrayList(java.util.Arrays.asList(
            org.python.types.Int.getInt(1),
            org.python.types.Int.getInt(1),
            org.python.types.Int.getInt(3)
            ))
        );

        try{
            org.python.Object y4 = x4.index(org.python.types.Int.getInt(2),null,null);
            fail();
          }
          catch(org.python.exceptions.ValueError e){
            assertEquals(e.__str__().toString(), "2 is not in list");
          }


        org.python.types.List x5 = new org.python.types.List(
              new java.util.ArrayList(java.util.Arrays.asList(
              org.python.types.Int.getInt(1),
              org.python.types.Int.getInt(1),
              org.python.types.Int.getInt(3)
              ))
          );

        try{
            org.python.Object y5 = x5.index(org.python.types.Int.getInt(69),org.python.types.Int.getInt(0),org.python.types.Int.getInt(2));
            fail();
          }
          catch(org.python.exceptions.ValueError e){
            assertEquals(e.__str__().toString(), "69 is not in list");
          }

    }

      //////////////////////////////////////////////////////////////////////////////////
      //////////////////////////////////////////////////////////////////////////////////
}
