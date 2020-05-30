package heap;

import java.util.HashSet;
import java.util.PriorityQueue;

class UglyHeap {
  public int[] ugly = new int[1690];

  UglyHeap() {
    PriorityQueue<Long> minHeap = new PriorityQueue<>();
    HashSet<Long> seen = new HashSet<>();
    seen.add(1L);
    minHeap.add(1L);

    long currentUgly;
    long newUgly;

    int[] Primes = new int[] { 2, 3, 5 };

    for (int i = 0; i < 1690; i++) {
      currentUgly = minHeap.poll();
      ugly[i] = (int) currentUgly;

      for (int prime : Primes) {
        newUgly = currentUgly * prime;

        // Avoiding duplicates
        if (!seen.contains(newUgly)) {
          minHeap.add(newUgly);
          seen.add(newUgly);
        }
      }
    }
  }
}

public class UglyNumUsingHeap {
  public static UglyHeap u = new UglyHeap();

  public int nthUglyNumber(int n) {
    return u.ugly[n - 1];
  }

  public static void main(String[] args) {
    UglyNumUsingHeap ug2 = new UglyNumUsingHeap();
    int num = ug2.nthUglyNumber(8);
    System.out.print("Nth Ugly Number using Heap: " + num);
  }
}
