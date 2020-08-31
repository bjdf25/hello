import java.util.*;

public class test {
    public static void main(String[] args) {
//        Date date = new Date();
//        System.out.println(date);
//        System.out.println(date);
//        HashMap<String, String> map = new HashMap<String, String>();
//        System.out.println(map);
        String a = "a b c de f";
//        String substring = a.substring(1,3);
//        System.out.println(substring);
//        String[] split = a.split(" ",2);
//        System.out.println(Arrays.toString(split));
//        System.out.println(solution("abcdefg",2));
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        listNode1.next = listNode2;
//        ListNode end = getKthFromEnd(listNode1, 2);
//        System.out.println(end);
//        int arr[] = {1,1,1,2,1};
//        int pairs = findPairs(arr, 1);
//        System.out.println(pairs);
//        Object
//        System.out.println();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        List<Integer> list = new LinkedList<>();
        String asd = "asd";
        String arr[] = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String arr2[] = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        System.out.println(Arrays.toString(findRestaurant(arr,arr2)));


    }


    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (!map.containsKey(i + j)) {
                        map.put(i + j, new ArrayList<String>());
                    }
                    map.get(i + j).add(list1[i]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            res = Math.min(res, key);
        }
        String arr[] = new String[map.get(res).size()];
        return map.get(res).toArray(arr);
    }
    public static String solution(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            builder.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            builder.append(s.charAt(i));
        }
        return builder.toString();

    }

    public static int[] printNumbers(int n) {
        int arr[] = new int[(int) (Math.pow(10, n) - 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            ListNode cur = head;
            int count = 0;
            while (head != null) {
                count++;
                head = head.next;
            }

            for (int i = 0; i < count - k; i++) {
                cur = cur.next;

            }
            return cur;
        }
    public static int findPairs(int[] nums, int k) {
        int count = 0;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            for(int j = i+1; j < nums.length;j++){
                if(map.containsKey(nums[j])){
                    continue;
                }
                if(Math.abs(nums[i] - nums[j]) == k){
                    map.put(nums[j],0);
                    count++;
                }
            }
        }
        return count;
    }
    public int find1Pairs(int[] nums, int k) {
        int count = 0;
        if (k < 0) return count;
        Set<Set<Integer>> set = new HashSet<>();
        Set<Integer> s1 = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (Math.abs(nums[i] - nums[j]) == k) {
                    s1.add(nums[i]);
                    s1.add(nums[j]);
                    if (!set.contains(s1)) {
                        set.add(s1);
                        count++;
                    }

                }
            }
        }
        return count;
    }
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null || r * c != nums.length * nums[0].length){
            return nums;
        }
        int res[][] = new int [r][c];
        int row = 0,col = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j <nums[0].length;j++){
                res[row][col] = nums[i][j];
                col++;
                if(col == c - 1){
                    row++;
                    col = 0;
                }
            }
        }
        return res;
    }
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for(char c: S.toCharArray()){
            if(sbLength != 0 && c == sb.charAt(sbLength -1)){
                sb.deleteCharAt(sb.charAt(sbLength-- - 1));
            }else{
                sb.append(c);
                sbLength++;
            }
        }
        return sb.toString();
    }
    }
