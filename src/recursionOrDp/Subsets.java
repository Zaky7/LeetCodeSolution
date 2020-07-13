package recursionOrDp;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> createSubsets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        createSubsetsUtil(arr, 0, arr.length - 1, new ArrayList<Integer>(), result);
        return result;
    }

    private void createSubsetsUtil(int[] arr, int start, int end, ArrayList<Integer> temp, List<List<Integer>> result) {
        if(start > end) {
            return;
        }

        for(int i=start; i<=end; i++) {
            temp.add(arr[i]);
            if(!result.contains(temp)) {
                result.add(new ArrayList<>(temp));
            }
            createSubsetsUtil(arr, i + 1, end, temp, result);
            // Back Track
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4};
        Subsets sb = new Subsets();
        List<List<Integer>> result = sb.createSubsets(nums);

        for(List<Integer> list: result) {
            System.out.println(list.toString());
        }

    }
}
