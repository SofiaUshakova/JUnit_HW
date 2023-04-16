import org.junit.jupiter.api.*;

public class CalculatorTests {
    Calculator sut;
    @BeforeAll
    public static void beforeall(){
        System.out.println("Начато тестирование калькулятора");
    }
    @AfterAll
    public static void aftereall(){
        System.out.println("Тестирование калькулятора завершено");
    }
    @BeforeEach
    public void beforeEach(){
        sut = new Calculator();
    }

    @Test
    public void plus(){
        //given
        int a = 2, b = 2, expected = 4;
        //when
        int actual = (int) sut.plus.apply(a, b);
        //then
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void minus(){
        //given
        int a = 2, b = 2, expected = 0;
        //when
        int actual = (int) sut.minus.apply(a, b);
        //then
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void isPositive(){
        //given
        int a = 1;
        boolean expected = true;
        //when
        boolean actual = sut.isPositive.test(a);
        //then
        Assertions.assertTrue(actual == expected);

    }
}
