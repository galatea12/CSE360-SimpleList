/*
* Gala Gutierrez
* CSE 360
* ASU ID: 1215347874
* Class: 152
*
* Description: this is a SimpleList class that provides tools to create objects
* of type SimpleList, which will be able to hold 10 integer elements at a time,
* as well as integer count which holds the current amount of elements inserted inside
* the object.
* Functionality regarding adding, removing, and searching elements is also integrated.
* Lastly, retrieval methods for the count value and a list of all the elements inside
* the array are created.
*/
package assign1;

public class SimpleList {
    private int[] list;
    private int count;

    /*
    * Class constructor. It creates a new object or instance of SimpleList.
    * Variable list will be initialized to size 10.
    * Count variable will be initialized to 0. No parameters needed, no return
    * values given, as per standards of constructor classes. An object of SimpleList
    * will be created.
    */
    public SimpleList(){
        list = new int[10];
        count = 0;
    }

    /*
    * Add method. Parameter of type int contianing the element to be added needed.
    * Return value of type void. There will be 2 instances that will determine how
    * add method will proceed. If count is less than 10, this indicates that
    * the current array is not full, meaning that it can proceed to shift all
    * elements that are currently inside the array to the right by one, and finally,
    * add the given new element int the array. Count would be increased.
    * In the second case, the array would be full. The program will proceed to shift
    * to the right by one element as before, but count won't be increased. The first
    * element that was ever inputted in our program will "fall off", or overwritten
    * by the second element, in the process of shifting. The element to be added
    * will be added to the first position as before.
    */
    public void add(int newElement) {
        if (count < 10) {
            for (int index = list.length - 1; index > 0; index--) {
                list[index] = list[index - 1]; //copy value inside index - 1 into index to shift
            }
            list[0] = newElement;
            count++;
        }
        else{
            for (int index = list.length - 1; index > 0; index--) {
                list[index] = list[index - 1];
            }
            list[0] = newElement;
        }
    }

    /*
    * Remove method. Parameter of type int of element to be removed needed.
    * Return of type void. It will validate whether the number asked to be removed
    * from the array is inside the array in question. This array is located inside
    * the SimpleList object. If the number is NOT inside the SimpleList object,
    * the method will not do anything. Otherwise, the element to be removed will be
    * overwritten in the process of shifting to the left that will take in place,
    * from the index position of the value to be removed up to count. Count will be
    * decreased by one.
    */
    public void remove(int toDelete){
        int position = -1;
        for(int index = 0; index < count; index++){
            if(list[index] == toDelete)
                position = index;
        }
        if(position > 0) {
            for (int index = position; index < count; index++) {
                list[index] = list[index + 1];
            }
            count--;
        }
    }
    /*
    * Count method. No parameters needed, return of type int.
    * It will return the current value stored inside the count variable.
    */
    public int count(){
        return count;
    }

    /*
    * toString method. No parameters needed, return of type String containing the resulting String.
    * It will overwrite the String class's toString method, to accommodate to the structure
    * of the object SimpleList. It will create a variable of String that will hold the final
    * String returned when calling the method. It will concatenate each of the values inside of the
    * array, separated by a whitespace. The last element will be concatenated at the end to avoid
    * an extra whitespace at the end of the String. It will finally return this String.
    */
    public String toString(){
        String result = "";
        for(int index = 0; index < count - 1; index++)
            result += list[index] + " ";
        if(count > 0)
            result += String.valueOf(list[count - 1]);
        return result;
    }

    /*
    * Search method. Parameter of type integer holding the value to be searched needed.
    * Return type of integer holding the position of the value was searched. If the value
    * was not part of the Object SimpleList, it will return -1.
    */
    public int search(int searchedNum){
        int indexNum = -1;
        for(int index = 0; index < count; index++){
            if(list[index] == searchedNum)
                indexNum = index;
        }
        return indexNum;
    }
}
