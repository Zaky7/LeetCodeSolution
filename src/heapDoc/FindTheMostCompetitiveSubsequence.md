# Most competitive Subsequence

Given an integer array nums and a positive integer k, return the **most competitive subsequence** of nums of size k.

An array's subsequence is a resulting sequence obtained by erasing some (possibly zero) elements from the array.

We define that a subsequence a is more competitive than a subsequence b (of the same length) if in the first position where a and b differ, subsequence a has a number less than the corresponding number in b. For example, [1,3,4] is more competitive than [1,3,5] because the first position they differ is at the final number, and 4 is less than 5.



```
Input: nums = [3,5,2,6], k = 2
Output: [2,6]
Explanation: Among the set of every possible subsequence: {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]}, [2,6] is the most competitive.
```

## Solution

- In order to solve the problem we need to create an another array `result` of size k. We would take a pointer `ptr` denoting index  in the result array where we need to change the element from the original array

- Now we iterate over the nums array and keep elements in the result array until ptr < k.

- Also we need to make sure if ptr > 0 and last element in the result array is greater than current element in the nums array and there k or more than k elements left to processed. we would decrement the pointer.

- At last our result array would contain the **Most Competitive subsequence**