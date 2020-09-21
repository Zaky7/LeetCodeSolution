package recursionOrDp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LargestDivisibleSubset {

    /*
 * Divisible subset till I
 * first  element denotes the index of next Element in divisible chain
   second element denotes the index of current chain length
 */
    private int[][] constructDivisionArr(int[] nums) {
        int[][] divSubset = new int[nums.length][2];
        Arrays.stream(divSubset).forEach(a -> {
            a[0] = -1;
            a[1] = 1;
        });
        return divSubset;
    }

    public static void print2DArray(int[][] arr) {
        int R = arr.length;
        int C = arr[0].length;

        System.out.println();
        for(int i=0; i<R; i++) {
            for(int j = 0; j<C; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean isModuleCommutative(int a, int b) {
        return (a % b == 0) || (b % a == 0) ? true : false;
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        // Sort the Array
        Arrays.sort(nums);

        int[][] divSubset =  constructDivisionArr(nums);
        List<Integer> list = new ArrayList<>();

        // fill enteries in division subset array
        for(int i=n-2; i >= 0; i--) {
            for(int j=i+1; j<n; j++) {
                if(isModuleCommutative(nums[i], nums[j]) && divSubset[i][1] <= divSubset[j][1]) {
                    // Next index is current value of J
                    divSubset[i][0] = j;
                    divSubset[i][1] = 1 + divSubset[j][1];
                }
            }
        }

        print2DArray(divSubset);

        int chainLength = 0;
        int nextIndex = -1;

        // Find the index of element having largest subset
        for(int i=0; i<n; i++) {
            if(chainLength < divSubset[i][1]) {
                chainLength = divSubset[i][1];
                nextIndex  = i;
            }
        }

        System.out.println("Chain Length: " + chainLength + " Next Index: " + nextIndex);

        // Regenerate elements using Chain
        int chainLen = chainLength;

        while(chainLen != 0)  {
            list.add(nums[nextIndex]);
            nextIndex = divSubset[nextIndex][0];
            chainLen--;
        }

        System.out.println(list.toString());

        return list;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] nums = {9,7,3, 1,2,4,8,};

        LargestDivisibleSubset lds = new LargestDivisibleSubset();

        lds.largestDivisibleSubset(nums);
    }
}