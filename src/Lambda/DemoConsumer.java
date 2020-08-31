package Lambda;

import java.util.function.Consumer;

public class DemoConsumer {


    public static void method(String s, Consumer<String> con1,Consumer<String> con2){
        //consumer接口中的默认方法andThen，谁先在前就先执行谁
        con1.andThen(con2).accept(s);//调用接口里的方法，传递s进去就用接口里的方法来使用s参数
    }

    public static void main(String[] args) {
        //注意:!!!lambda重写接口方法只是重写里面的方法，但是没有调用，所以还要在方法里调用接口里的方法
        method("Hello",(t)-> System.out.println(t.toUpperCase()),(t)-> System.out.println(t.toLowerCase()));//这一步只是重写其中的方法
    }
}
