package algorithm;

public class ViolenceMatch {
    public static void main(String[] args) {
        String s1 = "23456";
        String s2 = "24356";
        int match = match(s1, s2);
        System.out.println(match);
    }
    public static int match(String s1, String s2){
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        int i = 0;
        int j = 0;
        while (i < len1 && j < len2){
            if (arr1[i] == arr2[j]){
                i++;
                j++;
            }else {
                i = i - (j-1);
                j = 0;
            }
        }
        if ( j == len2){
            return i - j;
        }else {
            return -1;
        }
    }
}
