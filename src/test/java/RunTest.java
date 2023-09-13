import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class RunTest {

    int number = 6;

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
        boolean flag = number == PseudoMethods.pseudoMethod(3);
        assertTrue("Сумма значений не удовлетворяет условию",flag);
    }

    @Test
    public void test2(){
        System.out.println("Test 2");
        assertEquals("Сумма значений не удовлетворяет условию",number, new PseudoMethods().pseudoMethod2(4));
    }

    //Тест, если к примеру ошибка отловленная ассертом, не должна крашить аппликейшн
    @Test
    public void test3(){
        System.out.println("Test 3");
        try {
            assertEquals(number, new PseudoMethods().pseudoMethod2(4));
        }catch (AssertionError e){
            System.out.println("fail");
        }
    }
}
