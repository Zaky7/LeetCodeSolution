package dynamicProgramming;

class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        dp[n-1] = cost[n-1];
        dp[n-2] = cost[n-2];

        for(int i=n-3; i>=0; i--) {
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }

        return Math.min(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        MinCostClimbingStairs mcs = new MinCostClimbingStairs();
        int minCost = mcs.minCostClimbingStairs(arr);
    }
}