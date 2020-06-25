import static util.Util.print2DArrayLeetCodeFormat;


class RotateImage {

    private class Position {
        int posX = -1;
        int posY = -1;
        int N = 0;
        int steps = 0;
        int baseX = -1;
        int baseY = -1;

        Position(int i, int j, int baseX, int baseY, int N) {
            this.posX = i;
            this.posY = j;
            this.baseX = baseX;
            this.baseY = baseY;
            this.N = N;
            this.steps = N - 1;
        }


        @Override
        public String toString() {
            return "(" + "i=" + posX + ", j=" + posY + ") ";
        }

        private void reInitializeSteps() {
            this.steps = this.N - 1;
        }

        private boolean isFirstRow() {
            return posX == baseX && posY < ((N - 1) + baseY);
        }

        private boolean isLastCol() {
            return posY == ((N - 1) + baseY) && posX < ((N - 1) + baseX);
        }

        private boolean isLastRow() {
            return posX == ((N - 1) + baseX) && posY > baseY;
        }

        private boolean isFirstCol() {
            return posY == baseY && posX > baseX;
        }

        private void moveLeft() {
            while(steps != 0 && posY > baseY) {
                posY--;
                steps--;
            }
        }

        private void moveRight() {
            while(steps != 0 && posY < ((N - 1) + baseY)) {
                posY++;
                steps--;
            }
        }

        private void moveDown() {
            while(steps != 0 && posX < ((N - 1) + baseX)) {
                posX++;
                steps--;
            }
        }

        private void moveUp() {
            while(steps != 0 && posX > baseX) {
                posX--;
                steps--;
            }
        }

        private void moveToNextPosition() {
            if(isFirstRow()) {
                // R -> D -> L -> U
                moveRight();
                moveDown();
                moveLeft();
                moveUp();
            } else if(isLastCol()) {
                // D -> L -> U -> R
                moveDown();
                moveLeft();
                moveUp();
                moveRight();
            } else if(isLastRow()) {
                // L -> U -> R -> D
                moveLeft();
                moveUp();
                moveRight();
                moveDown();
            } else if(isFirstCol()) {
                // U -> R -> D -> L
                moveUp();
                moveRight();
                moveDown();
                moveLeft();
            } else {
                System.out.println("Not in Boundary Position X: " + posX + " Position Y: ");
            }

            reInitializeSteps();
        }

    }

    public void rotate(int[][] matrix) {
        int N = matrix.length;
        rotateMatrixUtil(matrix, 0, 0, N);
    }

    private void rotateMatrixUtil(int[][]matrix, int baseX, int baseY, int N) {
        if(N <= 1) {
            return;
        }

        for(int j=baseY; j<(baseX + (N-1)); j++) {
            int currentI = baseX;
            int currentJ = j;

            Position co = new Position(currentI, currentJ, baseX, baseY, N);
            int preValue = matrix[currentI][currentJ];

            int rotationCount = 4;
            while(rotationCount != 0) {
//                System.out.print(" (" + co.posX + "," + co.posY + ") ");
                co.moveToNextPosition();
                int temp = matrix[co.posX][co.posY];
                matrix[co.posX][co.posY] = preValue;
                preValue = temp;
                rotationCount --;
            }
        }

        rotateMatrixUtil(matrix, baseX+1, baseY+1, N-2);
    }

    public static void main(String[] args) {
        RotateImage ri = new RotateImage();
        int N = 7;
        int[][] matrix = ri.generateMatrix(N);
        print2DArrayLeetCodeFormat(matrix,N);

        ri.rotate(matrix);

        System.out.println();
        System.out.println();
        print2DArrayLeetCodeFormat(matrix,N);

    }

    private int[][] generateMatrix(int N) {
        int [][] matrix = new int[N][N];

        int count = 1;
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = count;
                count++;
            }
        }
        return matrix;
    }
}