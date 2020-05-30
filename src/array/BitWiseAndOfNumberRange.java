package array;

public class BitWiseAndOfNumberRange {

  public int rangeBitwiseAnd(int m, int n) {
    int result = 0;

    if (m == 0 || n == 0) {
      return result;
    }

    int MSB_M = findMSB(m);
    int MSB_N = findMSB(n);

    if (MSB_M == MSB_N) {
      result += Math.pow(2, MSB_N);
      m -= result;
      n -= result;
      result += rangeBitwiseAnd(m, n);
    }

    return result;
  }

  private int findMSB(int num) {
    return (int) (Math.log(num) / Math.log(2));
  }
}
