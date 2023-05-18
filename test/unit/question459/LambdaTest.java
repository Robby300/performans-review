package question459;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @Test
    public void lambdaTest() {
        numbers.forEach( number -> System.out.println(number) );
    }

    @Test
    public void lambdaTest2() {
        Consumer<Integer> method = number -> { System.out.println(number); };
        numbers.forEach( method );
    }

    @Test
    public void lambdaTest3() {
        Predicate<Integer> evenPredicate = (number -> number % 2 == 0);
        List<Integer> collect = numbers.stream().filter(evenPredicate).collect(Collectors.toList());
        assertTrue(collect.contains(8));
        assertEquals(collect.size(), 1);
    }

    @Test
    public void lambdaTest4() {
        System.out.println("test #4");
        Comparator<Integer> reversOrder = (number1, number2) -> number2 - number1;
        numbers.stream().sorted(reversOrder).forEach(System.out::println);
    }

    @Test
    public void lambdaTest5() {
        Runnable runnable = () -> {
            IntStream.range(0, 5).forEach(System.out::println);
        };

        new Thread(runnable).start();
    }
}
