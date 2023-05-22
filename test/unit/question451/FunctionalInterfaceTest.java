package question451;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class FunctionalInterfaceTest {

    ArrayList<Integer> numbers = new ArrayList<Integer>();
    @Before
    public void init() {
        numbers.add(5);
        numbers.add(-9);
        numbers.add(8);
        numbers.add(-1);
    }

    @Test
    public void functionalInterfaceTest() {
        MyPredicate myPredicate = x -> x > 0;
        List<Integer> collect = numbers.stream()
                .filter(myPredicate::test)
                .collect(Collectors.toList());
        assertEquals(2, collect.size());
    }
}
