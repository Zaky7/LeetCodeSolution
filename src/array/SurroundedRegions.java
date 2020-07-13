import util.Util;

class SurroundedRegions {

    public void solve(char[][] board) {
        int R = board.length - 1;
        int C = board[0].length - 1;

        int[][] dp = new int[R+1][C+1];

        // Mark arrays as -1 if O otherwise mark as 0
        for(int r=0; r<= R; r++) {
            for(int c=0; c<=C; c++) {
                if(board[r][c] == 'X') {
                    dp[r][c] = 0;
                } else {
                    dp[r][c] = -1;
                }
            }
        }

        // Moving first and last row
        for(int c=0; c<=C; c++) {
            // if O and not visited
            if(board[0][c] == 'O' && dp[0][c] == -1) {
                dp[0][c] = 1;
                markOneRecursively(dp, board, 0, c, R, C);
            }

            if(board[R][c] == 'O' && dp[R][c] == -1) {
                dp[R][c] = 1;
                markOneRecursively(dp, board, R, c, R, C);
            }
        }

        // Moving first and last row
        for(int r=0; r<=R; r++) {
            // if O and not visited
            if(board[r][0] == 'O' && dp[r][0] == -1) {
                dp[r][0] = 1;
                markOneRecursively(dp, board, r, 0, R, C);
            }

            if(board[r][C] == 'O' && dp[r][C] == -1) {
                dp[r][C] = 1;
                markOneRecursively(dp, board, r, C, R, C);
            }
        }

        for(int i=0; i<=R; i++) {
            for(int j=0; j<=C; j++) {
                if(dp[i][j] == -1) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private int getOneIfCharO(char ch) {
        return ch == 'O' ? 1 : 0;
    }

    private void markOneRecursively(int[][] dp, char[][] board, int r, int c, int R, int C) {

        // left exists and is unvisited
        // Mark s 1 if O otherwise 0
        if((c-1 >= 0) && dp[r][c-1] == -1) {
            dp[r][c-1] = getOneIfCharO(board[r][c-1]);
            markOneRecursively(dp, board, r, c-1, R, C);
        }

        // right exists and is unvisited
        // Mark as 1 if O otherwise 0
        if((c+1 <= C) && dp[r][c+1] == -1) {
            dp[r][c+1] = getOneIfCharO(board[r][c+1]);
            markOneRecursively(dp, board, r, c+1, R, C);
        }

        // bottom exists and is unvisited
        // Mark as 1 if O otherwise 0
        if((r+1 <=R) && dp[r+1][c] == -1) {
            dp[r+1][c] = getOneIfCharO(board[r+1][c]);
            markOneRecursively(dp, board, r+1, c, R, C);
        }

        // top exists and is unvisited
        // Mark as 1 if O otherwise 0
        if((r-1 >= 0) && dp[r-1][c] == -1) {
            dp[r-1][c] = getOneIfCharO(board[r-1][c]);
            markOneRecursively(dp, board, r-1, c, R, C);
        }

        return;
    }

    private void printBoard(char[][] board) {
        int R = board.length - 1;
        int C = board[0].length - 1;

        for(int i=0; i<=R; i++) {
            for(int j=0; j<=C; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {
            {'O','X','X','O'},
            {'X','O','X','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}};

        SurroundedRegions sr = new SurroundedRegions();
        sr.solve(board);
        sr.printBoard(board);

        String s1 = "dfafdsffewdadd";
        String str = "dsafdsfcwefcdefcwewefedwfweeedd";

        for(int i=1; i< (str.length() - s1.length()); i++) {
            System.out.println(str.substring(i, i + s1.length()));
        }
    }
}
