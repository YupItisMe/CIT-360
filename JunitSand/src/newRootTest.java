
import static org.junit.Assert.*;
import org.junit.Test;

public class newRootTest {

	@Test
	public void test() {
		testFunctions test = new testFunctions();
		int output = test.squareRoot(6);
		assertEquals(36,output);
	}

}