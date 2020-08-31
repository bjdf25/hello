package heima;
/*
    题目:
    给定一个cook接口，内涵唯一抽象方法makefood，且无参数，无返回值
    用Lambda标准格式调用invokecook方法，打印输出吃饭了字样

    方法的参数列表是对象时，调用这个方法也要new一个对象
 */
public class Demo01LambdaCook {
    public static void main(String[] args) {
//        invokeCook(new Cook() {//所以main方法中调用invokecook方法时参数列表中也要new一个Cook接口的对象然后重写其中的makefood（）方法
//            @Override
//            public void makeFood() {
//                System.out.println("吃饭了！");
//            }
//        });
        invokeCook(()->//makefood方法没有参数，所以Lambda是空括号
            System.out.println("吃饭了！")
        );

    }
    public static void invokeCook(Cook cook){//invokecook方法的参数是Cook接口的对象
        cook.makeFood();
    }
}
