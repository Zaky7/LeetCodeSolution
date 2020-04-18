package array;

import util.Util;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    /**
     * O(n) Time and O(n) space
     * @param nums
     * @return
     */
    public int[] productExceptSelfNotSpaceOptimised(int[] nums) {

        // The length of the input array 
        int length = nums.length;

        // Final answer array to be returned
        int[] answer = new int[length];

        // answer[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the answer[0] would be 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {

            // answer[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all 
            // elements to the left of index 'i'
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the R would be 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {

            // For the index 'i', R would contain the 
            // product of all elements to the right. We update R accordingly
            answer[i] = answer[i] * R;
            R *= nums[i];
        }

        return answer;
    }

    public int[] productExceptSelfLarge(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        
        int zero_index = -1;
        int zero_count = 0;
        int total_product_without_zero = 1;
        
        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                zero_index = i;
                zero_count++;
            } else {
               total_product_without_zero *= nums[i];  
            }
            
        }
        
        // if input array contains zero
        if(zero_count >= 1) {
            Arrays.fill(output, 0);
            
            if(zero_count == 1) {
                output[zero_index] = total_product_without_zero;
            }
            return output;
        } else {
            // if no zero present in the input Array
            for(int i = 0; i < n; i++) {
              output[i] = divide(total_product_without_zero, nums[i]);
            }
            return output;   
        }
    }

    private static int divide(int int_dividend, int int_divisor) {
        

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
         * bit 1<<31 behaves incorrectly and gives Integer divisor << i equals to
         * divisor * 2^i quotient | 1L << i equals to
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

    /**
     * O(n) Time Complexity and O(1) Space
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int curr = 1;
        for(int i = 0; i < nums.length; i++){
            output[i] = curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i = nums.length -1; i >= 0; i--){
            output[i] = output[i] * curr;
            curr *= nums[i];
        }
        return output;
    }


    public static void main(String[] args) {
        int[][] tests = {
            {-1,0, 8, 9 , 4, -2},
            {1,1},
            {0,0},
            {-1,-1},
            {1,-1},
            {1,2,3,4},
            {-1,0}
        };

        int[][] expectedOutput = {
                {0,576,0,0,0,0},
                {1,1},
                {0,0},
                {-1,-1},
                {-1,1},
                {24,12,8,6},
                {0,-1}
        };

        ProductOfArrayExceptSelf poes = new ProductOfArrayExceptSelf();

        int n = tests.length;
        for(int i=0; i<n; i++) {
            Util.compareArr(poes.productExceptSelf(tests[i]), expectedOutput[i]);
        }
    }
}