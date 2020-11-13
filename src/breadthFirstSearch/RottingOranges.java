package breadthFirstSearch;

import util.Util;

import java.util.LinkedList;
import java.util.Queue;

class RottingOranges {

    private static final int EMPTY  = 0;
    private static final int FRESH  = 1;
    private static final int ROTTEN = 2;

    public int orangesRottingNaive(int[][] grid) {

        boolean isRottingOccur = false;
        int rottenSeconds = 0;
        int[][] gridCopy = copyMatrix(grid);
        int R = grid.length;
        int C = grid[0].length;

        do {
            int[][] newGrid = copyMatrix(gridCopy);

            System.out.println("Rotten State at: " + rottenSeconds + "s");
            printMat(newGrid);

            isRottingOccur = false;

            for(int i=0; i<R; i++) {
                for(int j=0; j<C ; j++) {
                    if(gridCopy[i][j] == ROTTEN) {
                        // Check Top
                        if((i-1 >= 0) && gridCopy[i-1][j] == FRESH) {
                            isRottingOccur = true;
                            newGrid[i-1][j] = ROTTEN;
                        }

                        // Check right
                        if((j+1) < C && gridCopy[i][j+1] == FRESH) {
                            isRottingOccur = true;
                            newGrid[i][j+1] = ROTTEN;
                        }


                        // Check Bottom
                        if((i+1) < R && gridCopy[i+1][j] == FRESH) {
                            isRottingOccur = true;
                            newGrid[i+1][j] = ROTTEN;
                        }

                        // Check Left
                        if((j-1) >= 0 && gridCopy[i][j-1] == FRESH) {
                            isRottingOccur = true;
                            newGrid[i][j-1] = ROTTEN;
                        }
                    }
                }
            }

            gridCopy = newGrid;

            if(isRottingOccur == true) {
                rottenSeconds++;
            }
        } while (isRottingOccur == true);


        boolean isFreshPresent = false;

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(gridCopy[i][j] == FRESH) {
                    isFreshPresent = true;
                    break;
                }
            }
        }


        if(isFreshPresent) {
            return -1;
        } else {
            return rottenSeconds;
        }

    }

    private int[][] copyMatrix(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;
        int[][] newMat = new int[R][C];

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                newMat[i][j] = mat[i][j];
            }
        }

        return newMat;
    }

    private void printMat(int[][] mat) {
        Util.print2DArray(mat);
    }

    // Using BFS

    static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public String toString() {
            return String.format("a: " + this.a + " " + " b: " + this.b);
        }
    }

    public int orangesRotting(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        Queue<Pair> pair = new LinkedList<>();
        int freshCount = 0;


        // Fill rotten once is the Queue for BFS
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(grid[i][j] == ROTTEN) {
                    pair.offer(new Pair(i, j));
                } else if(grid[i][j] == FRESH) {
                    freshCount++;
                }
            }
        }

        // Add as a delimiter
        pair.offer(new Pair(-1, -1));

        int[][] Direction = {{-1,0}, {1,0}, {0, -1}, {0,1}};
        int elapsedTime = 0;

        while(!pair.isEmpty()) {
            Pair p = pair.poll();
            // System.out.println(p);
            if(p.a == -1) {
                if(!pair.isEmpty()) {
                    pair.offer(new Pair(-1,-1));
                    elapsedTime++;
                }
            } else {
                for(int[] d: Direction) {
                    int neighbourRow = p.a + d[0];
                    int neighbourCol = p.b + d[1];

                    // System.out.println("[" + neighbourRow + "," + neighbourCol + "]");
                    boolean isValidRowIndex = neighbourRow  > -1  && neighbourRow < R;
                    boolean isValidColIndex = neighbourCol  > -1  && neighbourCol < C;

                    if(isValidRowIndex && isValidColIndex) {
                        if(grid[neighbourRow][neighbourCol] == FRESH) {
                            freshCount--;
                            grid[neighbourRow][neighbourCol] = ROTTEN;
                            pair.offer(new Pair(neighbourRow, neighbourCol));
                        }
                    }
                }
            }
        }

        // System.out.println("ElapsedTime: " + elapsedTime + " freshCount: " + freshCount);
        return freshCount == 0 ? elapsedTime : -1;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {2}
        };

        RottingOranges ro = new RottingOranges();
        int rot = ro.orangesRotting(mat);
        System.out.println("Rot timing: " + rot);
    }
}