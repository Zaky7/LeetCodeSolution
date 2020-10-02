package recursionOrDp;

import java.util.ArrayList;
import java.util.List;

class LongestIncreasingSubsequence {

  public int LIC(int[] arr) {
    List<List<Integer>> subsequenceList = new ArrayList<>();
    List<Integer> subsequence = new ArrayList<>();

    LICUtil(arr, 0, subsequence, subsequenceList);

    int max = Integer.MIN_VALUE;

    for (List<Integer> temp : subsequenceList) {
      if (isIncreaseSubsequence(temp)) {
        System.out.println(
          temp.toString() + " is increasing: " + isIncreaseSubsequence(temp)
        );
        max = Math.max(max, temp.size());
      }
    }

    return max;
  }

  private boolean isIncreaseSubsequence(List<Integer> subsequence) {
    boolean isIncrease = true;

    for (int i = 1; i < subsequence.size(); i++) {
      if (subsequence.get(i - 1) > subsequence.get(i)) {
        isIncrease = false;
        break;
      }
    }

    return isIncrease;
  }

  private void LICUtil(
    int[] arr,
    int start,
    List<Integer> subsequence,
    List<List<Integer>> subsequenceList
  ) {
    if (start >= arr.length) {
      subsequenceList.add(new ArrayList<>(subsequence));
      return;
    }

    for (int i = start; i < arr.length; i++) {
      subsequence.add(arr[i]);
      LICUtil(arr, i + 1, subsequence, subsequenceList);
      subsequence.remove(subsequence.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18, 21 };
    LongestIncreasingSubsequence lic = new LongestIncreasingSubsequence();
    int maxLen = lic.LIC(arr);
    System.out.println("Maximum Length of Subsequence: " + maxLen);
  }
}
