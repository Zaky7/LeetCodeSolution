# [First Bad Version](https://leetcode.com/problems/first-bad-version/)

Just use simple binary search to find the first bad version

```
- Take two variables start and end and intiailize them as 0 and n-1;
- Now find the mid element and check it is a bad version
- if yes:
     if mid - 1 is good:
        return mid
     else:
        check in the array from start to mid - 1
  else:
    if mid + 1 is bad:
        return mid + 1
    else:
        check in the array from mid + 1 and end

```

#### Caveat!!: Use long otherwise value will overflow
