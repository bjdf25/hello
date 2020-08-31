package heima;
//
//public class DemoBaoZi {
//    public static void main(String[] args) {
//        Baozi baozi = new Baozi();
//        new BaoZiPu(baozi).start();
//        new GuKe(baozi).start();
//
//    }
//}
 class Demo {
    public static void main(String[] args) {
        //创建包子对象;
        BaoZi bz =new BaoZi();
        //创建包子铺线程,开启,生产包子;
        new BaoZiPu(bz).start();
        //创建吃货线程,开启,吃包子;
        new ChiHuo(bz).start();
    }
}



//class Baozi{
//    String xian;
//    String pi;
//    boolean falg = false;
//    int count = 0;
//
//}
 class BaoZi {
    //皮
    String pi;
    //陷
    String xian;
    //包子的状态: 有 true,没有 false,设置初始值为false没有包子
    boolean flag = false;

}

//class BaoZiPu extends Thread {
//    private Baozi baozi;
//
//    public BaoZiPu(Baozi baozi) {
//        this.baozi = baozi;
//    }
//
//    @Override
//    public void run() {
//        while (true){
//            synchronized(baozi){//同步块代码只能在run方法里调用
//                if(baozi.falg == true){
//                    try {
//                        baozi.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    //被叫醒之后做的事
//                    if(baozi.count % 2 ==0){
//                        baozi.pi = "薄皮";
//                        baozi.xian = "猪肉馅";
//
//                    }else{
//                        baozi.pi = "厚皮";
//                        baozi.xian = "水晶馅";
//
//                    }
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("包子铺做了" + baozi.pi+ baozi.xian+"的包子");
//                    baozi.count++;
//
//                    baozi.falg = true;//本来falg = false ，昨晚之后就变成true了
//                    baozi.notify();//做完之后叫醒顾客
//                }
//            }
//        }
//    }
//
//
//}
 class BaoZiPu extends Thread{
    //1.需要在成员位置创建一个包子变量
    private BaoZi baoZi;

    //2.使用带参数构造方法,为这个包子变量赋值
    public BaoZiPu(BaoZi bz) {
        this.baoZi = bz;
    }

    //设置线程任务(run):生产包子
    @Override
    public void run() {
        //定义一个变量
        int count = 0;
        //让包子铺一直生产包子
        while(true){
            //必须同时同步技术保证两个线程只能有一个在执行
            synchronized (baoZi){
                //对包子的状态进行判断
                if(baoZi.flag==true){
                    //包子铺调用wait方法进入等待状态
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //被唤醒之后执行,包子铺生产包子
                //增加一些趣味性:交替生产两种包子
                if(count%2==0){
                    //生产 薄皮三鲜馅包子
                    baoZi.pi = "薄皮";
                    baoZi.xian = "三鲜馅";
                }else{
                    //生产 冰皮 牛肉大葱陷
                    baoZi.pi = "冰皮";
                    baoZi.xian = "牛肉大葱陷";

                }
                count++;
                System.out.println("包子铺正在生产:"+ baoZi.pi+ baoZi.xian+"包子");
                //生产包子需要3秒钟
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //包子铺生产好了包子
                //修改包子的状态为true有
                baoZi.flag = true;
                //唤醒吃货线程,让吃货线程吃包子
                baoZi.notify();
                System.out.println("包子铺已经生产好了:"+ baoZi.pi+ baoZi.xian+"包子,吃货可以开始吃了");
            }
        }
    }
}
//class GuKe extends Thread{
//    private Baozi baozi;
//
//    public GuKe(Baozi baozi) {
//        this.baozi = baozi;
//    }
//
//    @Override
//    public void run() {
//        while (true){
//            synchronized (baozi){
//                if(baozi.falg == false){
//                    System.out.println("顾客开始叫餐：");
//                    try {
//                        baozi.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                //else falg=true意为顾客手中有包子就可以吃包子了
//                System.out.println("顾客开始吃包子,吃完了");
//                baozi.falg = false;
//                baozi.notify();
//                System.out.println("顾客已经吃完了包子");
//                System.out.println("==============================");
//
//            }
//        }
//    }
//}

 class ChiHuo extends Thread{
    //1.需要在成员位置创建一个包子变量
    private BaoZi bz;

    //2.使用带参数构造方法,为这个包子变量赋值
    public ChiHuo(BaoZi bz) {
        this.bz = bz;
    }
    //设置线程任务(run):吃包子
    @Override
    public void run() {
        //使用死循环,让吃货一直吃包子
        while (true){
            //必须同时同步技术保证两个线程只能有一个在执行
            synchronized (bz){
                //对包子的状态进行判断
                if(bz.flag==false){
                    //吃货调用wait方法进入等待状态
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //被唤醒之后执行的代码,吃包子
                System.out.println("吃货正在吃:"+bz.pi+bz.xian+"的包子");
                //吃货吃完包子
                //修改包子的状态为false没有
                bz.flag = false;
                //吃货唤醒包子铺线程,生产包子
                bz.notify();
                System.out.println("吃货已经把:"+bz.pi+bz.xian+"的包子吃完了,包子铺开始生产包子");
                System.out.println("----------------------------------------------------");
            }
        }
    }
}
