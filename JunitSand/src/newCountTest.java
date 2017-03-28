
import static org.junit.Assert.*;
import org.junit.Test;

public class newCountTest {

	@Test
	public void test() {
		newFunctions test = new newFunctions();
		int output = test.countIt("food");
		assertEquals(1, output);
		
	}

}