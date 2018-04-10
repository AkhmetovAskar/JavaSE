package samples;

import org.junit.*;
import static org.junit.Assert.*;

public class JUnitTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Call this method before all tests");
    }

    @Before
    public void before() {
        System.out.println("Call this method before each test");
    }

    @After
    public void after() {
        System.out.println("Call this method after each test");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Call this method after all tests");
    }

    @Test
    public void myTest1() {
        System.out.println("My Test 1");
        assertTrue("This message shows if wrong", 1 > 0);
    }

    @Test
    public void myTest2() {
        System.out.println("My Test 2");
        assertTrue("This message shows if wrong", -1 > 0);
    }

    @Ignore
    public void myTest3() {
        System.out.println("My Test 3");
    }

    @Test(expected=ArithmeticException.class)
    public void myTest4() {
        System.out.println("My Test 4");
        System.out.println(1/0);
    }

}
