# [Container With Most Water](https://leetcode.com/problems/container-with-most-water/)



<p style="font-size: 18px; font-family:  Arial, Helvetica, sans-serif;">
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the <strong>container contains the most water</strong>.
</p>


<p style="font-size: 18px; font-family:  Arial, Helvetica, sans-serif;">
Notice that you may not slant the container.
</p>


```java

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
```

<br>

### Pseudocode

#### Naive Solution

Since we need to find the maxium Area between the container and they cannot slant.

```java
Area = (Diff b/w index of two points) * Min(height[i], height[j]);

- Take two pointers i and j
- Run a outer loop from i = 0 to n-1;
- Run another inner Loop j = n - 1 until j > i
- Now find the area using the above formula for points (i,j)
- Update the maxArea if currentArea is greater than maxArea
- Now if height[j] >= height[i] we can break the loop
- else we would decrement j

```

```java
Code
  

```



