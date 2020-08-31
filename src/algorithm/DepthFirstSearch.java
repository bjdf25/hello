package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepthFirstSearch {
    int map[][];
    boolean isVisited[];
    private ArrayList<String> vertexList;
    public static void main(String[] args) {
        DepthFirstSearch dfs = new DepthFirstSearch(5);
        dfs.insert(0,1);
        dfs.insert(0,2);
        dfs.insert(1,2);
        dfs.insert(1,3);
        dfs.insert(1,4);
        dfs.show();
        String vertexs[] = {"A","B","C","D","E"};
        for (String vertex : vertexs) {
            dfs.insertVertex(vertex);
        }
        dfs.dfs();
    }

    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (map[index][i] > 0){
                return i;
            }
        }
        return -1;
    }
    public int getNextNeighbor(int v1,int v2){
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (map[v1][i] > 0){
                return i;
            }
        }
        return -1;
    }
    public void dfs(boolean isVisited[], int i){
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1){
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            w = getNextNeighbor(i,w);
        }

    }
    public void dfs(){
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    public DepthFirstSearch(int n){
        map = new int[n][n];
        isVisited = new boolean[n];
        vertexList = new ArrayList<>(n);
    }
    public void show(){
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }
    }
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    public void insert(int v1,int v2){
        map[v1][v2] = 1;
        map[v2][v1] = 1;
    }
}
