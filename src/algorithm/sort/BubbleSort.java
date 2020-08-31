package algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        bubbleSort(arr);
    }

    public static void bubbleSort(int arr[]){
        int temp = 0;
        for(int i = 0;i < arr.length - 1;i++){
            boolean flag = false;
            for(int j = 0;j < arr.length - 1 -i;j++){
                if(arr[j]>arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
            System.out.println("第"+(i+1)+"趟排序结果");
            System.out.println(Arrays.toString(arr));
            if(flag == false){
                break;
            }else {
                flag = false;
            }
        }
    }
}
