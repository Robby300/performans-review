package question4129;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AtomicReferenceTest {

    @Test
    public void testAtomicReference() {
        String greeting = "Hello";
        AtomicReference<String> atomicReference = new AtomicReference<>(greeting);

        assertEquals("Hello", atomicReference.get());
        assertTrue(atomicReference.compareAndSet("Hello", "HelloWorld"));

        String previous = atomicReference.getAndSet("Здарова!");
        assertEquals(previous, "HelloWorld");
        assertEquals(atomicReference.get(), "Здарова!");
    }
}
