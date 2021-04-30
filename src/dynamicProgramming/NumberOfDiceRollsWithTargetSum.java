package dynamicProgramming;

import java.util.Deque;
import java.util.LinkedList;

class NumberOfDiceRollsWithTargetSum {

    public long findWays(int f, int d, int T){
        long[][] table = new long[d+1][T+1];

        /* Table entries for only one dice */
        for(int j = 1; j <= f && j <= T; j++)
            table[1][j] = 1;


        for(int i = 2; i <= d;i ++){
            for(int j = 1; j <= T; j++){
                for(int k = 1; k < j && k <= f; k++)
                    table[i][j] += table[i-1][j-k];
            }
        }

        for(int i = 0; i< d+1; i++){
            for(int j = 0; j< T+1; j++)
                System.out.print(table[i][j] + " ");
            System.out.println();
        }

        return table[d][T];
    }

    public static void main(String[] args) {
        int f = 5, d= 2, T = 10;
        NumberOfDiceRollsWithTargetSum nr = new NumberOfDiceRollsWithTargetSum();
        int ways = (int) nr.findWays(f,d,T);
        System.out.println("Ways: " + ways);


        Deque<Integer> queue = new LinkedList<>();

    }
}