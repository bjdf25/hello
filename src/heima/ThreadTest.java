package heima;



/*
    创建多线程的第一种方式：创建Thread的子类
    java.lang（lang包下的类调用的时候不需要import）.Thread是描述线程的类，我们想要实现多线程程序，就必须继承Thread
    实现步骤：
        1.创建一个Thread的子类
        2.在子类中重写Thread类的run方法，设置线程任务（开启线程需要做的事）
        3.在main方法中创建子类的对象
        4.通过子类对象调用Thread父类中的start方法，开启新的线程，执行run方法
             void start()使得该线程开始执行，Java虚拟机调用该线程的run方法。
             结果就是两个线程并发的执行：当前线程（main线程）和另一个线程（创建的新线程，执行其run方法）。
             多次启动一个线程是非法的。特别是当线程已经结束执行后，不能再重新启动。
          Java程序属于抢占式调度，哪个线程的优先级高先执行哪个线程。同一个优先级则随机选择一个进行
 */
/*
        设置线程的名称：
        1.使用Thread类中的方法setName（）
            void setName(String name)改变线程名称，使之与参数name相同。
        2.创建一个带参数的构造方法，参数传递线程的名称，调用父类的带参构造方法，把线程传递给父类，让父类（Thread）给子类线程起一个名称
            Thread(String name)分配新的Thread对象
 */
/*
        Public static void sleep(long millis):使当前正在执行的程序以指定的毫秒数暂停（暂时停止执行）
        毫秒数完后，程序继续执行
 */
/*
        解决多线程安全（可能执行了相同的任务或者错误的任务）的方法：
            1.同步代码块：
               格式：
                  先任意创建一个对象成为锁对象（通常都是Object obj = new Object();）
                  synchronized(锁对象即obj){
                        可能会出现线程安全问题的代码（访问了共享数据的代码）
                  }
               注意：
                   1.同步代码块中的对象可以是任意的对象。
                   2.但是必须保证多个线程使用的是同一个锁对象
                   3.锁对象的作用：把同步代码块锁住，只让一个线程在同步代码块中执行（一个线程抢到了锁执行代码后归还锁之后才能继续有
                   线程抢锁并执行任务）
             2.同步方法：
                步骤:
                    1.把访问了共享数据（即接口实现类中定义的变量）的代码抽取出来放在一个方法中
                    2.在方法中写上synchronized修饰符，然后在run方法中调用此方法。
                    3.锁对象就是接口实现类的对象：This.
                    4.也可以在方法中加上static变成静态同步方法，定义的变量也得是静态的
                    但是锁对象就不是this了，而是实现类.class\
             3.Lock方法（提供了比使用synchronized方法和语句可获得的更广泛的锁定操作）
                步骤：
                    1.在成员位置创建一个ReentrantLock对象。
                    2.在可能会出现安全问题的代码前调用Lock接口中的方法Lock（）获取锁。
                    3.在可能会出现安全问题的代码后调用Lock接口中的方法unLock（）释放锁。
                  即：Lock l = new Lock();
                  l.Lock();
                  try{
                  }catch(){
                  }finally{
                  l.unLock();}(最好把解锁方法写进Finally里，这样即使出现异常也会执行finally代码块里的解锁方法)


 */
/*
            匿名内部类作用：简化代码
                把子类继承父类，重写父类的方法，创建子类对象一步完成
                把实现类实现类的忌口，重写接口中的方法，创建实现类对象一步完成
             匿名内部类的最终产物：子类/实现类对象，而这个类没有名字
           ！！！总结格式：
              1.子类的方式
                new Thread(){重写run方法}.start();
              2.接口的方式
                new Thread(new RunnableImpl(){重写run方法}).start();
                                   👆这是实现接口的实现类
               一个类只能继承一个父类（一个子只能有一个亲爹），但可以实现多个接口（但是可以有多个干爹）
 */
public class ThreadTest {
    public static void main(String[] args) {
//        MyThread mt = new MyThread();
//        mt.start();//这里调用的是创建线程类的父类Thread的start方法以此来执行创建线程中的run方法
//        for (int i = 0; i <10 ; i++) {
//            System.out.println("主线程： " + i);
//        }
//        MyThread01 mt = new MyThread01("旺财");//这里new对象之后就可以使用类的构造方法，有空参数构造方法和有参构造方法，当使用有参构造方法时，就调用父类中的构造方法
//        mt.setName("小强");
//        mt.start();
//        for (int i = 1; i <=60 ; i++) {
//            System.out.println(i);
//            try {
//                Thread.sleep(1000);//因为sleep方法是static的不需要new一个对象就能直接调用该方法
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//              RunnableImpl runimpl = new RunnableImpl();//创建实现类的对象
//        Thread th = new Thread(runimpl);//创建Thread类的对象并且在构造参数中传递实现类的对象runimpl
//        Thread th1 = new Thread(new RunnableImpl());
//        Thread th2 = new Thread(new RunnableImpl());
//        th2.start();
//        th2.start();//不能开启相同的线程两次 否则会报错
//        th1.start();
//        th.start();
//
//        //设置一个主线程
//
//            System.out.println(Thread.currentThread().getName());

//        new Thread() {//第一种匿名内部类直接new一个Thread，重写其中的run方法开启一个新线程
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+"第一种匿名内部类");
//
//
//            }
//            //重写run方法，设置线程任务
//        }.start();
//
//
//        Runnable run = new RunnableImpl(){//第二种匿名内部类，采用多态（左父右子）把线程任务装进对象run中,但这不够简洁
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//            }
//        };
//        new Thread(run).start();//把对象赋给Thread对象
//
//        new Thread(new RunnableImpl(){//这样最简洁
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//            }
//        }).start();
        RunnableImpl run =new RunnableImpl();
        Thread t = new Thread(run);
        t.start();
        Thread t2 = new Thread(run);
        t2.start();
        Thread t1 = new Thread(run);
        t1.start();
    }
}
