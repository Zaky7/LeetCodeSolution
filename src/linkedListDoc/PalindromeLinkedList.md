# Palindrome List

Given a singly linked list, determine if it is a palindrome.


```
Example 1:

Input: 1->2
Output: false

Example 2:

Input: 1->2->2->1
Output: true
```


> Follow up: Could you do it in O(n) time and O(1) space?

### Pseudocode:

1. Since we need to check whether Linked List is Pallindrome or not, we need to check element from the ``(mid-1 to start) and (mid + 1 to end)`` are equal to each other if we found any unequal match, we would return false.

2. Since in a LinkedList we cannot go from mid-1 to start since it is a singly linkedList. We need to reverse the pointers in original LinkedList from 
`start to mid - 1`.

3. Also we need to take a pointer **fast** and move it two jumps to reach the mid of the list in a single pass.

4. Once **mid** is reached, we need to take two pointers 
**ptr1, ptr2**. We would move ptr1 from `(mid - 1 to start)` and ptr2 from `(mid + 1 to start)`. If we would find any element unequal we would return false otherwise we continue

5. Now if either of ptr1 or ptr2 is not equal to zero then we would return false as element are not of equal length after the mid. Otherwise we would return true.