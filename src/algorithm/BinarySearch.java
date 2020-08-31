package algorithm;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {2,23,26,27,231,267,453,7743,43246};
        int index = findIndex(arr, 0,0,arr.length-1);
        System.out.println(index);
    }
    public static int findIndex(int arr[], int value, int low, int high){
        int mid = (low + high) / 2;
        while (low <= high){
            if (arr[mid] == value){
                return mid;
            }else if (value < arr[mid]){
                return findIndex(arr,value,0,mid-1);
            }else {
                return findIndex(arr,value,mid+1,high);
            }
        }
        return -1;
    }
}
