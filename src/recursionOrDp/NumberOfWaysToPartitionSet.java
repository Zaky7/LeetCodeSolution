package recursionOrDp;

import static java.lang.System.out;

public class NumberOfWaysToPartitionSet {

    /**
     *
     * @param n
     * @return number of non-empty partition for a given number
     */
    public int partitionCount(int n) {
        int[] partitions = new int[n+1];

        partitions[0] = 1;

        for(int i=1; i<=n; i++) {
            int numberOfPartition = 0;

            for(int j=0; j<i; j++) {
                numberOfPartition += (combination(i-1, j) * partitions[j]);
            }

            out.println(numberOfPartition + " ");

            partitions[i] = numberOfPartition;
        }

        return partitions[n];
    }


    /**
     *
     * @param n
     * @return factorial of a given number n
     */
    private int factorial(int n) {
        int[] fact = new int[n+1];

        if(n == 0 || n == 1) {
            return 1;
        }

        fact[0] = 1;
        fact[1] = 1;

        for(int i = 2; i <= n; i++) {
           fact[i] = i * fact[i-1];
        }

        return fact[n];
    }


    /**
     *
     * @param n
     * @param k
     * @return combination of a given n and k
     */
    private int combination(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n-k));
    }

    public static void main(String[] args) {

        NumberOfWaysToPartitionSet nws = new NumberOfWaysToPartitionSet();
        nws.partitionCount(9);
    }
}
