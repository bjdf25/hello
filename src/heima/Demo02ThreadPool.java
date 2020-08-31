package heima;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo02ThreadPool {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);//第一步先创建线程池并用接口接收
        //第三步就用ExecutorService中的方法submit执行任务，参数中放入实现类的对象
        es.submit(new RunnableImpl2());

    }

}

class RunnableImpl2 implements Runnable{

    @Override
    public void run() {//第二步创建接口实现类重写run方法编写任务
        System.out.println(Thread.currentThread().getName()+"线程正在执行任务");
    }
}