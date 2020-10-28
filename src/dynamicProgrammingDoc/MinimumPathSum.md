# [Min Sum Path](https://leetcode.com/problems/minimum-path-sum/)


<p style="font-size: 18px; font-family:  Arial, Helvetica, sans-serif;">
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
</p>
<p>Note: You can only move either down or right at any point in time.
</p>

```java
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.


```


## Solution



#### Pseducode

- At any position in the cell its value depends on the previous path (from left and top).

- We need to create a dp array of size m * n storing the value of min path sum.

- First we fill the first row of the newly created array.

```java

for eg. arr = [[1, 2, 3]]

since grid contains only 1 row we can only move in one direction

therefore we create newly dp array as follows

dp = [[1, 3, 5]]

result = 5

// Code
for (int i = 1; i < row; i++) {
    minUniqueSum[i][0] = grid[i][0] + minUniqueSum[i - 1][0];
}

````


- Similarly we fill the first column of the newly created array.

```java

for eg. arr =
[
  [1],
  [2],
  [3]
]

since grid contains only 1 row we can only move in one direction

therefore we create newly dp array as follows

dp = [
  [1],
  [3],
  [6]
]

result = 6

// Code
// Fill the first column
for (int i = 1; i < col; i++) {
    minUniqueSum[0][i] = grid[0][i] + minUniqueSum[0][i - 1];
}

````

- for the remaining array elemnts we use the formulate below

##### Code

```java
minUniqueSum[i][j] = Math.min(minUniqueSum[i][j - 1], minUniqueSum[i - 1][j]) + grid[i][j];
```

```java

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

```



