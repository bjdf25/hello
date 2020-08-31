package algorithm;

public class MiGong {

    public static void main(String[] args) {
        int map [][] = new int[8][7];
        for (int i = 0; i < 8; i++) {
            for (int i1 = 0; i1 < 7; i1++) {
                if (i == 0 || i == 7){
                    map[i][i1] = 1;
                }
                if (i1 == 0 || i1 == 6){
                    map[i][i1] = 1;
                }
            }
        }
        map[3][1] = 1;
        map[3][2] = 1;
        setWay(map,1,1);
        for (int[] ints : map) {
            for (int i : ints) {
                System.out.print(i+"  ");
            }
            System.out.println("");
        }

    }
    public static boolean setWay(int map[][], int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }else {
            if (map[i][j] == 0){
                map[i][j] = 2;
                if (setWay(map,i+1,j)){
                    return true;
                }else if(setWay(map,i,j+1)){
                    return true;
                }else if (setWay(map,i-1,j)){
                    return true;
                }else if (setWay(map,i,j-1)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }

}
