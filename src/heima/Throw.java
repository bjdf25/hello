package heima;

import java.util.Objects;

/*
throw关键字的作用：可以使用关键字在指定的方法中抛出指定的异常
 */
public class Throw {
    public static void main(String[] args) {
        int a[] = new int []{1,2,3};
        try{
            System.out.println(a[3]);
        }catch (Exception e0){
            e0.printStackTrace();
//            System.out.println(e0.getMessage());
        }
        System.out.println(2);

//    public static void method(Object obj){
//////        if(obj == null){
//////            throw new NullPointerException("传递的对象值是null");
//////
//////        }
////        Objects.requireNonNull(obj,"传递的对象为null");
////        //ArrayIndexOutOfBoundsException  此乃数组越界异常
////        //NullPointerException 此乃空指针异常
//
//
//    }

    }



}
