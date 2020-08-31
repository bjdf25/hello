package algorithm.sort;

import java.util.Arrays;

public class RedixSort {
    public static void main(String[] args) {
        int arr[] = {12,34,253,125,2314,5654,567,45,453,};
        redixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void redixSort(int arr[]){
        //0.先求出数组中最大数据的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>max){
                max = arr[i];
            }

        }
        int maxNum = (max+"").length();
        int Bucket[][] = new int[10][arr.length];
        int BucketConts[] = new int[10];
        for (int k = 0 , n = 1; k < maxNum; k++, n *= 10) {//最大位有多少位就遍历多少次
            //1.先把个位数放到相应的桶中
            //对于bucketConts，{1，4，0，8，4，5，1，3，4，7}对应每个桶的数据个数

            for (int i = 0; i < arr.length; i++) {//遍历数组中每一个数
                int digitOfElement = arr[i]/n % 10;
                Bucket[digitOfElement][BucketConts[digitOfElement]] = arr[i];//BucketConts[digitofElement]数组最初为0
                BucketConts[digitOfElement]++;
            }
            //2.再把桶中数据取到数组arr中
            int index = 0;//对于每一个桶需要一个索引进行遍历,每个桶的数据总共有bucketconts个
            for (int i = 0; i < 10; i++) {//遍历每一个桶
                if (BucketConts[i] != 0){//当i=0时表明当编号为0的桶里的数据个数为0时就不用放到数组里了
                    for (int j = 0; j < BucketConts[i]; j++) {//遍历每一个桶中的数据,遍历的次数应该为桶中的数据个数
                        //取出元素放到arr
                        arr[index] = Bucket[i][j];//第i个桶的第j个数据放到数组arr[i]中
                        index++;
                    }

                }
                BucketConts[i] = 0;//取出数据后把每个桶的数据置0
            }
        }


    }

}
