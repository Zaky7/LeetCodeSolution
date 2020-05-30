import java.util.HashMap;

public class NumOfSubArrWithSumK {

  public int subarraySum(int[] nums, int k) {
    return subArraySumUsingMap(nums, k);
  }

  private int subArraySumUsingMap(int[] nums, int k) {
    HashMap<Integer, Integer> preSumMap = new HashMap();
    int curr_sum = 0;
    int subArrSumEqlK = 0;
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      curr_sum += nums[i];

      if (curr_sum == k) {
        subArrSumEqlK++;
      }

      if (preSumMap.containsKey(curr_sum - k)) {
        subArrSumEqlK += preSumMap.get(curr_sum - k);
      }

      Integer count = preSumMap.get(curr_sum);

      if (count == null) {
        preSumMap.put(curr_sum, 1);
      } else {
        preSumMap.put(curr_sum, count + 1);
      }
    }

    return subArrSumEqlK;
  }

  private int subarraySumIterative(int[] nums, int k) {
    int n = nums.length;
    int subArrSumEqlK = 0;

    for (int start = 0; start < n; start++) {
      int sum = 0;
      for (int subArraySize = 1; subArraySize <= n; subArraySize++) {
        if ((start + subArraySize) > n) {
          break;
        }

        // Add the last element in currentSubArray
        sum += nums[start + subArraySize - 1];

        if (sum == k) {
          subArrSumEqlK++;
        }
      }
    }

    return subArrSumEqlK;
  }

  public static void main(String[] args) {
    int arr[] = new int[] { 1, 2, 3, 2, 1, 4, -1 };
    int K = 3;
    NumOfSubArrWithSumK nsk = new NumOfSubArrWithSumK();
    int count = nsk.subarraySum(arr, K);
  }
}
