package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        HashSet<String> K1 = new HashSet<>();
        K1.add("北京");
        K1.add("上海");
        K1.add("天津");
        HashSet<String> K2 = new HashSet<>();
        K2.add("广州");
        K2.add("北京");
        K2.add("深圳");
        HashSet<String> K3 = new HashSet<>();
        K3.add("成都");
        K3.add("上海");
        K3.add("杭州");
        HashSet<String> K4 = new HashSet<>();
        K4.add("上海");
        K4.add("天津");
        HashSet<String> K5 = new HashSet<>();
        K5.add("杭州");
        K5.add("大连");
        broadcasts.put("K1",K1);
        broadcasts.put("K2",K2);
        broadcasts.put("K3",K3);
        broadcasts.put("K4",K4);
        broadcasts.put("K5",K5);

        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        ArrayList<String> selects = new ArrayList<>();

        HashSet<String> tempSet = new HashSet<>();

        String maxKey = null;
        while (allAreas.size() != 0){
            maxKey = null;//每次选取新的K的时候必须把maxKey清空，不然有可能这一轮的maxKey都比上一轮的maxKey小
            for (String key : broadcasts.keySet()) {
                tempSet.clear();//对key的每一次遍历之前都要把临时Set给清空才能把broadcasts.get(key)给tempSet，然后再取交集
                HashSet<String> area = broadcasts.get(key);
                tempSet.addAll(area);
                tempSet.retainAll(allAreas);
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size()) ){
                    maxKey = key;//第一轮maxKey为null所以直接把当前key赋值为最大key，在下一轮的遍历中就看当轮的tempSet大还是maxKey的set大
                }
            }
            if (maxKey != null){
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));//注意remove是删除对象里的一个，removeAll是把当前对象里面的全部删掉
            }
        }
        System.out.println(selects);
    }
}
