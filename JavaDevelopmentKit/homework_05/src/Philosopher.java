
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable{
    private final int EAT_COUNT = 3;
    private final int TIME_FOR_EAT = 500;
    private final int TIME_FOR_THINKING = 1000;
    private Semaphore semaphore;
    private int count = EAT_COUNT;
    private Forks forks;
    private Fork left;
    private Fork right;
    public Philosopher (Forks forks, Semaphore semaphore) {
        this.forks = forks;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (count != 0) {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " Берет вилку в левую руку");
                Thread.sleep(new Random().nextInt(30));
                left = forks.getFork();
                System.out.println(Thread.currentThread().getName() + " Берет вилку в правую руку");
                Thread.sleep(new Random().nextInt(30));
                right = forks.getFork();
                System.out.println(Thread.currentThread().getName() + " Обедает");
                Thread.sleep(TIME_FOR_EAT);
                System.out.println(Thread.currentThread().getName() + " Пообедал");

                System.out.println(Thread.currentThread().getName() + " Кладет левую вилку");
                Thread.sleep(new Random().nextInt(30));
                forks.addFork(left);
                System.out.println(Thread.currentThread().getName() + " Кладет правую вилку");
                Thread.sleep(new Random().nextInt(30));
                forks.addFork(right);
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + " Думает");
                Thread.sleep(new Random().nextInt(TIME_FOR_THINKING));
                System.out.println(Thread.currentThread().getName() + " Подумал");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count--;
            System.out.println(Thread.currentThread().getName() + " покушал " + (EAT_COUNT - count) + " раз");
        }


    }
}
