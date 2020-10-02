# [CombinationSum](https://leetcode.com/problems/combination-sum/)

<p style="font-size: 18px; font-family:  Arial, Helvetica, sans-serif;">
Given an array of <strong>distinct integers</strong> candidates and a <strong>target</strong> integer, return a list of all <strong>unique combinations</strong> of candidates where the chosen numbers sum to <strong> target</strong>. You may <strong>return the combinations in any order</strong>.
</p>

<p style="font-size: 18px; font-family:  Arial, Helvetica, sans-serif;">
The <strong>same number</strong> may be chosen from candidates an <strong>unlimited</strong> number of times. Two combinations are <strong>unique</strong> if the frequency of at least one of the chosen numbers is different.
</p>

## Solution

<pre>

# Pseducode

1. Take variables as follows start= 0 marking begin of for loop, currentSum = 0 denoting the current sum, temp = [] for storing numbers temporarily and result = [[]] array of storing temp arrays consisting of sum == target

2. Start from i = 0 and recursively add the num from the array to the current sum and also add tem to temp array

3. if currentSum == targetSum:
    result.add(new ArrayList<>(temp));
    temp = new ArrayList<>();
    currentSum = 0;
   else if currentSum == targetSum:
    return;
   else:
     for(i = start; i< arr.length; i++) {
        currentSum += num[i];
        temp.add(num[i]);

        // calling recursively
        combinationSumUtil(i, num, temp, result, currentSum, targetSum)

        // backtracking
        currentSum -= num[i];
        temp.remove(temp.size() - 1)
     }


For eg.

Suppose the array is

arr: [2, 3] & target = 8, n = 3


start  i   currentSum   temp      result   currentSum > targetSum
 0     0      2          2         []                       false
 0     0      4          2,2       []                       false
 0     0      6          2,2,2     []                       false
 0     0      8          2,2,2,2   []                       false
 0     0      6          2,2,2     [[2,2,2,2]]              false
 0     1      9          2,2,2,3   [[2,2,2,2]]              true
 0     1      6          2,2,2     [[2,2,2,2]]              false
 0     0      4          2,2       [[2,2,2,2]]              false
 0     1      7          2,2,3     [[2,2,2,2]]              false
 1     1      10         2,2,3,3   [[2,2,2,2]]              true
 0     1      7          2,2,3     [[2,2,2,2]]              false
 0     0      2          2         [[2,2,2,2]]              false
 1     1      5          2,3       [[2,2,2,2]]              false
 1     1      8          2,3,3     [[2,2,2,2], [2,3,3]]     false
 0     0      2          2         [[2,2,2,2], [2,3,3]]     false
 1     1      3          3         [[2,2,2,2], [2,3,3]]     false
 1     1      6          3,3       [2,2,2,2], [2,3,3]]      false
 1     1      9          3,3,3     [2,2,2,2], [2,3,3]]      true

</pre>