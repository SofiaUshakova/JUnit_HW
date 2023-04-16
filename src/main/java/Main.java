import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();

        int a = (int) calc.plus.apply(1, 2);
        calc.println.accept(a);
        int b = (int) calc.minus.apply(1, 1);
        calc.println.accept(b);
        int c = (int) calc.devide.apply(a, b);
        calc.println.accept(c);
    }
}

class Calculator<T> {
    static Supplier<Calculator> instance = Calculator::new;

    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    // Работа программы завершается с ошибкой, если в процессе выполнени y равен нулю, т.к. делить на ноль нельзя
    BinaryOperator<Integer> devide = (x, y) -> {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            System.out.println("Делить на ноль нельзя");
        }
        return 0;
    };

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
    Predicate<Integer> isPositive = x -> x > 0;
    Predicate<Integer> isNegative = x -> x < 0;
    Predicate<Integer> isZero = x -> x == 0;
    Consumer<Integer> println = System.out::println;
}


