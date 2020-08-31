package Lambda;

import java.util.Arrays;
import java.util.Comparator;

/*
    Array数值中的方法sort   前面-后面为升序，后面-前面为降序
 */
public class DemoComparator {

    public static Comparator<String> getComparator(){//这个方法本质是一个比较器，重写的内容就是对比较器的功能进行修改
//        return new Comparator<String>() {//返回值为一个泛型为String类型的Comparator接口对象，所以返回的就是new的comparator对象
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.length()-o1.length();//因为是String类型的数据，要比较长度就要.length()
//            }
//        };
        return (o1,o2)->o2.length()-o1.length();//可以用lambda函数进行简化
        //lambda函数一般是对new Interface开始进行覆盖
    }

    public static void main(String[] args) {
        String[] str = {"aaa","vv","asdqxzc","saca"};
        System.out.println(Arrays.toString(str));//要想把数组内容打印到控制台上就要用Arrays类的静态方法toString
        //调用Arrays类的方法sort对数组进行排序，
        Arrays.sort(str,getComparator());//sort参数里先传递要进行排序的数组，再传递一个Comparator比较器，getComparator方法返回的就是一个比较器
        //System.out.println(str.toString());//这是输出String类对象str本身，所以打印的str的地址
        System.out.println(Arrays.toString(str));
    }
}
