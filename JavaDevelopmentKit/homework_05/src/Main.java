import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final int PHILOSOPHERS_COUNT = 5;
    private static final int SEMAPHORE_COUNT = 2;
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(SEMAPHORE_COUNT);
        Philosopher[] philosophers = new Philosopher[PHILOSOPHERS_COUNT];
        Forks forks = new Forks(philosophers.length);
        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new Philosopher(forks, semaphore);
        }

        for (int i = 0; i < philosophers.length; i++) {
            Thread thread = new Thread(philosophers[i]);
            thread.start();
        }
    }
}