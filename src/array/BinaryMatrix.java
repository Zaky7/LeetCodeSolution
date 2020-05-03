package array;

import java.util.ArrayList;
import java.util.List;

public class BinaryMatrix {
  private int R, C;
  private int[][] mat;
  private int callTracker = 1;

  BinaryMatrix(int[][] mat) {
    int R = mat.length;
    int C = mat[0].length;
    this.R = R;
    this.C = C;
    this.mat = new int[R][C];
    copyMat(mat, this.mat);
  }

  private void copyMat(int[][] originalMat, int[][] resultMat) {
    for (int i = 0; i < this.R; ++i) {
      for (int j = 0; j < this.C; ++j) {
        resultMat[i][j] = originalMat[i][j];
      }
    }
  }

  public int get(int row, int col) {
    //        System.out.println("Get called: "  + (this.callTracker++));
    if (row >= this.R || col >= this.C) {
      throw new IllegalArgumentException("Index Out of Bound for Matrix Dimensions");
    }
    return this.mat[row][col];
  }

  public List<Integer> dimensions() {
    List<Integer> dimensionList = new ArrayList<Integer>(2);
    dimensionList.add(this.R);
    dimensionList.add(this.C);
    return dimensionList;
  }
}
