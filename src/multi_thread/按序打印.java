package multi_thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 按序打印 {

    // 构造执行屏障
    class Foo1 {
        private boolean firstFinished;
        private boolean secondFinished;
        private Object lock = new Object();
        public Foo1() {}

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (lock) {
                printFirst.run();
                firstFinished = true;
                lock.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (lock) {
                while(!firstFinished) {
                    lock.wait(); // 会自动释放锁
                }
                printSecond.run();
                secondFinished = true;
                lock.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (lock) {
                while(!secondFinished) {
                    lock.wait();
                }
                printThird.run();
            }
        }
    }

    // countDownLatch  使一个线程等待其他线程各自执行完毕后再执行，通过计数器实现，初始值使线程的数量，当一个线程执行完毕后，计数器值-1
    class Foo2 {
        private CountDownLatch cdl2;
        private CountDownLatch cdl3;
        private Object lock = new Object();
        public Foo2() {
            cdl2 = new CountDownLatch(1);
            cdl3 = new CountDownLatch(1);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            cdl2.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            cdl2.await();
            printSecond.run();
            cdl3.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            cdl3.await();
            printThird.run();
        }
    }

    class Foo3 {
        // semaphore 与 countdownlatch 相似，不同在于semaphore的值被获取到之后是可以释放的，不会像countdownlatch一样减到底
        private Semaphore sp2, sp3;
        public Foo3() {
            sp2 = new Semaphore(0);
            sp3 = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            sp2.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            sp2.acquire();
            printSecond.run();
            sp3.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            sp3.acquire();
            printThird.run();
        }
    }

    class Foo4 {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();
        int state = 1;

        public Foo4() {}

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            try {
                if(state != 1) {
                    condition1.await();
                }
                state = 2;
                printFirst.run();
                condition2.signal();
            } finally {
                lock.unlock();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            try {
                if(state != 2) condition2.await();
                state = 3;
                printSecond.run();
                condition3.signal();
            } finally {
                lock.unlock();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            try {
                if(state != 3) condition3.await();
                printThird.run();
            } finally {
                lock.unlock();
            }
        }
    }

    class Foo {
        private volatile int state = 1;
        public Foo() {}

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            state = 2;
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while(state != 2);
            printSecond.run();
            state = 3;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while(state != 3);
            printThird.run();
        }
    }
}
