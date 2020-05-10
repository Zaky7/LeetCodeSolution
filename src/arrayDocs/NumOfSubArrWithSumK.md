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

- An efficient solution is while traversing the array, store sum so far in currsum.
- Also maintain count of different values of currsum in a map. If value of currsum is equal to desired sum at any instance increment count of subarrays by one or the value of currsum exceeds desired sum by currsum – sum.
- From the map find number of subarrays previously found having sum equal to currsum-sum. Excluding all those subarrays from current subarray, gives new subarrays having desired sum. So increase count by the number of such subarrays.
- Note that when currsum is equal to desired sum then also check number of subarrays previously having sum equal to 0. Excluding those subarrays from current subarray gives new subarrays having desired sum. Increase count by the number of subarrays having sum 0 in that case.

### PseudoCode

```html
- We can create a Hashap of Integers. - Iterate over the array and calc the
current sum of element - If current sum equals k then increment the count - Also
check if current sum - k present in HashMap if present update the value of
result count with value in Map - Also check if current sum present in HashMap if
present then add the value of Key in count else set key to current_sum and value
= 1
```

#### [[Code]](../array/NumOfSubArrWithSumK.java)
