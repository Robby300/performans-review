package question41217;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ThreadExceptionsTest {

    CompletableFuture<Void> future = new CompletableFuture<>();

    Thread enhanceExceptionThread = new Thread(() -> {
        try {
            throw new RuntimeException("thread throws exception");
        } catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
            future.completeExceptionally(e);
        }
    });

    @Test
    public void shouldThrowsExceptionThreadTest() throws InterruptedException, ExecutionException {
        enhanceExceptionThread.start();
        Thread.sleep(10);
        try {
            future.get();
        } catch (ExecutionException e) {
            assertEquals("thread throws exception", e.getCause().getMessage());
        }
    }

}
