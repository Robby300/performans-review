package question41213;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter implements Counter {
    private int count;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            count--;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
//        lock.lock();
        return count;

    }
}
