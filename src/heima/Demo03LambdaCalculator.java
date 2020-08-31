package heima;
/*
    lambda表达式有参数有返回值的练习
    需求：
        给定一个计算器接口Calculator接口，内含抽象方法calc可以将两个int数字相加得到和值
        使用Lambda的标准格式调用invokeCalc方法，完成120和130的相加计算

 */
public class Demo03LambdaCalculator {

    public static void main(String[] args) {
        //Calculator接口只是一个实现计算功能的方法，当调用invokeCalc方法时只需要在参数中输入想相加的值，并且选定计算器即可
        //同时invokeCalc方法还需要输出计算结果
//    invokeCalc(10, 20, new Calculator() {
//        @Override
//        public int calc(int a, int b) {
//            return a +b;
//        }
//    });
        invokeCalc(2,5,(a,b)->a*b);

    }
    public static void invokeCalc(int a,int b,Calculator c){
        int result = c.calc(a,b);
        System.out.println(result);
    }

}


