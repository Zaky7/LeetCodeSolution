# [Rotate Image](https://leetcode.com/problems/rotate-image/)

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

##### Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

##### Example 1:

```
Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
```

Solution

- Since we need to rotate Matrix clock wise in place then we need to swap the element in their right position.

If we start from element at position (0,0) for N = 3 then after rotation its position would be (0,2)

```
N = 3

[ [1 2 3]
  [4 5 6]
  [7 8 9] ]


start = (0, 0)
Before Rotation     After Rotation
(0,0)           ->  (0,2)
(0,2)           ->  (2,2)
(2,2)           ->  (2,0)
(2,0)           ->  (0,0)

start = (0, 1)
Before Rotation     After Rotation
(0,1)           ->  (1,2)
(1,2)           ->  (2,1)
(2,1)           ->  (1,0)
(1,0)           ->  (0,1)
```

After replacing element at below postion you would find out matrix get rotated in place

- First we need to check for given **N = 3** whether an element belongs to either of the below category:
  - First Row: element from (0,0) to (0,1)
        <br/> - Rotate in order: // R -> D -> L -> U

  - Last  Col: element from (0,2) to (1,2)
        <br/> - Rotate in order: // D -> L -> U -> R
  
  - Last  Row: element from (2,2) to (2,1)
        <br/> - Rotate in order: // L -> U -> R -> D

  - First Col: element from (2,0) to (1,0)
        <br/> - Rotate in order: // U -> R -> D -> L

- After selecting the category we move as per category
   if element belongs to the first row then we move N - 1 step in direction Right->Down-> Left --> U to reach next postion and replace both position value.

- Now need to repeat above alogrithm after reducing N by 2 

- Base case if N == 1 return since single element is present
