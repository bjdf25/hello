package Lambda;

import java.util.function.Supplier;

/*
    求数组中的最大值
      用supplier接口作为方法参数列表，通过lambda表达式求出int数组中的最大值

    可以运用lambda表达式的接口：有且仅有一个抽象方法，但是接口中还可以有其他方法：static,private...
    假定要创建一个可以使用lambda表达式的接口，在接口开头@FunctionalInterface即可：当有且仅有一个抽象方法时，才不会报错
 */
public class DemoSupplier {
    public static int method(Supplier<Integer> sup){//接口就是一个计算器，重写其中方法来编写计算的规则
        return sup.get();//supplier接口中的get方法返回的就是一个整数，所以可以return sup.get()
    }

    public static void main(String[] args) {
        int[] arr = {123,442,-23,-13,0,1514};

        int value = method(() -> {
            int max = arr[0];//必须把max的赋值提到局部方法里来，这样才能对max的值进行修改
            for (int i : arr) {//增强for循环对数组中的每一个数进行遍历
                if (i > max) {
                    max = i;//只有max在局部内声明时才可以更改max的值，要是max在for循环外面声明的话，则此时改变其值将会报错
                }
            }
            return max;
        });
        System.out.println(value);
    }
}
