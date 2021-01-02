package recursionOrDp;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

class DeleteAndEarn {

  private TreeMap<Integer, Integer> generateTreeMap(int[] nums) {
    TreeMap<Integer, Integer> numCountMap = new TreeMap<>();
    for (int i = 0; i < nums.length; i++) {
      int previousCount = numCountMap.getOrDefault(nums[i], 0);
      numCountMap.put(nums[i], (1 + previousCount));
    }
    return numCountMap;
  }

  private int[] getPointsEarnedByIndexArr(
    TreeMap<Integer, Integer> numCountMap
  ) {
    int[] pointsEarnedDp = new int[numCountMap.size()];
    int i = 0;
    for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
      pointsEarnedDp[i++] = entry.getKey() * entry.getValue();
    }
    return pointsEarnedDp;
  }

  private int[] getPointsNumArr(TreeMap<Integer, Integer> numCountMap) {
    int[] numArr = new int[numCountMap.size()];
    int i = 0;
    for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
      numArr[i++] = entry.getKey();
    }
    return numArr;
  }

  public int deleteAndEarn(int[] nums) {
    int n = nums.length;

    if(n == 0) {
      return 0;
    }

    TreeMap<Integer, Integer> numCountMap = generateTreeMap(nums);
    int[] pointsEarnedDp = getPointsEarnedByIndexArr(numCountMap);
    int[] numArr = getPointsNumArr(numCountMap);

    // System.out.println(Arrays.toString(numArr));
    // System.out.println(Arrays.toString(pointsEarnedDp));

    for (int i = 1; i < pointsEarnedDp.length; i++) {
      int points = pointsEarnedDp[i];
      for (int j = 0; j < i; j++) {
        if ((numArr[i] - numArr[j]) != 1) {
          pointsEarnedDp[i] =
            Math.max(pointsEarnedDp[i], points + pointsEarnedDp[j]);
        } else {
          pointsEarnedDp[i] = Math.max(pointsEarnedDp[i], pointsEarnedDp[j]);
        }
      }
    }

    System.out.println(Arrays.toString(pointsEarnedDp));

    int maxPointsEarned = Arrays.stream(pointsEarnedDp).max().getAsInt();
    return maxPointsEarned;
  }

  public int deleteAndEarnDp(int[] nums) {
    int maxElement = Integer.MIN_VALUE;
    int n  = nums.length;

    if(n == 0) {
        return 0;
    }

    for(int i=0; i<n; i++) {
        maxElement = Math.max(maxElement, nums[i]);
    }

    int[] occur = new int[maxElement + 1];
    for(int i=0; i< nums.length; i++) {
        occur[nums[i]] += 1;
    }

    // System.out.println("Max Element: " + maxElement + " ele: " + Arrays.toString(occur));

    for(int i=2; i<= maxElement; i++) {
      // Current value depends of factor
      // If previous count vs current values count * current + previous - 2 count
      occur[i] = Math.max(occur[i-1], occur[i-2] + occur[i] * i);
    }

    // System.out.println(Arrays.toString(occur));
    return occur[maxElement];
  }

  public static void main(String[] args) {
    //        int[] arr = {2, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6};
    int[] arr = { 2, 2, 3, 3, 3, 4 };
    //        int[] arr = {2, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6};
    //        int[] arr = {2, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6};

    DeleteAndEarn de = new DeleteAndEarn();
    int pointsEarned = de.deleteAndEarn(arr);
    System.out.println(pointsEarned);
  }
}
