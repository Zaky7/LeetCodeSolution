package src.hashTable;

import java.util.Arrays;
import java.util.HashMap;

class LongestHarmoniousSubsequence {

    public static void main(String[] args) {
        LongestHarmoniousSubsequence LHS = new LongestHarmoniousSubsequence();
        int[] nums = {1,3,2,2,5,2,3,7};
        int lhs = LHS.findLHS(nums);
        System.out.println("Longest Harmonium Subsequence length is : " + lhs + " for string: " + Arrays.toString(nums)) ;
    }

    public int findLHS(int[] nums) {
        HashMap < Integer, Integer > map = new HashMap<>();
        int res = 0;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key: map.keySet()) {
            if (map.containsKey(key + 1))
                res = Math.max(res, map.get(key) + map.get(key + 1));
        }
        return res;
    }
}