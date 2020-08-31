package heima;
/*
    等待唤醒案例：线程之间的通信
         创建一个线程（消费者）：告知老板要的包子种类和数量，调用wait方法，进入waiting状态（无限等待）
         创建一个线程（生产者）；花了5秒做包子，做好包子之后，调用notify方法，唤醒顾客吃包子
    注意：
        顾客和老板之间必须使用同步代码块包裹起来，保证等待和唤醒只能有一个在执行
        同步使用的锁对象必须是唯一（这样才能让两个线程抢一把锁）
        只有锁对象才能调用wait和notify方法（只有Object类有这两个方法，意为必须创建object或其子类对象）

 */
public class DemoWaitAndNotify {
    public static void main(String[] args) {
        Object obj =new Object();//创建锁对象，保证锁唯一
        new Thread(){//创建一个消费者线程
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println("告知老板要的包子种类和数量");
                    try {
                        obj.wait();//提出要求后进入waiting状态，这个时候需要有调用notify方法的线程来与wait方法相呼应
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //这是被唤醒之后做的事
                    System.out.println("包子已经做好了，开吃！");

                }

            }
        }.start();
        new Thread(){
            @Override
            //之所以两个线程中是消费者线程先抢到锁先执行是因为生产者线程有一个sleep方法，
            //这样即使生产者线程抢到了锁也会因为遇到sleep方法从而睡眠丢掉cpu执行权，所以sleep方法就是为了先让
            //消费者线程先行执行
            public void run() {
                synchronized (obj){
                    try {
                        Thread.sleep(5000);//睡眠五秒钟意为花五秒钟做包子
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("老板花了五秒钟做好了包子，告知顾客可以吃包子了");
                    obj.notify();//wait方法和notify方法必须用的是同一个对象
                }
            }
        }.start();
    }
}
