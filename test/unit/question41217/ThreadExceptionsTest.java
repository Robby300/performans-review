package question41217;

import org.junit.Before;
import org.junit.Test;


public class ThreadExceptionsTest {
    Thread throwsExceptionThread;
    Thread enhanceExceptionThread;

    @Before
    public void init() {
        throwsExceptionThread = new Thread(() -> {
            throw new RuntimeException("thread throws exception");
        });

        enhanceExceptionThread = new Thread(() -> {
            try {
                throw new RuntimeException("thread throws exception");
            } catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        });
    }


    @Test
    public void shouldThrowsExceptionThreadTest() {
        try {
            throwsExceptionThread.start();
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        Assertations.
    }

}
