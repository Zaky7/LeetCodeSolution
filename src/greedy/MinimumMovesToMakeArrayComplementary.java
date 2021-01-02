package greedy;

import java.util.*;

class MinimumMovesToMakeArrayComplementary {

    static class Point {
        private int coordinate;
        private int typeId;

        Point(int coordinate, int typeId) {
            this.coordinate = coordinate;
            this.typeId = typeId;
        }
    };

    public int minMoves(int[] nums, int limit) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        List<Point> points = new ArrayList<>();
        this.constructSegmentsAndPoints(nums, limit, points);

        int cost = n;
        int result = cost;

        int k = 0;

        while ( k < points.size()) {
            int k_copied = k;

            int compensate = 0;

            // k will always increase by at least 1 in the inner while block
            while (k < points.size() && points.get(k).coordinate == points.get(k_copied).coordinate) {
                Point p = points.get(k);

                if (p.typeId == 0) {
                    --cost;
                } else if (p.typeId == 1) {
                    --cost;
                    ++compensate;
                } else {
                    ++compensate;
                }
                ++k;
            }

            result = Math.min(result, cost);
            cost += compensate;
        }

        return result;
    }

    void constructSegmentsAndPoints(int[] nums, int limit, List<Point> points) {
        int n = nums.length;
        for (int i = 0; i < n / 2; ++i) {
            int a = Integer.min(nums[i], nums[n - 1 - i]);
            int b = Integer.max(nums[i], nums[n - 1 - i]);

            points.add(new Point(a+b, 1));
            points.add(new Point(a+1, 0));

            if (a != limit) {
                points.add(new Point(b + limit, 2));
            }
        }

        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Integer.compare(o1.coordinate, o2.coordinate);
            }
        });
    }

    public static void main(String[] args) {
        int[] nums = {20744,7642,19090,9992,2457,16848,3458,15721};
        int limit = 22891;

        MinimumMovesToMakeArrayComplementary mvt = new MinimumMovesToMakeArrayComplementary();

        int minMoves = mvt.minMoves(nums,limit);

        System.out.println("Minimum moves are: " + minMoves);

    }
}
