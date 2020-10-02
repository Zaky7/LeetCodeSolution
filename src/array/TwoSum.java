package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> valIndexMap = new HashMap<>();
    int n = nums.length;
    int indexes[] = new int[2];

    for (int i = 0; i < n; i++) {
      if (!valIndexMap.isEmpty() && valIndexMap.containsKey(target - nums[i])) {
        indexes[0] = valIndexMap.get(target - nums[i]);
        indexes[1] = i;
        break;
      } else {
        valIndexMap.put(nums[i], i);
      }
    }

    return indexes;
  }

  public static void main(String[] args) {
    int[] arr = { 2, 7, 11, 15 };

    TwoSum ts = new TwoSum();
    int[] indices = ts.twoSum(arr, 9);

    System.out.println(Arrays.toString(indices));
  }
}
