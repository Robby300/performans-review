package question4511;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodReferenceTest {
    ArrayList<Integer> numbers = new ArrayList<Integer>();


    @Before
    public void init() {
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
    }

    // ссылка на метод
    @Test
    public void classMethodTest() {
        List<Double> collect = numbers.stream()
                .map(Integer::doubleValue)
                .collect(Collectors.toList());
    }

    // ссылка на статический метод
    @Test
    public void classStaticMethodTest() {
        //
        Consumer<String> consumer = TestStaticClass::testMethod;
        consumer.accept("someString");
    }

    // ссылка на метод объекта
    @Test
    public void objectMethodTest() {
        TestClass testClass = new TestClass();
        Consumer<String> consumer = testClass::testMethod;
        consumer.accept("Hello");

    }

    // ссылка на метод конструктора
    @Test
    public void constructorMethod() {
        Function<String, MyClass> function = MyClass::new;
        MyClass object = function.apply("Hello world");
        System.out.println(object.getMessage());
    }
}
