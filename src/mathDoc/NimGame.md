# Nim Game

First naive solution of the problem is was given using recursion

For a value of n the result whether Nim would win or not depedends on subproblems

> f(n) = f(n-1) + f(n-2) + f(n-3);

Either Nim would take 1 stones or 2 or 3. Now we can easily solve it using recursive like below

### 1. Recursive Approach O(n)

```java
public boolean canWinNim(int n) {
    // base case
    if(n == 0) {
        return false; 
    } else if(n > 0 && n < 4) {
        // 1, 2, 3
        return true;
    } else {
        return canWinNim(n-1) || canWinNim(n-2) || canWinNim(n-3);
    }
 }
```

### 2. Using Dp Time: O(n),   Space: O(n)

Create a 2D array of n rows and 2 columns. Column 0 denote otherFriend win and Column 1 denotes Nims Win.

``` java
 public boolean canWinNim(int n) {
        boolean[][] dp = create2DWinArr(n);
        return isWin(n, dp);
    }
    
    private boolean[][] create2DWinArr(int n) {
        boolean[][] dp = new boolean[n+1][2];
        // Add entires
        dp[0][0] = true;
        dp[0][1] = false;
        

        dp[1][0] = false;
        dp[1][1] = true;

        dp[2][0] = false;
        dp[2][1] = true;
        
        dp[3][0] = false;
        dp[3][1] = true;
        return dp;
    }
    
    private boolean isWin(int n, boolean[][] dp) {
        // starting from n = 4
        for(int i=4; i<=n; i++) {            
            boolean isNimWin = dp[i-1][0] || dp[i-2][0] || dp[i-3][0];             
            dp[i][1] = isNimWin;
            dp[i][0] = !isNimWin;
        }
                
        return dp[n][1];
    }
```

### 3. Using Dp space Optimized: O(n), Space: O(1)

Create a 2D array of n rows and 2 columns. Column 0 denote otherFriend win and Column 1 denotes Nims Win.

``` java
  public boolean canWinNim(int n) {
        // boolean[][] dp = create2DWinArr(n);
        // boolean result = isWin(n, dp);
        // System.out.println("For n: " + n + " result: " + result);
        return n % DP_SIZE == 0 ? false : true;
    }
    
    private boolean[][] create2DWinArr(int n) {
        boolean[][] dp = new boolean[DP_SIZE][2];
        // Add entires
        dp[0][0] = true;
        dp[0][1] = false;
        

        dp[1][0] = false;
        dp[1][1] = true;

        dp[2][0] = false;
        dp[2][1] = true;
        
        dp[3][0] = false;
        dp[3][1] = true;
        return dp;
    }
    
    private int findNormalizedIndex(int n) {
        return n % DP_SIZE;
    }
    
    private boolean isWin(int n, boolean[][] dp) {
        // starting from n = 4
        for(int i=DP_SIZE; i<=n; i++) {
            int index1 = findNormalizedIndex(i-1);
            int index2 = findNormalizedIndex(i-2);
            int index3 = findNormalizedIndex(i-3);
            
            boolean isNimWin = dp[index1][0] || dp[index2][0] || dp[index3][0]; 
            
            int index = findNormalizedIndex(i);
            
            dp[index][1] = isNimWin;
            dp[index][0] = !isNimWin;
        }
        
        
        int indexInArr = findNormalizedIndex(n);
        
        return dp[indexInArr][1];
    }
```


### 4. Recognizing pattern :)  O(1)

```
n 0 1 2 3
  F T T T

n 4 5 6 7
  F T T T

n 8 9 10 11
  F T T  T

Multiples of 4 are always false
```


###### Solution:


```java
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    } 
```