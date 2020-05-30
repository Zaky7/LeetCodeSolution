import java.util.Arrays;

public class ProductOfArrayExceptSelf {

  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] output = new int[n];
    int total_product = Arrays.stream(nums).reduce(1, (num1, num2) -> num1 * num2);

    for (int i = 0; i < n; i++) {
      output[i] = divide(total_product, nums[i]);
    }
    return output;
  }

  public static int divide(int int_dividend, int int_divisor) {
    long dividend = int_dividend;
    long divisor = int_divisor;

    // Calculate the sign based on fact that false ^ true |\ true ^ false = 1
    int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

    // remove sign of operands
    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);

    // Initialize the quotient
    long quotient = 0, temp = 0;

    /*
     * Test down from the highest bit and accumulate the tentative value for valid
     * bit 1<<31 behaves incorrectly and gives Integer
     * divisor << i equals to divisor * 2^i
     * quotient | 1L << i equals to
     */
    for (int i = 31; i >= 0; --i) {
      if (temp + (divisor << i) <= dividend) {
        temp += divisor << i;
        quotient = quotient | 1L << i;
      }
    }

    if (sign == -1 && quotient > Integer.MAX_VALUE) {
      return Integer.MIN_VALUE;
    } else if (sign == 1 && quotient >= Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    } else if (sign == -1) {
      return (int) -quotient;
    } else {
      return (int) quotient;
    }
  }
}
