package heima;

import java.util.ArrayList;

/*
    题目：
         自定义四个学生对象，添加到集合，并遍历对象
    注意：
        list.get()方法都需要创建一个变量来作为接收对象
 */
public class Demo02ArrayListStudent {
    public static void main(String[] args) {
        ArrayList<Student> list =new ArrayList<>();
        Student one = new Student(20,"张三");
        Student two = new Student(21,"李四");
        Student three = new Student(22,"王五");
        Student four= new Student(23,"赵六");
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
            Student stu = list.get(i);//list.get()方法都需要创建一个变量来作为接收对象
            //循环多此，每次都创建一个student的对象，然后每次都打印这个对象的getName和getAge方法，此为遍历对象，
            //如果只是打印list.get(i)的话只会打印对象的地址，而遍历对象应该打印对象的属性，即getXxx方法
            System.out.println("年龄为：" + stu.getAge() +" 名字为：" + stu.getName());
        }


    }
}


class Student{
    private int age;
    private String name;

    public Student() {
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

    public Student(int age, String name) {

        this.age = age;
        this.name = name;
    }
}
