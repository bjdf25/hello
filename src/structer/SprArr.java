package structer;

public class SprArr {

    public static void main(String[] args) {
        int chess[][] = new int[11][11];
        int sum = 0;
        chess[1][2] = 1;
        chess[2][3] = 2;
        chess[3][3] = 2;
        chess[3][2] = 2;
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(chess[i][j] + " ");
                if (chess[i][j] != 0){
                    sum++;
                }
            }
            System.out.println();
        }
//        System.out.println(sum);
        int SprArr[][] = new int[sum + 1][3];
        SprArr[0][0] = 11;
        SprArr[0][1] = 11;
        SprArr[0][2] = sum;
        int count = 0;
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < 11; j++) {
                if (chess[i][j] != 0){
                    count++;
                    SprArr[count][0] = i;
                    SprArr[count][1] = j;
                    SprArr[count][2] = chess[i][j];
                }

            }
        }

        for (int i = 0; i < SprArr.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(SprArr[i][j] + "   ");
            }
            System.out.println();
        }


        int chess2 [][] = new int[SprArr[0][0]][SprArr[0][1]];

        for (int i = 1; i < SprArr.length; i++) {
            chess2[SprArr[i][0]][SprArr[i][1]] = SprArr[i][2];

        }
        for (int[] ints : chess2) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }
    }
    
    
}
