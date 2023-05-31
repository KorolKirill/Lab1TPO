package task6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterMy {
    private int counter = 0;

    public static void main(String[] args) {
        CounterMy counter = new CounterMy();
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                //synchronized (lock){
                    lock.lock();
                    counter.increment();
                    lock.unlock();
                //}
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                //synchronized (lock){
                    lock.lock();
                    counter.decrement();
                    lock.unlock();
                //}
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.counter);
    }

    private /*synchronized*/ void increment() {
        counter++;
    }

    private /*synchronized*/ void decrement() {
        counter--;
    }
}