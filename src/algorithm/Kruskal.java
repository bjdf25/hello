package algorithm;

import java.util.Arrays;

public class Kruskal {
    private int edgeNum;//边的条数
    private char[] vertexs;//顶点数组
    private int[][] martrix;//图用邻接矩阵表示
    private static final int INF = Integer.MAX_VALUE;//表明两个顶点之间不能连通

    public static void main(String[] args) {
        char []vertexs = {'A','B','C','D','E','F','G'};
        int [][]martrix = {//A到G之间的邻接矩阵
                {0,  12,  INF,  INF,  INF,  16,  14},
                {12,  0,  10,   INF,  INF,  7,   INF},
                {INF, 10,  0,   3,    5,    6,   INF},
                {INF, INF, 3,   0,    4,   INF,  INF},
                {INF, INF, 5,   4,    0,    2,    8},
                {16,   7,  6,   INF,  2,    0,    9},
                {14,  INF, INF, INF,  8,    9,    0}
        };
        Kruskal kruskal = new Kruskal(vertexs,martrix);
        //测试得出总边数的数组
        EDate[] edges = kruskal.getEdges();
        kruskal.sort(edges);
        System.out.println(Arrays.toString(edges));
        kruskal.kruskal();
    }

    public Kruskal(char[] vertexs, int[][] martrix) {
        this.vertexs = vertexs;
        this.martrix = martrix;
        //遍历邻接矩阵统计边的条数
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {//令j=i+1就不再遍历之前遍历过的边数以及顶点与自身之间距离为0的边数
                if (martrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }
    //打印邻接矩阵的方法
    public void print(){
        for (int[] ints : martrix) {
            System.out.println(Arrays.toString(ints));
            System.out.println();
        }
    }
    //对边进行排序的方法
    public void sort(EDate[] edges){
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j+1].weight){
                    EDate temp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = temp;
                }
            }
        }
    }
    //创建一个返回顶点所对应的下标，找不到就返回-1的方法
    public int getPosition(char ch){
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch){
                return i;
            }
        }
        return -1;
    }
    //将所取得的边放到一个EDate[]数组中
    public EDate[] getEdges(){
        int index = 0;
        EDate[] edges = new EDate[edgeNum];//数组大小就是边的总条数
        //遍历邻接矩阵
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {//j = i + 1就不再遍历自身与之前遍历过的边数
                if (martrix[i][j] != INF){
                    edges[index++] = new EDate(vertexs[i],vertexs[j],martrix[i][j]);//起点就是横排，终点就是竖排
                }
            }
        }
        return edges;
    }
    //创建一个找到当前结点的最终终点的下标的方法
    public int getEnd(int i, int []ends){
        while(ends[i] != 0){//进来的点会一直不停的在ends数组里找自己的最终终点，自己最终终点的终点就是0，ends[i]表示i的终点
            i = ends[i];//如果终点不等于0说明不是最终终点，把自己变为这次终点的下标继续寻找最终终点
        }
        return i;//最终终点的下标
    }
    public void kruskal(){
        int index = 0;
        int ends[] = new int[edgeNum];//用于保存已有最小生成树中的每个顶点在最小生成树中的终点
        EDate[] result = new EDate[edgeNum];//存放最小生成树的数组
        EDate[] edges = getEdges();//拿到所有的边数
        sort(edges);//对edges从小到大排序
        //遍历edges数组，将边加入到最小生成树中，判断该边的加入是否形成回路，如果没有就加入到result最小生成树中
        for (int i = 0; i < edgeNum; i++) {
            int p1 = getPosition(edges[i].start);//第i条边的起点所对应的下标
            int p2 = getPosition(edges[i].end);//第i条边的终点所对应的下标
            int m = getEnd(p1,ends);//一开始传进数组ends中每个点的终点都是自己
            int n = getEnd(p2,ends);//所以最开始的时候m和n的终点不一样，不构成回路就可以加入到最小生成树中
            //判断n和m是否构成回路，即n和m的终点是否一样
            if (m != n){//没有构成回路
                ends[m] = n;//加入到最小生成树后把ends数组中m所对应的终点改为n
                result[index++] = edges[i];//把当前边加入到最小生成树
            }
        }
        //打印最小生成树
        System.out.println(Arrays.toString(result));

    }
    //创建一个类，类的实例化对象表示一条边，有这条边的start和end，还有权值weight
    class EDate{
        char start;
        char end;
        int weight;
        public EDate(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "{" +
                    "<" + start +
                    "," + end +
                    "> =" + weight +
                    '}';
        }
    }
}
