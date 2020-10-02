package array;

class ContainsDuplicate3 {

  public static void main(String[] args) {
    System.out.println(Integer.MIN_VALUE);
  }

  public boolean containsNearbyAlmostDuplicate(
    int[] nums,
    int indexDiff,
    int numDiff
  ) {
    int n = nums.length;
    if (n == 0 || n == 1) {
      return false;
    }

    System.out.println(
      "Index difference: " + indexDiff + " number difference: " + numDiff
    );

    for (int i = 0; i < (n - indexDiff); i++) {
      for (int j = i + 1; j <= (i + indexDiff); j++) {
        System.out.println(
          "i: " +
          i +
          " j: " +
          j +
          " nums[i]: " +
          nums[i] +
          " nums[j]: " +
          nums[j] +
          " diff: " +
          (nums[j] - nums[i])
        );
        if ((nums[j] - nums[i]) <= numDiff) {
          System.out.println(
            "Result i: " +
            i +
            " j: " +
            j +
            " nums[i]: " +
            nums[i] +
            " nums[j]: " +
            nums[j] +
            " diff: " +
            (nums[j] - nums[i])
          );
          return true;
        }
      }
    }

    return false;
  }
}
