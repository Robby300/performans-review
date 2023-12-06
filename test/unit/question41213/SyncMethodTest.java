package question41213;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SyncMethodTest {
    Counter synchronizedBlocksCounter = new SynchronizedBlocksCounter();
    Counter synchronizedMethodsCounter = new SynchronizedMethodsCounter();
    Counter reentrantLockCounter = new ReentrantLockCounter();

    @Before
    public void init() {

        createAndStartCounterThreads(synchronizedBlocksCounter);
        createAndStartCounterThreads(synchronizedMethodsCounter);
        createAndStartCounterThreads(reentrantLockCounter);
    }

    private void createAndStartCounterThreads(Counter counter) {
        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 999; i++) {
                counter.decrement();
            }
        });
        incrementThread.start();
        decrementThread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void synchronizedBlocksCounterShouldCountZero() {
        assertEquals(synchronizedBlocksCounter.getCount(), 1);
    }

    @Test
    public void synchronizedMethodsCounterShouldCountZero() {
        assertEquals(synchronizedMethodsCounter.getCount(), 1);
    }

    @Test
    public void reentrantLockCounterShouldCountZero() {
        assertEquals(reentrantLockCounter.getCount(), 1);
    }
}
