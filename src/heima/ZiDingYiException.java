package heima;
/*
    自定义异常类格式：
      public class xxxException extends Exception/RunTimeException{
            添加一个空参数的构造方法
            添加一个带异常信息的构造方法
      }
      注意：
        1.自定义异常类一般都是以Exception结尾，说明是一个异常类
        2.自定义异常类，必须得继承Exception/RunTimeException
           继承Exception:那么自定义的异常类就是编译期异常，如果方法内部抛出了编译期异常，就必须处理这个异常，要么throw,要么try ... catch
           继承RunTimeException:那么自定义的异常类就是运行期异常，无需处理，直接交给虚拟机处理（中断处理）
 */
public class ZiDingYiException extends  Exception{
    public ZiDingYiException() {
        super();//执行父类的空构造器
    }
    /*
    查看源码发现，所有的异常类都会有一个带异常信息的构造方法，方法内部会调用父类带异常信息的构造方法，让父类来处理这个异常信息
     */
    public ZiDingYiException(String s){
        super(s);//继承父类的处理异常信息的方法，把形参s传过去
    }
}










