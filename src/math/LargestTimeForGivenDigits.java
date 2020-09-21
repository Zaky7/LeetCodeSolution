package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class LargestTimeForGivenDigits {

    public String largestTimeFromDigits(int[] A) {
        List<List<Integer>> permutations = getAllPermutation(A);
        System.out.println(permutations.toString());
        Double maxTime = Double.MIN_VALUE;

        for(List permutation: permutations) {
            int hours = castToTime((Integer) permutation.get(0), (Integer) permutation.get(1));
            int minutes = castToTime((Integer) permutation.get(2), (Integer) permutation.get(3));


            if((hours >= 0 && hours <= 23) && (minutes >= 0 && minutes <= 59)) {
                double time = Double.parseDouble("" + hours + "." + minutes);
                System.out.println(time);
                maxTime = Math.max(maxTime, time);
            }
        }

        if(maxTime == Double.MIN_VALUE) {
            return "";
        } else {
            return convertDecimalTimeToString(maxTime);
        }
    }

    private String convertDecimalTimeToString(double maxTime) {
        String result = "" + maxTime;
        String[] res = result.split("\\.");
        System.out.println(Arrays.toString(res));

        if(res[0].length() == 1) {
            res[0] = "0" + res[0];
        }

        result = res[0] + "." + res[1];
        result = result.replaceAll("\\.", ":");
        return result;
    }

    private int castToTime(Integer first, Integer second) {
        String time   =  "" + (first * 10 + second);
        return Integer.parseInt(time);
    }

    private List<List<Integer>> getAllPermutation(int[] A) {
        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        List<List<Integer>> result = new ArrayList<>();
        getAllPermutationUtil(0, list, result);
        return result;
    }

    private void getAllPermutationUtil(int start, List<Integer> list, List<List<Integer>> result) {
        if(start >= list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < list.size(); i++) {
            swap(list, start, i);
            getAllPermutationUtil(start+1, list, result);
            swap(list, i, start);
        }
    }

    private void swap(List list, int index1, int index2) {
        Object temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public static void main(String[] args) {
        int[] A = {0,0,0,0};
        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        LargestTimeForGivenDigits ltg = new LargestTimeForGivenDigits();
        String result = ltg.largestTimeFromDigits(A);

        System.out.println("Result: " + result);
    }
}
