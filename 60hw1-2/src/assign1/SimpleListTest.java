/*
* Gala Gutierrez
* CSE 360
* ASU ID: 1215347874
* Class: 152
* Description: SimpleListTest java class. This will make use of JUNIT4 libraries
* to properly test the class created in SimpleList.java.
*/
package assign1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleListTest {

    /*
    * TestSimpleList tests for the correct creation of an
    * instance of an object of type SimpleList. If successful,
    * variable aList will not hold NULL. assertNoNull is used.
    */
    @Test
    public void TestSimpleList(){
        SimpleList aList = new SimpleList();
        assertNotNull(aList);
    }

    /*
    * Basic test for add method. It will make use of the count method to
    * check whether an object was properly added to the Object. Method toString
    * will also be used to check the right element was added inside the SimpleList.
    */
    @Test
    public void Testadd() {
        SimpleList testList = new SimpleList();
        testList.add(1);
        int actualCount = testList.count();
        int actualSearch = testList.search(1);
        String expectedOutput = "The count is: 1";
        expectedOutput += "\nThe search index is: 0";
        String actualOutput = "The count is: " + actualCount;
        actualOutput += "\nThe search index is: " + actualSearch;


        assertEquals(expectedOutput, actualOutput);
    }

    /*
    * Test for add method. This will check for proper handling of addition of
    * a new element when the current SimpleList object is full. It should be able to
    * find the newly added element at position 0, while the first element that was
    * added to the SimpleList object should not be found, yielding to an index of -1.
    * It also makes use of the toString method to check whether the last element added
    * was placed inside the correct position inside the SimpleList.
    */
    @Test
    public void TestaddOverflow() {
        SimpleList testList = new SimpleList();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);
        testList.add(7);
        testList.add(8);
        testList.add(9);
        testList.add(10);
        testList.add(11);

        int expectedOverridden = -1;
        int actualOverridden = testList.search(1);

        int expectedAdded = 0;
        int actualAdded = testList.search(11);

        //checking element was overridden
        String expectedOutput = "Position of overridden element: " + expectedOverridden;
        //checking that a new element was inserted
        expectedOutput += "\nPosition of last element added: " + expectedAdded;
        //checking the new element's position
        expectedOutput += "\nResult of toString method: 11 10 9 8 7 6 5 4 3 2";

        String actualOutput = "Position of overridden element: " + actualOverridden;
        actualOutput += "\nPosition of last element added: " + actualAdded;
        actualOutput += "\nResult of toString method: " + testList.toString();

        assertEquals(expectedOutput, actualOutput);
    }

    /*
    * Basic remove case. Checks if an element is properly removed. In this case, the first element.
    */
    @Test
    public void Testremove() {
        SimpleList testList = new SimpleList();
        testList.add(1);
        testList.add(2);

        testList.remove(1);
        int expectedOutput = -1;
        int actualOutput = testList.search(1);

        assertEquals(expectedOutput, actualOutput);
    }

    /*
    * Complex remove case. Checks if in case the element is not part of the
    * SimpleList, it won't affect it.
    */
    @Test
    public void TestNotFoundremove() {
        SimpleList testList = new SimpleList();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);

        testList.remove(7);
        int expectedOutput = 6;
        int actualOutput = testList.count();

        assertEquals(expectedOutput, actualOutput);
    }

    /*
    * Basic count test. It adds 6 elements and checks that count is working properly (counting
    * each of the six elements and displaying expected output)
    */
    @Test
    public void Testcount() {
        SimpleList testList = new SimpleList();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);

        int expectedOutput = 6;
        int actualOutput = testList.count();

        assertEquals(expectedOutput, actualOutput);
    }

    /*
    * Basic test of the toString method. Checking that values are being inputted in
    * reverse order (since each element is added to the beginning). Also checks that all
    * elements that have been inputted are also displayed.
    */
    @Test
    public void TesttoString() {
        SimpleList testList = new SimpleList();
        testList.add(1);
        testList.add(2);
        String actualOutput = testList.toString();
        String expectedOutput = "2 1";

        assertEquals(expectedOutput, actualOutput);
    }

    /*
    * Complex toString test case. It checks that an element is properly
    * added into the SimpleList when the list is full. It also checks that no extra
    * whitespaces are added during printing.
    */
    @org.junit.Test
    public void TestComplextoString() {
        SimpleList testList = new SimpleList();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);
        testList.add(7);
        testList.add(8);
        testList.add(9);
        testList.add(10);
        testList.add(11);
        String actualOutput = testList.toString();
        String expectedOutput = "11 10 9 8 7 6 5 4 3 2";
        assertEquals(expectedOutput, actualOutput);
    }
    /*
    * Basic search test case. It checks that the proper index of the element searched is
    * being returned.
    */
    @org.junit.Test
    public void Testsearch() {
        SimpleList testList = new SimpleList();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);

        int expectedOutput = 2;
        int actualOutput = testList.search(3);

        assertEquals(expectedOutput, actualOutput);
    }
}