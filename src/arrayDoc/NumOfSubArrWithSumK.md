# [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

```java
Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
```

Note:
The length of the array is in range **[1, 20,000]**.
The range of numbers in the array is **[-1000, 1000]** and the range of the integer k is **[-1e7, 1e7]**.

##### Brute Force

Iterate over all the subArrays and check if the sum is equal to K then increment the result Count

> Time Complexity O(n^2) Space Complexity O(1)

```java
 private int subarraySumIterative(int[] nums, int k) {
        int n = nums.length;
        int subArrSumEqlK = 0;

        for(int start=0; start<n; start++) {
            int sum = 0;
            for(int subArraySize=1; subArraySize<=n; subArraySize++) {
                if((start + subArraySize) > n) {
                    break;
                }

                // Add the last element in currentSubArray
                sum+=nums[start+subArraySize-1];

                if(sum == k) {
                    subArrSumEqlK++;
                }
            }
        }

        return subArrSumEqlK;
    }
```

## Efficent Solution.

<pre>

<strong>
T(n): O(n)
S(n): O(n)
</strong>
- Take a variable subArrayWithSumk = 0 and currSum = 0
- Now iterate over the array and add each element in currSum.
- if currSum == k: 
     Increment the subArrayWithSumK value
- Also if map contains (currsum - k) value then we would also:
     Increment the subArrayWithSumK value
- Now check if currSum is present in the map <br>
  if present then:
        preSumMap.put(curr_sum, 1); <br>
  else:
        preSumMap.put(curr_sum, count + 1);
</pre>

#### [[Code]](../array/NumOfSubArrWithSumK.java)
