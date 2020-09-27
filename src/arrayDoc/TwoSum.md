# [Two Sum](https://leetcode.com/problems/two-sum/)

## Description
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.


Solution

<pre>
**Naive approach** 🤔

T(n): O(n^2)
S(n): O(1) constant

1. Take first element and then check element on the right if they are equal to target - current element then return the index of both

2. If not element found, you can repeat it for other elements

**Efficient Solution** 🤗
T(n): O(n)
S(n): O(n)

1. We can create a hashMap that stores current element as key and its index and its value
2. Now if iterate over the element of the array
3. If hashMap is not empty or hashMap contains (target - currentElement):
    then we found two indices have sum equal to target return
    their index.
4. else
    put the current element in the Map as key and its index as value
    and repeat until we found the match


</pre>