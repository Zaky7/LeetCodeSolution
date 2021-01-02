# Min Cost Climbing Stairs

On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.


## Example 1:

```
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
```

<br>

## PseudoCode

In order to solve this problem. we need to think **backward** because if we think forward it is not certain which step to take **step + 1** or **step + 2**.


At step = n-1. We are already at top know we need to spend 0 <br>
At step = n-2. Since we are one step away from top we need to spend cost[n-2]
At step = n-3. We need to decide b/w minimum of n-2, n-1.

```java
We can create a dp array of size = n <br>
> dp[n-1] = cost[n-1] and dp[n-2] = cost[n-2];


for i = n-3 to 0:
 dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);

minCost = Math.min(dp[0], dp[1]);
```


