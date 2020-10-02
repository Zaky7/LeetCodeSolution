package recursionOrDp;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Comparator;

class MaximumLengthOfPairChain {

  public int findLongestChain(int[][] pairs) {
    Arrays.sort(pairs, Comparator.comparingInt(pair -> pair[0]));
    Arrays
      .stream(pairs)
      .forEach(pair -> out.print(Arrays.toString(pair) + " "));

    int maxPairLength = 0;

    int pairCount = pairs.length;
    int[] pairLengthArr = new int[pairCount];

    Arrays.fill(pairLengthArr, 1);

    for (int i = pairCount - 2; i >= 0; i--) {
      int initialPairLength = pairLengthArr[i];

      for (int j = i + 1; j < pairCount; j++) {
        if (
          pairs[j][0] > pairs[i][1] &&
          (initialPairLength + pairLengthArr[j]) > pairLengthArr[i]
        ) {
          pairLengthArr[i] = 1 + pairLengthArr[j];
        }
      }
    }

    return Arrays.stream(pairLengthArr).max().getAsInt();
  }

  public static void main(String[] args) {
    int[][] pairs = { { 1, 2 }, { 1, 9 }, { 3, 4 }, { 2, 3 } };

    MaximumLengthOfPairChain mlp = new MaximumLengthOfPairChain();

    int maxPairLen = mlp.findLongestChain(pairs);
    out.println("\n" + maxPairLen);
  }
}
