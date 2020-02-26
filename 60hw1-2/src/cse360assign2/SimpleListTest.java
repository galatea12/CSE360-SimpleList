/*
* Gala Gutierrez
* CSE 360
* ASU ID: 1215347874
* Class: 152
* Description: SimpleListTest java class. This will make use of JUNIT4 libraries
* to properly test the class created in SimpleList.java.
*/
package cse360assign2;

import org.junit.Test;


import static org.junit.Assert.*;

/*
 * @author Gala Gutierrez
 * @version 2.0
 * 
 *
 * 2.0 new version update:
 * new test cases are added to verify implementation and functionality of newly added
 * functionality.
 *
 * 
 * 1.2 update:
 * tests addOverflow and complexToString have been modified to test new functionality.
 * These test were modified since the program no longer drops the first integer to be
 * input if the input is bigger than the size of the list. Now new space should be added
 * every time max capacity is reached.
 */

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
    * 
    * 1.2 version update:
    * values are no longer "dropped" with new functionality. Instead, the array size is
    * increased, to allow to have more values input than the original instantiation in the
    * constructor. If toString is called, the first number input by the user should be 
    * displayed instead of dropped. Eleven elements should be displayed.
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

        int expectedOverridden = 10;
        int actualOverridden = testList.search(1);

        int expectedAdded = 0;
        int actualAdded = testList.search(11);

        //checking element was overridden
        String expectedOutput = "Position of overridden element: " + expectedOverridden;
        //checking that a new element was inserted
        expectedOutput += "\nPosition of last element added: " + expectedAdded;
        //checking the new element's position
        expectedOutput += "\nResult of toString method: 11 10 9 8 7 6 5 4 3 2 1";

        String actualOutput = "Position of overridden element: " + actualOverridden;
        actualOutput += "\nPosition of last element added: " + actualAdded;
        actualOutput += "\nResult of toString method: " + testList.toString();

        assertEquals(expectedOutput, actualOutput);
    }

    /*
    * Basic remove case. Checks if an element is properly removed. In this case, the 
    * first element.
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
     * Complex remove test case. It checks for the case there are duplicates
     * inside the list. The remove method should remove only the first occurrence of the
     * element to be removed. It verifies that the element still exists on the list
     * after removal (since it was a duplicate) and that the next number was 
     * successfully moved to the correct position.
     */
    
    @Test
    public void TestComplexremove() {
        SimpleList testList = new SimpleList();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(3);
        testList.add(5);
        testList.add(6);

        testList.remove(3);
        int expectDuplicate = 2;
        int actualDuplicate = testList.search(3);
        int expectNextNum = 1;
        int actualNextNum = testList.search(5);
        
        String expectedOutput = expectDuplicate + " " + expectNextNum;
        String actualOutput = actualDuplicate + " " + actualNextNum;
        

        assertEquals(expectedOutput, actualOutput);
    }
    
    /*
    * Basic count test. It adds 6 elements and checks that count is working properly 
    * (counting each of the six elements and displaying expected output)
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
    * Basic test of the toString method. Checking that values are being input in
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
    * white-spaces are added during printing.
    * 
    * 1.2 version update:
    * values are no longer "dropped" with new functionality. Instead, the array size is
    * increased, to allow to have more values input than the original instantiation in the
    * constructor. If toString is called, the first number input by the user should be 
    * displayed instead of dropped. Eleven elements should be displayed.
    */
    @Test
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
        String expectedOutput = "11 10 9 8 7 6 5 4 3 2 1";
        assertEquals(expectedOutput, actualOutput);
    }
    /*
    * Basic search test case. It checks that the proper index of the element searched is
    * being returned.
    */
    @Test
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
    
    /*
     * Complex search test case. It verifies that the search method returns
     * the first occurrence of duplicate items.
     */
    @Test
    public void TestComplexSearch() {
    	SimpleList testList = new SimpleList();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(3);
        testList.add(5);
        
        int expectedOutput = 2;
        int actualOutput = testList.search(3);
        
        assertEquals(expectedOutput, actualOutput);
    }

    
    /*
     * basic size testing. Original SimpleList object f=should be instantiated
     * to 10 elements array. This checks that size is correctly outputting size.
     */
    
    @Test
    public void TestSize() {
    	SimpleList testList = new SimpleList();
    	int originalSize = testList.size();
    	int expectedOriginalSize = 10;
    	
    	assertEquals(expectedOriginalSize, originalSize);
    }
    
    /*
     * More complex size testing. We are testing the newly added functionality
     * of the add method, which increases the size of the list by 50% if there is
     * no more space left. It should return 15 starting off a basic list.
     */
    
    @Test
    public void TestIncreasedSize() {
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
        
        int newSize = testList.size();
        int expectedNewSize = 15;
        
        assertEquals(expectedNewSize, newSize);
        
    }
    
    /*
     * More complex size testing. It tests for the newly added functionality
     * of the remove method, where if 25% of the list is not being used, it should
     * reduce the size of the list. After adding 11 numbers, the list size should
     * be 15. 75% of 15 is 11. If count less than 75% (11) it should reduce the size
     * to 75% of its current size (so from 15 to 11 due to integer division)
     */
    
    @Test
    public void TestReducedSize() {
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
        
        testList.remove(11);
        testList.remove(10);
        
        
        int newSize = testList.size();
        int expectedNewSize = 11;
        
        assertEquals(expectedNewSize, newSize);
        
    }
    
    /*
     * Basic first method test case. It returns the last value input by user using
     * add method, which adds each value to the front of the list in each call.
     */
    
    @Test
    public void TestFirst() {
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
        
        int actualFirst = testList.first();
        int expectedFirst = 11;
        
        assertEquals(expectedFirst, actualFirst);
    }
    
    /*
     * Basic last method test case. It should print the first element to be added
     * to list, since add method adds a new element to the front of the list.
     */
    
    @Test
    public void TestLast() {
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
        
        int expectedLast = 1;
        int actualLast = testList.last();
        
        assertEquals(expectedLast, actualLast);
    }
    
    /*
     * Basic test case for append. It should return the value of the 
     * only appended element during the call.
     */
    @Test
    public void TestBasicAppend() {
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
        testList.append(10);
        
        int expectedLast = 10;
        int actualLast = testList.last();
        
        assertEquals(expectedLast, actualLast);
    }
    
    /*
     * Append complex case. It should return the value of the last 
     * appended element, which was followed by 2 add calls.
     */
    @Test
    public void TestComplexAppend() {
    	SimpleList testList = new SimpleList();
    	testList.add(1);
        testList.append(2);
        testList.add(3);
        testList.append(4);
        testList.add(5);
        testList.append(6);
        testList.add(7);
        testList.append(8);
        testList.add(9);
        testList.add(10);
        
        int expectedLast = 8;
        int actualLast = testList.last();
        
        assertEquals(expectedLast, actualLast);
    }
    
    /*
     * Remove and append functionality combination test case. After removing
     * the last appended item, it should be followed by the previous appended
     * item in the list.
     */
    
    @Test
    public void TestRemoveAppend() {
    	SimpleList testList = new SimpleList();
    	testList.add(1);
        testList.append(2);
        testList.add(3);
        testList.append(4);
        testList.add(5);
        testList.append(6);
        testList.add(7);
        testList.append(8);
        testList.add(9);
        testList.add(10);
        
        testList.remove(8);
        int expectedLast = 6;
        int actualLast = testList.last();
        
        assertEquals(expectedLast, actualLast);
    }
    
    
}