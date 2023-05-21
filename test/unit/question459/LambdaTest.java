package question459;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LambdaTest {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    @Before
    public void init() {
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
    }

    // функциональный интерфейс Consumer<T> как безымянный класс
    @Test
    public void lambdaTest() {
        numbers.forEach(System.out::println);
    }

    // функциональный интерфейс Consumer<T>
    @Test
    public void lambdaTest2() {
        Consumer<Integer> consumer = System.out::println;
        numbers.forEach(consumer);
    }

    // функциональный интерфейс предикат
    @Test
    public void lambdaTest3() {
        Predicate<Integer> evenPredicate = (number -> number % 2 == 0);
        List<Integer> collect = numbers.stream().filter(evenPredicate).collect(Collectors.toList());
        assertTrue(collect.contains(8));
        assertEquals(collect.size(), 1);
    }

    // функциональный интерфейс комапаратор
    @Test
    public void lambdaTest4() {
        System.out.println("test #4");
        Comparator<Integer> reversOrder = (number1, number2) -> number2 - number1;
        numbers.stream().sorted(reversOrder).forEach(System.out::println);
    }

    // бинарный оператор в reduce
    @Test
    public void binaryOperatorTest() {
        BinaryOperator<Integer> multiply = (x, y) -> x * y;
        Integer reduce = numbers.stream()
                .reduce(1, multiply);
        assertEquals(new Integer(360), reduce);
    }

    // унарный оператор
    @Test
    public void unaryOperatorTest() {
        UnaryOperator<Integer> square = x -> x * x;
        List<Integer> collect = numbers.stream()
                .map(square)
                .collect(Collectors.toList());
    }

    // функция
    @Test
    public void functionTest() {
        Function<Integer, Double> divideByTwo = x -> x * 0.5;
        List<Double> collect = numbers.stream()
                .map(divideByTwo)
                .collect(Collectors.toList());
    }

    // поставщик supplier
    @Test
    public void supplierTest() {
        Supplier<Integer> randomInt = ()-> {
//            Scanner in = new Scanner(System.in);
//            System.out.println("Введите целое число: ");
//            Integer number = in.nextInt();
//            return number;
            Random random = new Random();
            return random.nextInt();
        };
        List<Integer> collect = Stream.generate(randomInt)
                .limit(5)
                .collect(Collectors.toList());
        assertEquals(5, collect.size());
    }

    // реализация Runable через лямбду
    @Test
    public void lambdaTest5() {
        Runnable runnable = () -> {
            IntStream.range(0, 5).forEach(System.out::println);
        };

        new Thread(runnable).start();
    }
}
