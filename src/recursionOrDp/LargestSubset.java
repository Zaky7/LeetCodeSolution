package recursionOrDp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestSubset {

    public static List<Integer> largestDivisibleSubset(int[] arr) {
        int n = arr.length;

        // If arr is Empty
        if(n == 0) {
            return new ArrayList<>();
        }

        // Sort the Input Array
        Arrays.sort(arr);

        int[] largestSubsetDp = new int[n];
        int[] prevPairIndex = new int[n];

        // Initialize the previous Index arr as -1 denoting no pair for the current Index
        Arrays.fill(prevPairIndex, -1);

        // Last Element would have value 1
        largestSubsetDp[n-1] = 1;


        int largestPairChainStartIndex = 0;
        for(int i=n-2; i>= 0; i--) {
            int maxSubsetLen = 0;
            for(int j = i+1; j<n; j++) {
                // 4 % 12 == 4 but 12 % 4 is zero
                // arr[j] is larger as input array in ascending order
                // Modulus operator is neither commutative or associative
                if((arr[j] % arr[i])  == 0) {
                    if(largestSubsetDp[j] > maxSubsetLen) {
                        prevPairIndex[i] = j;
                    }
                    maxSubsetLen = Math.max(maxSubsetLen, largestSubsetDp[j]);
                }
            }

            largestSubsetDp[i] = 1 + maxSubsetLen;

            if(largestSubsetDp[i] >= largestSubsetDp[largestPairChainStartIndex]) {
                largestPairChainStartIndex = i;
            }
        }


        // Previous Arr Display
        printArr(prevPairIndex, "Previous Array Display: ");

        // Dp Array Display:
        printArr(largestSubsetDp, "Dp Array Display: ");

        return constructDivisibleSubset(prevPairIndex, arr, largestPairChainStartIndex);
    }


    private static void printArr(int[] arr, String msg) {
        System.out.println(msg);
        int n = arr.length;
        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    private static List<Integer> constructDivisibleSubset(int [] prevPairIndex,
                                                          int[] arr, int start) {
        List<Integer> subset = new ArrayList<>();
        int n = arr.length;

        while(start < n) {
            if(prevPairIndex[start] != -1) {
                subset.add(arr[start]);
                start = prevPairIndex[start];

                // Marks termination of the chain
                if(prevPairIndex[start] == -1) {
                    subset.add(arr[start]);
                    break;
                }

            } else {

                start++;
            }
        }

        // Insert in subset list if arr length is 1 or previous pair start from first index
        if(subset.isEmpty()) {
            subset.add(arr[0]);
        }
        return subset;
    }

    public static void main(String[] args) {
        int[] arr = {819,475,859,124,442,542,162,36};
        List<Integer> subset = largestDivisibleSubset(arr);
        System.out.println(subset.toString());
    }
}
