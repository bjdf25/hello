package heima;
/*
    创建多线程的第二种方式：实现Runnable接口
    实现步骤：
      1.创建一个实现Runnable接口的实现类
      2.在实现类中重写接口中的抽象方法run
      3.在main方法中new一个实现类的对象
      4.在main方法中new一个Thread的对象，并在参数中传递实现类的对象
      5.调用Thread类中的start方法（这是因为实现类是实现的runnable接口，runnable中没有start方法，所以需要借助new Thread对象来实现Thread类中
        具有的start方法，然后在new Thread对象时传递一个实现类的对象）
 */

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public  class RunnableImpl implements Runnable {

    private static int ticket = 100;
    Lock l = new ReentrantLock();
    Object obj =new Object();
    @Override
    public void run() {

//            System.out.println(Thread.currentThread().getName());//输出目前线程的名字

        while (true) {
//            l.lock();//把锁放到可能会出现错误的程序前面，while（true）不可能出错
//            synchronized (obj) {
//                suo();
//            }
        }
    }
//    public static synchronized void suo(){
//        try {
//
//            Thread.sleep(10);//使程序睡眠10ms，更能出现错误
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
////                    l.unlock();//把解锁放在finally代码块  即使抛出异常也能执行解锁动作
//        }
//        if (ticket > 0) {
//            System.out.println("当前正在卖第" + ticket + "张票");
//        }
//        ticket--;
//    }
}
