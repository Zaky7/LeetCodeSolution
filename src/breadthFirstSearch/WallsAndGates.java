package breadthFirstSearch;

import util.Util;

import java.util.LinkedList;
import java.util.Queue;

class WallsAndGates {

    private static final int OBSTACLE = -1;
    private static final int GATE = 0;
    private static final int EMPTY_ROOM = 2147483647;


    static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public void wallsAndGates(int[][] rooms) {

        Queue<Pair> queue = new LinkedList<>();
        int R = rooms.length;

        if(R == 0) {
            return;
        }

        int C = rooms[0].length;


        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(rooms[i][j] == GATE) {
                    queue.offer(new Pair(i,j));
                }
            }
        }

        // Add delemiter to the queue
        queue.offer(new Pair(-1, -1));

        // System.out.println("Queue size: " + queue.size());

        int[][] Directions = {{-1, 0}, {1,0}, {0,1}, {0,-1}};

        while(!queue.isEmpty()) {
            Pair p = queue.poll();

            // Delimiter encountered
            if(p.a == -1) {
                if(!queue.isEmpty()) {
                    queue.offer(new Pair(-1,-1));
                }
            } else {
                for(int[] d: Directions) {
                    int neighbourRow = p.a + d[0];
                    int neighbourCol = p.b + d[1];

                    boolean isValidRow = neighbourRow < R && neighbourRow > -1;
                    boolean isValidCol = neighbourCol < C && neighbourCol > -1;

                    if(isValidRow && isValidCol) {
                        int distance = 1 + rooms[p.a][p.b];

                        // EMPTY ROOM
                        if(rooms[neighbourRow][neighbourCol] == OBSTACLE || rooms[neighbourRow][neighbourCol] == GATE) {
                        } else {
                            if(distance < rooms[neighbourRow][neighbourCol]) {
                                rooms[neighbourRow][neighbourCol] =  distance;
                                queue.offer(new Pair(neighbourRow, neighbourCol));
                            }
                        }
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};

        WallsAndGates wg = new WallsAndGates();
        wg.wallsAndGates(rooms);

        Util.print2DArray(rooms);
    }
}

