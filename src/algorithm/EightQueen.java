package algorithm;

public class EightQueen {

    int chess[] = new int[8];

    public static void main(String[] args) {
        EightQueen eq = new EightQueen();
        eq.chess(0);
    }
    public void chess(int n){
        if ( n == 8){
            print();
            System.out.println("");
            return;
        }
        for (int i = 0; i < 8; i++) {
            chess[n] = i;
            if(judge(n)){
                chess(n+1);
            }
        }
    }

    private void print() {

        for (int i : chess) {
            System.out.print(i+"  ");
        }

    }

    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (chess[i] == chess[n] || Math.abs(n-i) == Math.abs(chess[n] - chess[i])){
                return false;
            }
        }
        return true;
    }
}
