package concurrency;

import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private int n;
    Integer zero = 0;
    boolean odd = true;
    Object o = new Object();
    Integer number = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber .accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        while(number <= n) {
            while(zero != 0) {
                try {
                    wait();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            printNumber.accept(0);
            zero = 1;
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        while(number <= n) {
            while(zero == 0 || odd) {
                try {
                    wait();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }

            number++;
            printNumber.accept(number);
            odd = true;
            zero = 0;
            notifyAll();
        }

    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        while(number <= n) {
            while(zero != 0 || !odd) {
                try {
                    wait();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }

            number++;
            printNumber.accept(number);
            odd = false;
            zero = 0;
            notifyAll();
        }
    }
}