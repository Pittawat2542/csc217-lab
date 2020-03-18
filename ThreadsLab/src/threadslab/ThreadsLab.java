package threadslab;

import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadsLab {

    public static void main(String[] args) {
        try {
            //        MyThreadManager t1 = new MyThreadManager(1, 1000000000);
//        MyThreadManager t2 = new MyThreadManager(1000000001, 2000000000);
//        MyThreadManager t3 = new MyThreadManager(2000000001, 3000000000);
//
//        Thread th1 = new Thread(t1);
//        Thread th2 = new Thread(t2);
//        Thread th3 = new Thread(t3);
//
//        long startTime = System.nanoTime();
//        th1.run();
//        th2.run();
//        th3.run();
//        long endTime = System.nanoTime();
//
//        System.out.println("Sum: " + (t1.sum + t2.sum + t3.sum));
//        System.out.println("Time taken: " + (endTime - startTime));
//        
//        long sum2 = 0;
//        startTime = System.nanoTime();
//        for (long i = 1; i <= 3000000000l; i++) {
//            sum2 += i;
//        }
//        endTime = System.nanoTime();
//
//        System.out.println("Sum 2: " + sum2);
//        System.out.println("Time taken: " + (endTime - startTime));

            MyThreadManager t1 = new MyThreadManager(new BigInteger("1"), new BigInteger("10000000"));
            MyThreadManager t2 = new MyThreadManager(new BigInteger("10000001"), new BigInteger("20000000"));
            MyThreadManager t3 = new MyThreadManager(new BigInteger("20000001"), new BigInteger("30000000"));

            Thread th1 = new Thread(t1);
            Thread th2 = new Thread(t2);
            Thread th3 = new Thread(t3);

            th1.setName("Thread 1");
            th2.setName("Thread 2");
            th3.setName("Thread 3");

            long startTime;
            long endTime;

            startTime = System.nanoTime();
            th1.start();
            th1.join();
            th2.start();
            th2.join();
            th3.start();
            th3.join();
            endTime = System.nanoTime();

            System.out.println("With 3 Threads: " + t1.sum.add(t2.sum).add(t3.sum));
            System.out.println("With 3 Threads: " + (endTime - startTime));

            BigInteger sumNormal = BigInteger.ZERO;
            startTime = System.nanoTime();
            for (BigInteger i = BigInteger.ONE; i.compareTo(new BigInteger("30000000")) <= 0; i = i.add(BigInteger.ONE)) {
                sumNormal = sumNormal.add(i);
            }
            endTime = System.nanoTime();
            System.out.println("With 1 Thread: " + sumNormal);
            System.out.println("With 1 Thread: " + (endTime - startTime));

        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadsLab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
