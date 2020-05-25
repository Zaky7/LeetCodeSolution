

public class PartitionArrayThreeParts {

  public static void main(String[] args) {
    int[] testArr = { 0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1 };
    PartitionArrayThreeParts parray = new PartitionArrayThreeParts();
    // Ans true
    System.out.println(parray.canThreePartsEqualSum(testArr));
  }

  public boolean canThreePartsEqualSum(int[] A) {
    int totalSum = 0, requiredSum = 0, iteration = 0;
    int n = A.length;
    int sum = 0;
    int parts = 3;

    // Calculating the Total sum
    for (int i = 0; i < n; i++) {
      totalSum += A[i];
    }

    // Calculating the Required Sum
    requiredSum = totalSum / parts;

    // System.out.println("TotalSum: " +  totalSum + " RequiredSum: " + requiredSum);

    // Check the Sum for 2 parts
    for (int i = 0; i < n; i++) {
      sum += A[i];
      // System.out.println("Sum: " + sum + " Iteration: " + iteration);
      if (sum == requiredSum && iteration < parts - 1) {
        iteration++;
        sum = 0;
      }
    }

    // Check the remaining Parts
    if (sum == requiredSum) {
      iteration++;
      sum = 0;
    }

    // System.out.println("Last sum value: " + sum + " Iteration: " + iteration);

    if (iteration == parts && sum == 0) {
      return true;
    } else {
      return false;
    }
  }
}
