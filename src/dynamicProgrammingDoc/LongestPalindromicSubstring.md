# [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)

Given a string s, return the longest palindromic substring in s.

### Example 1:
```java
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
```

### Pseudocode

[Leetcode good Doc](https://leetcode.com/problems/longest-palindromic-substring/solution/)

In order to solve this problem. You may think of reversing the given string and find the **LCS** (longest common substring) between two string. This may work
for the string like this.

S = "caba", S' = "abac".

S = "abacdfgdcaba", S' = "abacdgfdcaba".

The longest common substring between S and S' is "abacd". Clearly, this is **not** a **valid palindrome**.

Algorithm :-

We know that if bb is palindrom then xbbx is also a palindrome and xbby would not be palindrome. Thus we know if inner string is a palindrome then outer string would also be palindrome.

Also all the single letter strings are valid palindrome. So for a string s we can check recursively if outer most character matches then we need only to check the inner most character. In order to avoid re-computing whether in string is palindrom we need to store it somewhere. Therefore we can use **Dynamic Programming**


We can create a 2D array of size n * n.

T

dp[i][j] : denotes a substring starting from i to j is palindrome or not. If it is a palindrome then its value is 1 otherwise 0.

// We know all single letters digits are palindrome.

```java
for(int i=0; i<n; i++) {
  dp[i][i] = 1;
}
```

> Now for substrings of length 2. If i and i + 1 are equal then it is a palindrome.

```java
for(int i = 0; i<n-1; i++) {
  if(s.charAt(i) == s.charAt(i+1)) {
      dp[i][i+1] = 1;
  }
}
```

> Now for string length greater then 3 We need to check if outer letter matches and inner substring is a palindrome using the look dp table. If both condition satiesfies we mark it as 1 (Palindrome)

```java
for(int j=2; j<n; j++) {
  for(int i=0; i<(n-j); i++) {
      int a = i;
      int b = i + j;
      if(s.charAt(a) == s.charAt(b)) {
          dp[a][b] = dp[a+1][b-1] == 1 ? 1 : 0;
      }
  }
}
```

> After create the table we need to interate over it and find the longest substring which is a palindrome and return its value.

```java
StringBuilder sb = new StringBuilder(s.substring(0,1));
int maxLen = 0;
for(int j=n-1; j>=0; j--) {
    for(int i=0; i<=j; i++) {
        if(dp[i][j] == 1 && (j - i + 1) > sb.length()) {
            sb = new StringBuilder(s.substring(i, j + 1));
        }
    }
}
```

#### T(n): O(n * n) <br>
#### S(n): O(n * n)


We can further reduce the space complexity of the code as we know

#### Approach 4: Expand Around Center

In fact, we could solve it in O(n2)O(n^2)O(n2) time using only constant space.

We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center, and there are only 2n−1 such centers.

You might be asking why there are 2n−1 but not n centers? The reason is the center of a palindrome can be in between two letters. Such palindromes have even number of letters (such as "abba") and its center are between the two 'b's.

```java
public String longestPalindromeUsingCenterTh(String s) {
  int n = s.length();
  int start = 0;
  int end = 0;

  for(int i=0; i<n; i++) {
      int oddPalindromeLen = palindromeAroundIndex(s, i, i);
      int evenPalindromeLen = palindromeAroundIndex(s, i, i+1);
      int len = Math.max(evenPalindromeLen, oddPalindromeLen);

      if(len > (end - start)) {
          start = i - (len - 1) / 2;
          end  = i + (len / 2);
      }
  }

  return s.substring(start, end + 1);
}

private int palindromeAroundIndex(String s, int LEFT, int RIGHT) {
    int left = LEFT;
    int right = RIGHT;

    while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
    }

    return right - left - 1;
}

```
#### T(n): O(n * n) <br>
#### S(n): O(1)




