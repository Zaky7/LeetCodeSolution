package heap;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;

class MinimumCosttoConnectSticks {
    public int connectSticks(int[] sticks) {
        int n = sticks.length;
        int minTotalCost = 0;

        if(n == 1) {
            return minTotalCost;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        minHeap.addAll(Arrays.stream(sticks).boxed().collect(Collectors.toList()));

        System.out.println(minHeap.toString());

        int currentSum = minHeap.poll() + minHeap.poll();
        minTotalCost = currentSum;

        minHeap.add(currentSum);

        while(minHeap.size() > 1) {
            currentSum = minHeap.poll() + minHeap.poll();
            minHeap.add(currentSum);
            minTotalCost += currentSum;
        }

        return minTotalCost;
    }

    public static void main(String[] args) {
        int[] sticks = {1,3};

        MinimumCosttoConnectSticks mcc = new MinimumCosttoConnectSticks();
        int minCostToStickThemAll = mcc.connectSticks(sticks);
        System.out.println(minCostToStickThemAll);

        TreeMap<Integer, Integer> pqueue = new TreeMap<>();
        
    }
}