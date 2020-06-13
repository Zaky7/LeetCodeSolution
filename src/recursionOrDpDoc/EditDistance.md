# [Edit Distance](https://leetcode.com/problems/edit-distance/solution/)

Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

```java
    Input: word1 = "horse", word2 = "ros"
    Output: 3
    Explanation: 
    horse -> rorse (replace 'h' with 'r')
    rorse -> rose (remove 'r')
    rose -> ros (remove 'e')
```

### Pseudocode

- If last two characters are same then there nothing much to do. So we recur for length (m - 1) and (n - 1);

- Else consider all there operation (Insert, Remove, Replace) on the last character of first string and compute minimum operation of 3 values


### 1. Recursive Solution

```java

public static int editDist(String str1, String str2, int m, int n) 
    { 
        // if one of the strings is empty
        if(n * m == 0) {
            return n + m;
        }
            
        if(str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return editDist(str1, str2, m - 1, n - 1); 
        } 
 
        // minimum of three values. 
        return 1 + min(
            editDist(str1, str2, m, n - 1), 
            editDist(str1, str2, m - 1, n),  
            editDist(str1, str2, m - 1, n - 1)
          ); 
    }
```


### 2. Dp Solution

```java

 public int minDistanceDp(String word1, String word2) {
        int R = word1.length();
        int C = word2.length();

        int[][] dp = new int[R+1][C+1];

        for(int i=0; i<=R; i++) {
            dp[i][0] = i;
        }

        for(int j=0;  j<=C; j++) {
            dp[0][j] = j;
        }

        for(int i=1; i<=R; i++) {
            for(int j=1; j<=C; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }

        return dp[R][C];
    }
```


### 3. Dp Solution with memory optimised 🙄 Caveat

⚠️ Not memory efficient!!! consumes more memory than previous one

```java
public int minDistanceDpMemoryOptimisedFake(String word1, String word2) {
        int R = word1.length();
        int C = word2.length();
        int[][] dp = new int[ROW][C+1];

        for(int j=0;  j<=C; j++) {
            dp[0][j] = j;
        }

        for(int i=1; i<=R; i++) {
            dp[computeRow(i)][0] = i;
            for(int j=1; j<=C; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[computeRow(i)][j] = dp[computeRow(i-1)][j-1];
                } else {
                    dp[computeRow(i)][j] = 1 + Math.min(
                            dp[computeRow(i-1)][j-1],
                            Math.min(dp[computeRow(i-1)][j], dp[computeRow(i)][j-1]));
                }
            }
        }

        return dp[computeRow(R)][C];
    }
```


