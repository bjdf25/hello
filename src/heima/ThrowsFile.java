package heima;

import java.io.FileNotFoundException;
import java.io.IOException;
/*
throws关键字是抛出异常给调用者处理（即JVM）
 */

public class ThrowsFile {
    public static void main(String[] args) throws Exception {//当异常为父子类关系时直接声明父类即可,Exception是所有异常类的父类 直接声明exception
        readFile("c:\\a.rar");//当是编译异常时在调用时都要在顶部声明异常
    }
    public static void readFile(String fileName) throws IOException ,FileNotFoundException{
        if(!fileName.equals("c:\\a.txt")) {
            throw new FileNotFoundException("传递的文件路径不是c:\\a.txt");//FileNotFoundException是编译异常，必须在方法的顶部声明，
        }
        if(!fileName.endsWith(".txt")){//endsWith是判断后缀是否一致
            throw new IOException("文件的后缀名不对");
        }
        System.out.println("路径正确");//路径正确时输入这段话，路径不对异常时则不能运行这行代码
    }
}
