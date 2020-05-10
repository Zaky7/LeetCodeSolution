# 662. Maximum Width of Binary Tree

[Width of Binary Tree](https://leetcode.com/problems/maximum-width-of-binary-tree/)

Given a binary tree, write a function to get the maximum width of the given tree.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Solution:-

### Naive Approach

Input:

           1
         /   \
        3     2
       / \     \
      5   3     9

Output:
length 4 (5,3,null,9).

- Create a queue of TreeNode with Index class so that we have two values for tree in the queue. Once is treeNode and other is nodeIndex

- Now push root to the queue if it is not null else return

- Iterate over the queue until it is not empty.
- Now take a varible name count and initialize its value with queue size
- Take **max_width** with

  ```java
  max_width = MAX(max_width, nodeWithIndex.last().index - nodeWithIndex.first() + 1)
  ```

- Run another while loop inside the current loop until count value becomes zero
- On each iteration pop an element from the front of the queue.
- Each popped element containes node and its index

- if node has left then push node.left and 2 \* initialNodeStartIndex + 1
- if node has right then push node.right and 2 \* initialNodeStartIndex + 2

- return max_width
