package Lambda;

import java.util.function.Function;

/*
    题目：自定义函数模型拼接
    上一个接口里返回的是什么类型的数值，下一个接口就要用对应的数据类型来接收，一起共用一个地址值不变的变量str
 */
public class DemoFunction {
    public static int change(String s,
                             Function<String ,String> fun1,Function<String,Integer> fun2,Function<Integer,Integer> fun3){

        return fun1.andThen(fun2).andThen(fun3).apply(s);
    }

    public static void main(String[] args) {
        String str = "赵丽颖，20";
        int num =change(str,(String s )->{//这里的S是传递进去的str，值为："赵丽颖，20"，下面返回的是分割后的值
            return s.split("，")[1];//三个Function接口的功能是逐一对参数S进行的改变，所以三个接口的构造参数里都是同一个数的地址，数值接连发生变化
        },(String s)->{//这里的s是str值变化后的值："20"，也是上一个接口返回的值
            return Integer.parseInt(s);
        },(Integer i)->{//这里的i是str值变化后的值，也是上一个接口返回的值：20
            return i+100;//可以看到上个接口返回什么类型的数值下一个接口的参数里就要用什么类型的数值来接收
        });
        System.out.println(num);
    }
}
