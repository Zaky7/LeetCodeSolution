package string;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
  int index = 0;

  private int[] getFactorialArr(int start, int end) {
    int size = (end - start) + 1;
    int[] fact = new int[size + 1];

    fact[0] = 1;
    fact[1] = 1;

    for (int i = 2; i <= end; i++) {
      fact[i] = i * fact[i - 1];
    }

    return fact;
  }

  public String getPermutationOptimised(int n, int k) {
    int[] factArr = getFactorialArr(1, 9);

    System.out.println(factArr[9]);
    StringBuilder sequence = getStringSequence(n);
    StringBuilder result = new StringBuilder();
    generateKthPermutation(n, factArr, k - 1, sequence, result);
    return result.toString();
  }

  public void generateKthPermutation(
    int n,
    int[] factArr,
    int k,
    StringBuilder sequence,
    StringBuilder result
  ) {
    if (n == 1) {
      result.append(sequence.charAt(0));
      return;
    }

    int partitions = factArr[n - 1];
    int index = (k / partitions);

    result.append(sequence.charAt(index));
    sequence.deleteCharAt(index);

    k = k - (partitions * index);

    generateKthPermutation(n - 1, factArr, k, sequence, result);
  }

  public String getPermutation(int n, int k) {
    StringBuilder str = getStringSequence(n);
    List<String> permutations = new ArrayList<>();
    generatePermutation(str, permutations, 0, n - 1, k);

    for (int i = 0; i < permutations.size(); i++) {
      System.out.println("I: " + i + " " + permutations.get(i));
    }

    return permutations.get(k - 1);
  }

  /* T(n) : O(n!)
       S(n) : O(n!)
     */
  private void generatePermutation(
    StringBuilder str,
    List<String> permutations,
    int start,
    int end,
    int k
  ) {
    if (start > end) {
      return;
    }

    for (int i = start; i <= end; i++) {
      String permutationStr = str.toString();
      if (!permutations.contains(permutationStr)) {
        index++;
        permutations.add(permutationStr);
      }
      str = swap(str, start, i);
      generatePermutation(str, permutations, start + 1, end, k);
      str = swap(str, start, i);
    }
  }

  private static StringBuilder swap(StringBuilder str, int i, int j) {
    StringBuilder sb = new StringBuilder(str);
    sb.setCharAt(i, str.charAt(j));
    sb.setCharAt(j, str.charAt(i));
    return sb;
  }

  /* T(n) : O(n)
       S(n) : O(n)
     */
  private StringBuilder getStringSequence(int n) {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      sb.append(i);
    }
    return sb;
  }

  public static void main(String[] args) {
    PermutationSequence ps = new PermutationSequence();
    int n = 5;
    int K = 22;

    String result = ps.getPermutation(n, K);
    String result2 = ps.getPermutationOptimised(n, K);
    System.out.println("Result O(2^n): k: " + K + " " + result);
    System.out.println("Result2: k: " + K + " " + result2);
  }
}
