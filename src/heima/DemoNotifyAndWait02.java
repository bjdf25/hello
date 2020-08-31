package heima;
/*
        线程1和线程2都创造了包子类的对象，以这个对象在本类做一些事
        然后通过构造参数把对象传出去
        在main函数里，当Baozi zhenshibaozi = new Baozi();时
        new XianCheng1(zhenshibaozi).start();
        new XianCheng2(zhenshibaozi).start();
        括号里的对象都统一换成真正的new的对象zhenshibaozi
        这个时候线程1和2的形式对象是bz和bz2
        实际对象已经是zhenshibaozi
        所以其实线程1和线程2的对象都是同一个
        所以锁的对象就是同一个：zhenshibaozi
        传递构造参数的好处
 */
public class DemoNotifyAndWait02 {
    public static void main(String[] args) {
        Baozi zhenshibaozi = new Baozi();
        new XianCheng1(zhenshibaozi).start();
        new XianCheng2(zhenshibaozi).start();
    }
}
class Baozi{
    boolean flag = false;
}
class XianCheng1 extends Thread{
    Baozi bz = new Baozi();

    public XianCheng1(Baozi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true){
            synchronized (bz){
                if (bz.flag == false){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("接着执行线程1");
                System.out.println("-------------");
                bz.flag = false;
                bz.notify();
            }
        }
    }
}
class XianCheng2 extends Thread{
    Baozi bz2 = new Baozi();

    public XianCheng2(Baozi bz2) {
        this.bz2 = bz2;
    }

    @Override
    public void run() {
        while (true){
            synchronized (bz2){
                if(bz2.flag == true){
                    try {
                        bz2.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("首先执行线程二");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bz2.flag = true;
                bz2.notify();
            }
        }
    }
}