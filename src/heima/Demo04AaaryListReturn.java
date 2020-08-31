package heima;


import java.util.ArrayList;
import java.util.Random;

/*
    题目：
    用一个大集合存入20个随机数字，然后筛选其中的偶数数字，放入小集合当中
    要求使用自定义的方法来实现筛选
 */
public class Demo04AaaryListReturn {
//    public static void main(String[] args) {
//        ArrayList<Integer> BigList = new ArrayList<>();
//        Random r = new Random();
//        for (int i = 0; i <20 ; i++) {
//           int num = r.nextInt(200);
//           BigList.add(num);
////            System.out.println(num);
////            System.out.println("-----------------------------");
////            shaiXuan(BigList);
//            ArrayList<Integer> LittleList = shaiXuan(BigList);
//            for (int i1 = 0; i1 < LittleList.size(); i1++) {
//                System.out.println(LittleList.get(i));
//            }
//        }
//    }
////    public static void shaiXuan(ArrayList<Integer> Biglist){
////        ArrayList<Integer> LittleList = new ArrayList<>();
////        for (int i = 0; i <20 ; i++) {
////            if (Biglist.get(i) % 2 ==0){
////                LittleList.add(Biglist.get(i));
////                System.out.println(LittleList.get(i));
////            }
////
////        }
////
////    }
//public static ArrayList<Integer> shaiXuan(ArrayList<Integer> Biglist){
//    ArrayList<Integer> LittleList = new ArrayList<>();
//    for (int i = 0; i <Biglist.size() ; i++) {
//        int num = Biglist.get(i);
//        if (num % 2 == 0){
//            LittleList.add(num);
//
//        }
//
//    }
//    return LittleList;//int num,就return num   ArrayList<Integer> list,就return list
//}


    public static void main(String[] args) {
        ArrayList<Integer> biglist = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int num = r.nextInt(100);
            biglist.add(num);
        }
        ArrayList<Integer> smallList = getSmallList(biglist);
        System.out.println(biglist);
        System.out.println(smallList);
    }
    public static ArrayList<Integer> getSmallList(ArrayList<Integer> list){
        ArrayList<Integer> smalllist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if(num % 2 == 0){
                smalllist.add(num);
            }
        }
        return smalllist;
    }
}
