package algorithm.sort;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args) {

        int arr[] = {-9,0,0,23,4,0};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int arr[],int left,int right){
        int l = left;
        int r= right;
        int pivot = arr[(left+right)/2];
        int temp = 0;
        while(l < r){
            while (arr[l]< pivot){
                l++;
            }
            while (arr[r]>pivot){
                r--;
            }
            if (l == r){
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] ==  pivot){
                r--;
            }
            if (arr[r] == pivot){
                l++;
            }


        }
        if (l == r){
            l++;
            r--;
        }
        if (left < r){
            quickSort(arr,left,r);
        }
        if (right > l){
            quickSort(arr,l,right);
        }
    }
}
