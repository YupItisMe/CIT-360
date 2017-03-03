import org.junit.*;
import static org.junit.Assert.*;


public class PersonTest extends Person {
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {

    }

    @BeforeClass
    public static void beforeClass() {
    }

    @AfterClass
    public static void afterClass() {
    }

    @Test
    public void testGetName() throws Exception {
        Person josh = new Person("Josh", 5, 6);
        assertEquals("Josh", josh.getName());
    }

    @Test
    public void testSetjoshName() throws Exception {
        Person josh = new Person();
        josh.setName("Josh");
        assertEquals("Josh", josh.getName());
    }

    @Test
    public void testGetjoshAge() throws Exception {
        Person josh = new Person("Josh", 5, 6);
        assertEquals(5, josh.getAge());
    }

    @Test
    public void testSetjoshAge() throws Exception {
        Person josh = new Person();
        josh.setAge(5);
        assertEquals(5, josh.getAge());
    }

    @Test
    public void testGetjoshWeight() throws Exception {
        Person josh = new Person("Josh", 5, 6);
        assertEquals(6, josh.getWeight());
    }

    @Test
    public void testSetjoshWeight() throws Exception {
        Person josh = new Person();
        josh.setWeight(6);
        assertEquals(6, josh.getWeight());
    }


}