package Lambda;

import java.util.ArrayList;
import java.util.List;

/*
    使用Stream流的方式，遍历集合，对集合中的数据进行过滤
    Stream流是JDK1.8之后出现的
    关注的是做什么，而不是怎么做
    stream流的数据源一般是集合，数组
 */
public class DemoStream {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        //对list集合中的元素进行过滤，只要以张开头的元素，存储到一个新的集合中
        //对list集合进行过滤，只要姓名长度为3的人，存储到一个新的集合中
        //遍历新集合
        /*
            首先调用集合list对象方法里的stream方法，stream方法的返回值又可以调用其中的filter过滤器方法，filter方法构造参数为各种功能接口
            且只有一种抽象方法，就可以使用lambda表达式，功能接口内的方法都有参数类型，选择String name为参数
            这里的String类型的name就是传递进来的泛型为String类型的list集合，后面的方法都是针对list集合进行编程设计
         */
        list.stream().filter((String name)->name.startsWith("张"))//filter方法内参数为predicate，判断型接口，返回布尔值，为真就执行下一个命令
                .filter(name->name.length() ==3)
                .forEach(name-> System.out.println(name));//foreach方法内参数为consumer接口，消耗参数
    }
}
