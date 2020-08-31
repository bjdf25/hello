package heima;

public class MyThread01 extends Thread {
    public MyThread01() {
    }

    public MyThread01(String name) {//父类构造器中的方法是：This.name = name,意为从构造器中传递过去的name就是自己定义的变量This.name
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
