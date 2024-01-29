import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MapTest {

    @Test
    public void testBasics() {
        // Modified to test size after adding elements
        Map<Integer> test = new Map<>();
        assertEquals(0, test.size()); //Test basecase
        assertEquals(-1, test.minIndex()); //Test minindex
        assertEquals(-1, test.maxIndex()); //Test maxindex
        assertNull(test.get(3));
        assertNull(test.sortedValues());
        assertNull(test.toArray()); //test all three above to see that they are null when initialized
    }

    @Test
    public void testAddAndRemove() {
        Map<Integer> test = new Map<>();

        // We add some values to positions, then add a new value to a taken position
        test.add(1, 100);
        assertEquals(1, test.size()); //check that size is one

        //add two more
        test.add(2, 200);
        test.add(3, 100);
        assertEquals(3, test.size()); // Check that size is three

        //add two more
        test.add(10, 3);
        test.add(20, 40); 
        assertEquals(5, test.size()); //Check that size is five

        assertEquals(1, test.minIndex()); //check that the lowest index is 1
        assertEquals(20, test.maxIndex()); //check that the highest index is 20

        // We add at an existing index
        test.add(2, 13);
        assertEquals(5, test.size()); // Size should not increase and should be 5 
        assertEquals(13, test.get(2).intValue()); // Value at index 2 should be updated to the new valuse 13

        // Remove some elements and check
        test.removeAt(20);
        assertEquals(4, test.size());
        assertNull(test.get(20)); // Index 20 should no longer exist and it should return null

        //remove again this time index 10
        test.removeElem(100); //This should remove the first occurrence of element 100, i.e index 1
        assertEquals(3, test.size()); //Size should now be three
        assertEquals(2, test.minIndex()); //new min should be 2
        assertEquals(10, test.maxIndex()); //new max should be 10

        // Test second add method without specified index
        test.add(1337);
        assertEquals(4, test.size());
        assertEquals(10, test.maxIndex()); //Same max as before
        assertEquals(0, test.minIndex()); //new max should be index 0
    }

    @Test
    public void stringTests() {
        Map<String> test = new Map<>();
        test.add(0, "testing testing 123");
        test.add(1, "i dont want to test anymore");
        assertEquals(0, test.indexOf("testing testing 123"));
        assertEquals("testing testing 123", test.get(0));
        assertEquals("i dont want to test anymore", test.get(1));
        //remove the strings
        test.remove(0);
        assertNull(test.get(0));
        test.remove(1);
        assertNull(test.get(1));
    }
}
