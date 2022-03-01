package threadpool;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {
    private static final int CORE_POOL_SIZE=5;
    private static final int MAX_POOL_SIZE=10;
    private static final int QUEUE_CAPACITY=100;
    private static final Long KEEP_ALIVE_TIME=1L;

    public static void main(String[] args) {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(
                CORE_POOL_SIZE,//核心线程数，定义了最小可以同时运行的线程数量
                MAX_POOL_SIZE,//最大线程数，允许存在工作线程的最大数量
                KEEP_ALIVE_TIME,/*等待时间，线程池中的线程数量大于核心线程数时，如果这时候没有新的任务提交，核心线程外的线程不会
                立即销毁，而是会等待，直到时间超过等待时间才会被回收销毁*/
                TimeUnit.SECONDS,//等待时间单位
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),/*任务队列，新任务来的时候会先判断当前运行线程数量是否到达核心线程数，
                如果到达会被存放在队列中；如果任务队列也满了的话，会判断当前运行线程数是否到达最大线程数：否：创建线程，是：按照饱和
                策略处理*/
                new ThreadPoolExecutor.CallerRunsPolicy()//饱和策略
        );
        for(int i=0;i<10;i++){
            Runnable worker=new MyRunnable(i+"");
            executor.execute(worker);//执行Runnable类型的任务
            //executor.submit(worker);//可以执行Runnable和Callable类型的任务，返回持有计算结果的Future对象，使用get()获取结果

        }
        executor.shutdown();//等队列中所有任务都执行完成后才关闭
        //executor.shutdownNow();//尝试取消正在执行的任务，并返回所有已经提交但是还没有开始的任务
        while(!executor.isTerminated()){
            //主线程一直在这里循环直到所有线程执行完成且线程池关闭
        }
        System.out.println("Finished all Threads");
    }
}
