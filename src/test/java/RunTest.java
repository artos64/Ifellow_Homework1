import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RunTest {

    @Before
    public void beforeTest(){
        System.out.println("This method before Test");
    }

    @After
    public void afterTest(){
        System.out.println("This method after Test");
    }

    @Test
    public void test1(){
        System.out.println("Test 1");
        assertEquals("Incorrect value, expected = AM","AM", "AM");
    }

    @Test
    public void test2(){
        System.out.println("Test 2");
        assertEquals("Incorrect value, expected = AM","AM", "AM ");
    }
}
