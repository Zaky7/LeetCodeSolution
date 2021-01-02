package heap;


import java.util.*;
import java.util.Set;
import java.util.HashSet;

class TopKFrequentElements {

    public static class NumFreq implements Comparable<NumFreq> {
        int num;
        int freq;

        NumFreq(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NumFreq numFreq = (NumFreq) o;
            return num == numFreq.num &&
                    freq == numFreq.freq;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num, freq);
        }

        @Override
        public int compareTo(NumFreq numFreq) {
            return Integer.compare(numFreq.freq,this.freq);
        }

        @Override
        public String toString() {
            return "Num: " + this.num + " freq: " + this.freq;
        }
    }

    public void findMaxKthElement(List<List<Integer>> nums, int k) {
        sortByPosition(nums, 0, nums.size()-1, k);
    }

    private void sortByPosition(List<List<Integer>> nums, int start, int end, int k) {
        if(start < end) {
            int pivotIndex = findPivotIndex(nums, start, end);

            if(pivotIndex == k) {
                return;
            } else if(pivotIndex < k) {
                // Move right
                sortByPosition(nums, pivotIndex + 1, end,k);
            } else {
                // Move left
                sortByPosition(nums, start, pivotIndex - 1,k);
            }
        }
    }

    private void swap(List<List<Integer>> list, int index1, int index2) {
        List<Integer> temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    private int findPivotIndex(List<List<Integer>> nums, int start, int end) {
        int pivotIndex = end;
        int i = start;
        int ptr = start;

        while(i < pivotIndex) {
            if(nums.get(i).get(1) >= nums.get(pivotIndex).get(1)) {
                swap(nums, i, ptr);
                ptr++;
            }
            i++;
        }
        swap(nums, ptr, pivotIndex);
        return ptr;
    }

    public static void main(String[] args) {
        int[][] nums = {{4,33},{2,4},{3,11},{5,13},{7,22}};
        List<List<Integer>> list = new ArrayList<>();
        int k = 6;


        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i][0]);
            temp.add(nums[i][1]);
            list.add(temp);
        }

        TopKFrequentElements tkF = new TopKFrequentElements();
        tkF.findMaxKthElement(list, k);

        System.out.println("Top " + k + " elements are: ");
        for (int i = 0; i < k; i++) {
            System.out.print("(" + list.get(i).get(0) + ", " + list.get(i).get(1) + "), ");
        }

    }
}