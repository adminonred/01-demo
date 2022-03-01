package threadpool;

import java.util.Date;

public class MyRunnable implements Runnable {
    String s;

    public MyRunnable() {
    }

    public MyRunnable(String s) {
        this.s = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"worker"+s+"startTime"+new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"worker"+s+"endTime"+new Date());
    }
}
