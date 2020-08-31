package heima;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    Executors类中的静态方法：
        Static ExecutorService newFixedThreadPool(int nThreads)创建一个可重用固定线程数的线程池
        参数：
            int nThreads:创建线程池中包含的线程数量
        返回值：
            ExecutorService接口，返回的是ExecutorService接口的实现类对象，我们可以使用ExecutorService接口接收（面向接口编程）
         用来从线程池中获取线程，调用start方法，执行线程任务
            submit(Runnable task)提交一个Runnable任务用于执行
         关闭/销毁线程池的方法：
            void shutdown()
       线程池的使用步骤：
        1.使用Executors中的静态方法newFixedThreadPool方法生产一个固定线程数量的线程池
        2.创建一个类，实现Runnable接口，重写一个类，设置线程任务
        3.调用ExecutorsService中的方法submit,传递线程任务（实现类），开启线程，执行run方法
        4.调用ExecutorsService中的方法shutdown()销毁线程池。
 */
public class Demo01ThreadPool {
    public static void main(String[] args) {
        //静态方法newFixedThreadPool方法返回的是ExecutorService接口的实现类对象，我们可以用ExecutorService接口接收
       ExecutorService es= Executors.newFixedThreadPool(2);
       //submit方法中的参数是实现类的对象，用来执行实现类的run方法
       es.submit(new RunnableImpl1());
       es.submit(new RunnableImpl1());
       es.submit(new RunnableImpl1());//这是用两个线程执行三个任务
       es.shutdown();
    }
}

class RunnableImpl1 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"创建了一个新的线程");
    }
}