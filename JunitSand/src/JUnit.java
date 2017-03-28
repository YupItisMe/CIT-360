import org.junit.Test;
import static org.junit.Assert.*;


public class jUnitTesting {
    // assert Equals
    @Test
    public void checkArrayEquals() throws Exception {
        int[] firstArray = {1, 2, 3, 4};
        int[] secondArray = {5, 6, 7};
        assertArrayEquals(firstArray, secondArray);
}
// assert NOT same
    @Test
    public void checkNotSame() throws Exception {
        String firstName = new String();
        String secondName = new String();
        name = "Joshua Cunningham";
        name2 = "Fred Flinstone";
        assertNotSame(firstName, secondName);
}
// assert same
    @Test
    public void checkSame() throws Exception {
        String firstName = new String();
        name = "Josh";
        assertSame("Josh", name);
}
   
    public boolean isEvenNumber(int number){   
        boolean result = false;
        if(number % 2 == 0){
            result = true;
        }
        return result;
    }
    
    // Assert false
    @Test
    public void checkFalse() throws Exception {
        boolean check = isEvenNumber(11);
        assertFalse(check);
    }
    
    // Assert Not Null
    @Test
    public void checkNull() throws Exception {
        String name = new String();
        name = "Josh";
        assertNotNull(name);
}
    
    // Assert check for null
    @Test
    public void Null() throws Exception {
        String name = new String();
        name = null;
        assertNull(name);
}
    
}