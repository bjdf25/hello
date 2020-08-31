package Lambda;
/*
JDK8新特性函数式接口里的方法：supplier:创建一个东西（有返回值）
                            consumer:消耗掉一个东西（返回值为void）
                            predicate：判断（返回值为布尔型）
                            function：进行类型间的转换

一般在集合或数组对象使用流式思想
stream of (数组)创建stream流
或者数组.stream创建
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");
        /*
        只要名字为三个字的成员变量：存储到一个新集合中
        只要前三个人，存到新集合中
         */
        Stream<String> st1 = one.stream().filter(name -> name.length() == 3).limit(3);//筛选就用filter接口
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张雪峰");
        /*
        只要姓张的成员变量：存储到一个新集合
        不要前两个人：存储到一个新集合
         */
        Stream<String> st2 = two.stream().filter(name -> name.startsWith("张")).skip(2);
        /*
        将两个队伍合并为一个队伍：存储到一个新集合
        根据姓名创建Person对象，存储到一个新集合
        打印整个队伍的Person对象信息
         */
        /*
        stream流中方法map：映射，把构造参数里的类型转换为返回类型
         */
        Stream.concat(st1, st2).map(name -> new Person(name)).forEach(f-> System.out.println(f));
        System.out.print(one);

    }

}
class Person{
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public Person() {
    }

    public Person(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}