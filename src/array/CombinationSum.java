package array;

import java.util.ArrayList;
import java.util.List;

class CombinationSum {

  private void combinationSumUtil(
    int start,
    int[] num,
    List<Integer> temp,
    List<List<Integer>> result,
    int currentSum,
    int targetSum
  ) {
    if (currentSum == targetSum) {
      result.add(new ArrayList<>(temp));
      temp = new ArrayList<>();
      currentSum = 0;
      return;
    } else if (currentSum > targetSum) {
      return;
    } else {
      for (int i = start; i < num.length; i++) {
        currentSum += num[i];
        temp.add(num[i]);
        combinationSumUtil(i, num, temp, result, currentSum, targetSum);

        currentSum -= num[i];
        temp.remove(temp.size() - 1);
      }
    }
  }

  public List<List<Integer>> combinationSum(int[] num, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    combinationSumUtil(0, num, temp, result, 0, targetSum);
    return result;
  }

  public static void main(String[] args) {
    int[] num = { 2, 3, 5 };
    int targetSum = 8;
    CombinationSum cs = new CombinationSum();
    List<List<Integer>> result = cs.combinationSum(num, targetSum);

    System.out.println(result.toString());
  }
}
