import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Forks {
    private Deque<Fork> forks = new ArrayDeque<>();
    private  ReentrantLock lock;
    private Condition condition;

    public Forks(int philosophersCount) {
        lock = new ReentrantLock();
        condition = lock.newCondition();
        for (int i = 0; i < philosophersCount; i++) {
            forks.add(new Fork());
        }
    }

    public void addFork (Fork fork) {
        forks.addLast(fork);
    }

    public Fork getFork () {
        Fork fork = null;
        lock.lock();
        try {
            while (forks.size() < 1)
                condition.await();
            fork = forks.pop();
            condition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        return fork;
    }
    public Deque<Fork> getForks() {
        return forks;
    }
}
