package math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PythagorasTriplet {

  public boolean hasTriplet(int[] arr) {
    if (arr.length < 3) {
      return false;
    }

    int[] sqrArr = Arrays.stream(arr).map(ele -> ele * ele).toArray();

    Map<Integer, Integer> numSqrMap = new HashMap<>();
    for (int i = 0; i < sqrArr.length; i++) {
      numSqrMap.put(sqrArr[i], i);
    }

    int n = sqrArr.length;
    for (int i = 0; i <= (n - 3); i++) {
      for (int j = i + 1; j <= (n - 2); j++) {
        int a = sqrArr[i];
        int b = sqrArr[j];

        if (numSqrMap.containsKey(Math.abs(a - b))) {
          int index = numSqrMap.get(Math.abs(a - b));
          if (index != i && index != j) {
            System.out.print(
              "Triplet: " + arr[i] + " " + arr[j] + " " + arr[index]
            );
            return true;
          }
        } else if (numSqrMap.containsKey(a + b)) {
          int index = numSqrMap.get(a + b);
          if (index != i && index != j) {
            System.out.print(
              "Triplet: " + arr[i] + " " + arr[j] + " " + arr[index]
            );
            return true;
          }
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int[] arr = { 2, 3, 4, 7, 8, 9, 0, 3, 5, 6 };

    PythagorasTriplet pgt = new PythagorasTriplet();
    pgt.hasTriplet(arr);
  }
}
