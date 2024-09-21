import static org.junit.Assert.*;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.*;

public class MyListIteratorCustomTester {
    private MyLinkedList listOne, listTwo;
    private MyLinkedList.MyListIterator listOneItr, listTwoItr;
    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test.
     */
    @Before
    public void setUp() throws Exception {
        listTwo = new MyLinkedList<>();
        listTwo.add(1);
        listTwo.add(2);
        listTwo.add(3);
        listTwoItr = listTwo.new MyListIterator();
    }

    /**
     * Aims to test the next() method when iterator is at end of the list 
     */
    @Test
    public void testNextEnd() {

        //set index equal to size
       listTwoItr.next();
       listTwoItr.next();
       listTwoItr.next();
       //check if right exception is thrown
        assertThrows(NoSuchElementException.class,
		() -> {
			 listTwoItr.next(); 
		}); 
        }

    /**
     * Aims to test the previous() method when iterator is at the start of the 
     * list 
     */
    @Test
    public void testPreviousStart() {
        
        //set index equal to 0
        listTwoItr.idx = 0;

        //check if right exception is thrown
        assertThrows(NoSuchElementException.class,
		() -> {
			 listTwoItr.previous(); 
		}); 
        
    }

    /**
     * Aims to test the add(E e) method when an invalid element is added
     */
    @Test
    public void testAddInvalid() {

        //Invalid element null is added
        assertThrows(NullPointerException.class,
		() -> {
			 listTwoItr.add(null); 
		}); 
        

    }

    /**
     * Aims to test the set(E e) method when canRemoveOrSet is false
     */
    @Test
    public void testCantSet() {
        //set canRemoveOrSet equal to false
        listTwoItr.canRemoveOrSet = false;

         //check if right exception is thrown
        assertThrows(IllegalStateException.class,
		() -> {
			 listTwoItr.set(2); 
		}); 
        
        
    }

    /**
     * Aims to test the remove() method when canRemoveOrSet is false
     */
    @Test
    public void testCantRemove() {

        //set canRemoveOrSet equal to false
        listTwoItr.canRemoveOrSet = false;

         //check if right exception is thrown
        assertThrows(IllegalStateException.class,
		() -> {
			 listTwoItr.remove(); 
		}); 
    }

    /**
     * Aims to tests the hasNext() method at the end of a list
     */
    @Test
    public void testHasNextEnd() {

        //Set index equal to size
        listTwoItr.idx = listTwo.size;
        
        //Should return false 
        assertEquals("If idx is size then it should return false",
        false, listTwoItr.hasNext());

    }

    /**
     * Aims to test the hasPrevious() method at the start of a list
     */
    @Test
    public void testHasPreviousStart() {
        //Set index equal to 0
        listTwoItr.idx = 0;

        //Should return false
        assertEquals("Should return false if idx is 0", 
        false, listTwoItr.hasPrevious());

    }

    /**
     * Aims to test the previousIndex() method at the start of a list
     */
    @Test
    public void testPreviousIndexStart() {
        //set index equal to 0
        listTwoItr.idx = 0; 

        //Should return -1
        assertEquals("Should return -1 if it is in the beginning", 
        -1, listTwoItr.previousIndex());


    }

    /**
     * Aims to test the nextIndex() method at the end of a list
     */
    @Test
    public void testNextIndexEnd() {
        //set index equal to size
        listTwoItr.idx = listTwo.size;
        
        //Should return the size of the index 
        assertEquals("Should return size if idx = size", 
        3, listTwoItr.nextIndex()); 
    }

    /**
     * Aims to test the distanceToElement() method when element is not in the list.
     */
    @Test
    public void testDistanceToElementNotInList() {

        //Should return -1
        assertEquals("Element isn't in list, should return -1",
        -1, listTwoItr.distanceToElement('A'));
    }
}
