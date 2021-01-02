# [Delete and Earn](https://leetcode.com/problems/delete-and-earn/)

https://leetcode.com/problems/delete-and-earn/

> Given an array nums of integers, you can perform operations on the array.

In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

You start with 0 points. Return the maximum number of points you can earn by applying such operations.

```java
Input: nums = [3, 4, 2]
Output: 6
Explanation:
Delete 4 to earn 4 points, consequently 3 is also deleted.
Then, delete 2 to earn 2 points. 6 total points are earned.
```


## Approach 1

- First we need to create a **num map** in which key denotes the number and value denotes the frequency of that number
- Now we need to create an array (**pointsEarnedArr**) of size n (**arr.length**) and iterate over the above map and store the points earned
>    pointsEarned[i] = number * number count

- Create another array (**numArr**) of size n and iterate over the freq map and store the keys in it


- Now you take a loop from i = 1 to n and create another loop from j = 0 and j  i
- if numArr[i] - numArr[j] != 1
  pointsEarned[i] = Math.max(pointsEarned[i], pointsEarned[i] + pointsEarned[j])
  else
  pointsEarned[i] = Math.max(pointsEarned[i], pointsEarned[j])

- At last return max element in the points earned array.


```java
For eg.
[3, 4, 5];

freqMap = {
  3 -> 1
  4 -> 1
  5 -> 1
}

pointsEarned = [3, 4, 5]
numberMap = [3, 4, 5]

i j   0  1  2
1 0  [3, 4, 5] max(4, 3)  [3,4,5]
2 0  [3, 4, 5] max(5, 8)  [3,4,8]
  1  [3, 4, 5] max(8, 4)  [3,4,8]


for (int i = 1; i < pointsEarnedDp.length; i++) {
      int points = pointsEarnedDp[i];
      for (int j = 0; j < i; j++) {
        if ((numArr[i] - numArr[j]) != 1) {
          pointsEarnedDp[i] =
            Math.max(pointsEarnedDp[i], points + pointsEarnedDp[j]);
        } else {
          pointsEarnedDp[i] = Math.max(pointsEarnedDp[i], pointsEarnedDp[j]);
        }
      }
    }
```

<br>

## Approach 2

- First we need to find the maximum element from the array
- Now declare a array of size arr[max + 1]
- Now create a frequency map array using below code

```java
int[] occur = new int[maxElement + 1];

for(int i=0; i< nums.length; i++) {
    occur[nums[i]] += 1;
}
```
- Now start from i = 2  to maxElement + 1  and find the points earned

```java
for(int i=2; i<= maxElement; i++) {
      // Current value depends of factor
      // If previous count vs current values count * current + previous - 2 count
      occur[i] = Math.max(occur[i-1], occur[i-2] + occur[i] * i);
}
```

Main crux of the problem is :-
Our recurrence relation will decide either to select a number or not. If we select the number then we take the occurrences of that number and the value stored at ans[i-2] as ans[i-1] will be deleted and not be taken to count. If we do not select the number then we take ans[i-1] which have been pre-calculated while moving forward.

> ans[i] = max(ans[i-1], ans[i-2] + ans[i]*i )
