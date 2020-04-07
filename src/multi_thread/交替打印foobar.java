package multi_thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 交替打印foobar {
    class FooBar1 {
        private int n;

        public FooBar1(int n) {
            this.n = n;
        }

        Semaphore foo = new Semaphore(1);
        Semaphore bar = new Semaphore(0);

        public void foo(Runnable printFoo) throws InterruptedException {
            for(int i = 0; i < n; i++) {
                foo.acquire();
                printFoo.run();
                bar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for(int i = 0; i < n; i++) {
                bar.acquire();
                printBar.run();
                foo.release();
            }
        }
    }

    // 公平锁
    // 会 t
    class FooBar2 {
        private int n;

        public FooBar2(int n) {
            this.n = n;
        }
        Lock lock = new ReentrantLock(true);
        volatile boolean permitFoo = true;


        public void foo(Runnable printFoo) throws InterruptedException {
            for(int i = 0; i < n; ) {
                lock.lock();
                try {
                    if(permitFoo) {
                        printFoo.run();
                        i++;
                        permitFoo = false;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for(int i = 0; i < n; ) {
                lock.lock();
                try {
                    if(!permitFoo) {
                        printBar.run();
                        i++;
                        permitFoo = true;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    // cyclicBarrier
    class FooBar {
        private int n;
        CyclicBarrier cb = new CyclicBarrier(2);
        volatile boolean fin = true;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for(int i = 0; i < n; ) {
                while(!fin);
                printFoo.run();
                fin = false;
                try {
                    cb.await();
                } catch (BrokenBarrierException e) {

                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for(int i = 0; i < n; ) {
                try {
                    cb.await();
                } catch (BrokenBarrierException e) {

                }
                printBar.run();
                fin = true;
            }
        }
    }

}
