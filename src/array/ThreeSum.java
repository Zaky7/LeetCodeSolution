package array;

import static java.lang.System.out;

import java.util.*;

public class ThreeSum {

  /**
   * T(n): O(n^2)
   * @param nums
   * @return
   */
  public List<List<Integer>> threeSum(int[] nums) {
    // Sort the existing arr
    Arrays.sort(nums);
    List<List<Integer>> uniqueTripletPairs = new ArrayList<>();
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      int j = i + 1;
      int k = nums.length - 1;

      // Avoid duplicate triplet
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      while (j < k) {
        // Avoid duplicate triplet
        if (k < (nums.length - 1) && nums[k] == nums[k + 1]) {
          k--;
          continue;
        }

        if (nums[i] + nums[j] + nums[k] < 0) {
          j++;
        } else if (nums[i] + nums[j] + nums[k] > 0) {
          k--;
        } else {
          List<Integer> triplet = new ArrayList<>();
          triplet.add(nums[i]);
          triplet.add(nums[j]);
          triplet.add(nums[k]);
          uniqueTripletPairs.add(triplet);
          j++;
          k--;
        }
      }
    }

    return uniqueTripletPairs;
  }

  /**
   * T(n): O(n^3)
   * @param nums
   * @return
   */
  public List<List<Integer>> threeSumNaive(int[] nums) {
    List<List<Integer>> uniqueTripletPairs = new ArrayList<>();
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          if (nums[i] + nums[j] + nums[k] == 0) {
            List<Integer> triplet = new ArrayList<>();
            triplet.add(nums[i]);
            triplet.add(nums[j]);
            triplet.add(nums[k]);
            uniqueTripletPairs.add(triplet);
          }
        }
      }
    }

    return uniqueTripletPairs;
  }

  public static void main(String[] args) {
    int[] arr = { -6, -2, -2, 1, 1, 4, 8, 9 };
    ThreeSum ts = new ThreeSum();
    out.println(ts.threeSum(arr));
  }
}
