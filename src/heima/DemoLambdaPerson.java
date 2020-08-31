package heima;

import java.util.Arrays;

/*
    题目：使用数组存储多个Person对象
    对数组中的Person对象使用Arrays的sort方法通过年龄进行升序排序
    Lambda： （）->{}

    Lambda使用前提：
        1.使用lambda必须具有接口，而且接口中有且仅有一个抽象方法

     有且仅有一个抽象方法的接口称之为“函数式接口”
 */
public class DemoLambdaPerson {
    public static void main(String[] args) {
        Person[] array = {//用数组存储对象的方法要多练习
                new Person(20, "张三"),
                new Person(21, "李四"),
                new Person(22, "王五"),
                new Person(23, "赵六")
        };
        //当大括号内只有一行代码时，可以省略return {} 和分号，但是要省略必须一起省略
        //当（）内有两个参数时，数据类型可以省略
        Arrays.sort(array, (o1,o2) -> o1.getAge() - o2.getAge());
        for (Person p : array) {
            System.out.println(p);
        }
    }
}
class Person {
    private int age;
    private String name;

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int age, String name) {

        this.age = age;
        this.name = name;
    }
}


