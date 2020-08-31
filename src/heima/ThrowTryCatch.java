package heima;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
格式：
        try{
        可能出现异常的代码块
        }catch(定义一个异常的变量，用来接收try中抛出的处理对象（一般直接用Exception）){
        怎么处理异常对象
        在工作中一般都把异常的信息记录到一个日志中
        }
    如果try中没有异常，则不执行catch中的代码块，继续执行后面的代码
    有多个异常对象就执行多个catch，并继续执行后面的代码
    throws后边有代码都不能执行，因为将异常交给JVM处理之后程序就中断了
    try catch异常被捕获后后面的代码块就可以执行
 */

/**
 * Throwable类中的三个处理异常的方法
 * 1.getMassage()
 * 2.toString()
 * 3.printStackTrace:信息最全面,最直观
 */
public class ThrowTryCatch {
    public static void main(String[] args) throws IOException {


        int a[]= new int [3];
        int i =0;
        try{
            System.out.println(3/i);
            readFile("asd.xt");//调用方法中传递出来的形参后缀不endsWith .txt,产生了异常（方法中抛出异常），产生异常后就执行catch中的代码块
            System.out.println(a[3]);
        }catch (NullPointerException e){
            System.out.println("错误");
        } catch(FileNotFoundException e) {

            System.out.println("后缀不对");
        }
//        }catch (Exception e){
//            System.out.println("数组越界");
//        }
        /*

        一个try多个catch注意事项：
                catch里边定义的异常变量，如果有子父类关系，那么子类的异常变量必须写在上边，不然报错
                ArrayIndexOutOfBoundsException extends IndexOufOfBoundsException
         */
        /*
        多个异常一次捕获一次处理   把多个异常放在try内，catch内直接写exception
        运行时异常（数组越界异常，空指针异常null）被抛出可以不处理   即不捕获（try）也不声明抛出，
        默认给虚拟机处理，中止程序，什么时候不抛出运行时异常了，再来继续执行程序
         /*
         父类异常什么样，子类异常就怎么样
         要么一样 要么抛出异常的子类
         要么就不抛出（父类方法没有抛出异常，子类重写父类该方法时也不可抛出异常 此时子类产生此异常，只能捕获处理，不能声明抛出）
          */
        /*
        抛出有声明抛出  和  throw new exception抛出
        finally代码块内返回值
         */
        System.out.println("程序继续执行");
    }
    public static void readFile(String fileName) throws IOException {
        if(!fileName.endsWith(".txt")){
            throw new IOException("传递的文件路径不对");
        }
    }
}
