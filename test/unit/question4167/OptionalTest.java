package question4167;

import org.junit.jupiter.api.Test;

import java.lang.ref.WeakReference;
import java.util.Optional;

import static groovy.util.GroovyTestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class OptionalTest {
    @Test
    public void testOptionalWithValue() {
        Optional<String> optional = Optional.of("Hello");
        assertTrue(optional.isPresent());
        assertEquals("Hello", optional.orElseThrow(() -> new RuntimeException("А нету тут ничего")));
    }

    @Test
    public void testOptionalWithNullValue() {
        Optional<String> optional = Optional.ofNullable(null);
        assertFalse(optional.isPresent());
    }

    @Test
    public void testOptionalWithDefault() {
        Optional<String> optional = Optional.empty();
        String value = optional.orElse("Default");
        assertEquals("Default", value);
    }

    @Test
    public void testOptionalWithFilter() {
        Optional<String> optional = Optional.of("Hello");
        Optional<String> filteredOptional = optional.filter(value -> value.length() > 5);
        assertFalse(filteredOptional.isPresent());
    }

    @Test
    public void testOptionalWithMap() {
        Optional<String> optional = Optional.of("Hello");
        Optional<Integer> lengthOptional = optional.map(String::length);
        assertEquals(Optional.of(5), lengthOptional);
    }

    @Test
    public void testOptionalWithFlatMap() {
        Optional<String> optional = Optional.of("Hello");
        Optional<String> flatMappedOptional = optional.flatMap(value -> Optional.of(value + " World"));
        assertEquals(Optional.of("Hello World"), flatMappedOptional);
    }
}
