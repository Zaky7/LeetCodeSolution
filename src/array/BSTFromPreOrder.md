# [BST from its PreOrder ](leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/)


Problem is to contruct a binary Seach Tree from its preorder Traversal.


#### Algorithm

In order to contruct Binary Search Tree from its preorder Traversal we need to perform the following steps

- First element is the root of the Binary Search in preorder Array.
- Take two variable start and end. Initialize start=0 and end = n-1
- Find the index of element greater than root and mark it as i. If no greater element found then make *i* as -1.
- If i == -1 then mark node at right as null and for the left part 
starting from start to i-1 repeat the above steps
- else if i == start+1 then mark node right as null and for the right part 
recursively repeat the above steps
- else then 
  ```java
  node.left  = recursefor start to i-1
  node.right = recursefor i to end
  ```

- Now elements starting from i to end belongs to the right of root node and element from start to i-1 belongs to the left of root node
- Repeat the following steps for left and right subArrays. 