# [Check if a String has Unique alphabets](https://www.hackerrank.com/contests/fau-coding-competition/challenges/guild-unique-characters)

Implement an algorithm to determine if a string has all unique characters. The program should only check if alphabetic characters are unique. Spaces, quotations, numbers, etc should be ignored. The case of each character matters. 'A' is not the same as 'a'.


PseudoCode

## [Space Optimised Solution](https://stackoverflow.com/questions/25847191/new-to-java-trying-to-understand-checker-1-val/38518757#38518757)
- Since Java int is 32 bit integer. Here we are using variable checker
as 32 bit Array.
- Initialize it value as 0
- Here we are setting ith bit in the variable
- We check if bit is set then characters are duplicate otherwise we would return false

