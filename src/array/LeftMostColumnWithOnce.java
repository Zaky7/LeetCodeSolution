package array;

import static util.Util.println;

import java.util.List;

public class LeftMostColumnWithOnce {

  public int binarySearchLeftMost(
    BinaryMatrix binaryMatrix,
    int start,
    int end,
    int row
  ) {
    int index = binarySearch(binaryMatrix, start, end, row, 1);

    if (index == -1) {
      return index;
    }

    if (binaryMatrix.get(row, index - 1) == 1) {
      return binarySearchLeftMost(binaryMatrix, start, index - 1, row);
    } else {
      return index;
    }
  }

  private int binarySearch(
    BinaryMatrix binaryMatrix,
    int start,
    int end,
    int row,
    int target
  ) {
    if (start <= end) {
      int mid = (start + end) / 2;
      int midValue = binaryMatrix.get(row, mid);
      if (midValue == target) {
        return mid;
      } else {
        return binarySearch(binaryMatrix, mid + 1, end, row, target);
      }
    }
    return -1;
  }

  public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    int leftMostColIndex = -1;
    List<Integer> dimensions = binaryMatrix.dimensions();
    int R = dimensions.get(0);
    int C = dimensions.get(1);
    int i = 0;

    // Iterate over all rows until the leftMostIndex is zero or you iterate them all
    while (i < R && leftMostColIndex != 0) {
      // If first Index is 1
      if (binaryMatrix.get(i, 0) == 1) {
        leftMostColIndex = 0;
      } else {
        // else check from 1 to end or 1 to previousLeftMostIndex
        int end = leftMostColIndex == -1 ? (C - 1) : (leftMostColIndex - 1);
        int currentLeftMostIndex = binarySearchLeftMost(
          binaryMatrix,
          1,
          end,
          i
        );
        leftMostColIndex = MIN(leftMostColIndex, currentLeftMostIndex);
      }

      System.out.println(
        "For row: " + i + " leftMost Index: " + leftMostColIndex
      );
      i++;
    }

    return leftMostColIndex;
  }

  private int MIN(int v1, int v2) {
    if (v1 != -1 && v2 != -1) {
      return Math.min(v1, v2);
    } else if (v1 != -1 && v2 == -1) {
      return v1;
    } else if (v1 == -1 && v2 != -1) {
      return v2;
    } else {
      return -1;
    }
  }

  public static void main(String[] args) {
    int[][] mat = {
      { 0, 0, 0, 1, 1, 1 },
      { 0, 0, 1, 1, 1, 1 },
      { 0, 1, 1, 1, 1, 1 },
      { 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 1 },
    };

    BinaryMatrix binaryMatrix = new BinaryMatrix(mat);
    LeftMostColumnWithOnce lf = new LeftMostColumnWithOnce();
    int leftMostIndex = lf.leftMostColumnWithOne(binaryMatrix);
    println(leftMostIndex);
  }
}
