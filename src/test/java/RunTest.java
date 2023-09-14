import Hooks.DriverSetups;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RunTest extends DriverSetups {

    public void main(){
        open("https://demoqa.com/automation-practice-form");
    }

    int number = 6;

    @BeforeAll
    public static void beforeTests(){
        System.out.println("This method before Tests");
    }

    @AfterAll
    public static void afterTests(){
        System.out.println("This method after Tests");
    }

    @Test
    public void test1(){
        main();
        System.out.println("Test 1");
        boolean flag = number == PseudoMethods.pseudoMethod(3);
        assertTrue(flag, "Сумма значений не удовлетворяет условию");
    }

    @Test
    public void test2(){
        main();
        System.out.println("Test 2");
        assertEquals(number, new PseudoMethods().pseudoMethod2(4),"Сумма значений не удовлетворяет условию");
    }

    //Тест, если к примеру ошибка отловленная ассертом, не должна крашить аппликейшн
    @Test
    public void test3(){
        main();
        System.out.println("Test 3");
        try {
            assertEquals(number, new PseudoMethods().pseudoMethod2(4));
        }catch (AssertionError e){
            System.out.println("fail");
        }
    }
}
