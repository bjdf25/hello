package heima;
/*
    可以在方法参数里写上集合
    并在main函数里调用此方法一样可以打印集合出来
    方法三要素：
        1.返回值类型：只是进行打印而已，没有运算，没有结果，就用void即可
        2.方法名字
        3.参数列表
     ArrayList<E> list = new ArrayList<>();
     sout(list)
     如果打印其他对象的话会是打印对象的地址
     但是打印list对象就是打印集合的样子，
     现在是空集合，即打印出来的是[]
 */

import java.util.ArrayList;

public class DemoArrayListPrint {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        printArrayList(list);//传一个集合到参数里
    }
    public static void printArrayList(ArrayList<String> list){//集合也可以作为方法的参数，这时候的集合里已经有了四个数据
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.println(list.get(i) + "}");
            } else {
                System.out.print(list.get(i) + "@");
            }
        }
    }
}
