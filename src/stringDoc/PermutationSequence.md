# Permutation Sequence

### Description

The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"

Given n and k, return the kth permutation sequence.

**Note:**

    Given n will be between 1 and 9 inclusive.
    Given k will be between 1 and n! inclusive.

**Example 1:**

Input: n = 3, k = 3
Output: "213"

### Naive Solution:- 👶

- Generate string based on the value of n for eg. if n = 4 then str = "1234"
- Now find all the permutation of the given string and store them in a list
- Now return the kth string from the list

```java
// T(n): O(2^n)
// S(n): O(2^n)

 public String getPermutation(int n, int k) {
        StringBuilder str = getStringSequence(n);
        List<String> permutations = new ArrayList<>();
        generatePermutation(str, permutations, 0, n-1, k);

        for(int i=0; i<permutations.size(); i++) {
            System.out.println("I: " + i + " " + permutations.get(i));
        }

        return permutations.get(k - 1);
}

 private void generatePermutation(StringBuilder str, List<String> permutations, int start, int end, int k) {
        if(start > end ) {
            return;
        }

        for(int i=start; i<= end; i++) {
            String permutationStr = str.toString();
            if(!permutations.contains(permutationStr)) {
                index++;
                permutations.add(permutationStr);
            }
            str = swap(str, start, i);
            generatePermutation(str, permutations, start+1, end, k);
            str = swap(str, start, i);
        }
}

private static StringBuilder swap(StringBuilder str, int i, int j) {
    StringBuilder sb = new StringBuilder(str);
    sb.setCharAt(i, str.charAt(j));
    sb.setCharAt(j, str.charAt(i));
    return sb;
}


private StringBuilder getStringSequence(int n) {
    StringBuilder sb = new StringBuilder();
    for(int i=1; i<=n; i++) {
        sb.append(i);
    }
    return sb;
}

```

## Optmised Solution 😎 [Video Link]([https://www.youtube.com/watch?v=W9SIlE2jhBQ)

You would notice since we have to return only particular sequence not whole set of sequence. We would find out a kth value.

Pseduocode

- Take a StringBuilder consists of the sequence from 1 to n.
- Also take an array and precompute the factorial of numbers from 1 to n.
- Changed k = k - 1
- Now we first find out the the partitionSize = factorial[n-1] and index of the char using
  `index = k / partitions`
- now we append char at index from sequence string into the result and remove it from the sequence string
- we also update the k to k - (partitions \* index) until n == 1

## Dry run

#### n= 5, k = 24

| n   | partition = (n-1)! | k -=(partition \* index) | index = k / partition | sequence | result  |
| --- | ------------------ | ------------------------ | --------------------- | -------- | ------- |
| 5   | 24                 | 23                       | 0                     | "12345"  | "1"     |
| 4   | 6                  | 23                       | 3                     | "2345"   | "15"    |
| 3   | 4                  | 5                        | 1                     | "234"    | "153"   |
| 2   | 1                  | 1                        | 1                     | "24"     | "1534"  |
| 1   | 1                  | 1                        | 1                     | "2"      | "15432" |
