package dynamicProgramming;

class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] minUniqueSum = new int[row][col];


        minUniqueSum[0][0] = grid[0][0];

        // Fill the first column
        for (int i = 1; i < col; i++) {
            minUniqueSum[0][i] = grid[0][i] + minUniqueSum[0][i - 1];
        }

        // Fill the first row
        for (int i = 1; i < row; i++) {
            minUniqueSum[i][0] = grid[i][0] + minUniqueSum[i - 1][0];
        }

        // Fill the remaining boxes
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                minUniqueSum[i][j] = Math.min(minUniqueSum[i][j - 1], minUniqueSum[i - 1][j]) + grid[i][j];
            }
        }

        return minUniqueSum[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1}, {4,2,1}};
        MinimumPathSum mp = new MinimumPathSum();

        int minSum = mp.minPathSum(grid);

        System.out.println(minSum);
    }
}