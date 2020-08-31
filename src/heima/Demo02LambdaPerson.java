package heima;

import java.util.Arrays;

/*
    题目：使用数组存储多个Person对象
    对数组中的Person对象使用Arrays的sort方法通过年龄进行升序排序
 */
public class Demo02LambdaPerson {


    public static void main(String[] args) {
        Person [] arr = {
                new Person(21,"张三"),
                new Person(15,"李四"),
                new Person(43,"王五")
        };
        Arrays.sort(arr,(Person o1 ,Person o2) -> {
           return o1.getAge() - o2.getAge();
        });//调用sort方法就能使数组按年龄大小进行排序，此时的数组已经排序完毕
        for (Person person : arr) {
            System.out.println(person.getName() + person.getAge());
        }
    }
}
