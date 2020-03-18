package threadslab;

import java.math.BigInteger;

public class MyThreadManager extends Thread {
    BigInteger start;
    BigInteger end;
    BigInteger sum = BigInteger.ZERO;

    public MyThreadManager(BigInteger start, BigInteger end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        super.run();
//        System.out.println(Thread.currentThread().getName());
        for (BigInteger i = start; i.compareTo(end) <= 0; i = i.add(BigInteger.ONE)) {
            sum = sum.add(i);
        }
    }
    
}
