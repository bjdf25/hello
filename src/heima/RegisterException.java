package heima;

import java.util.Scanner;

/*
        模拟注册操作，如果用户名已存在，则抛出异常提出：亲，该用户名已被注册！
 */
public class RegisterException {
    //使用数组保存已经注册过的用户名（数据库）
    static String[] usernames = {"张三", "李四", "王五"};//设置在main方法上面保证其他方法也能使用该数组

    public static void main(String[] args) throws ZiDingYiException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要注册的用户名：");
        String username = sc.next();//把要输入的名字放在变量ZhuCeName
        checkUsername(username);
    }

    //定义一个方法，对用户输入中的用户名进行判断是否存在
    public static void checkUsername(String username) throws ZiDingYiException {
        for (String name : usernames) {
            //使用获取到的用户名和用户输入的用户名进行比较？？？
            if(name.equals(usernames)) {
                throw new ZiDingYiException("亲，该用户已经被注册");

            }
        }
        System.out.println("恭喜您，注册成功！");
    }
}

