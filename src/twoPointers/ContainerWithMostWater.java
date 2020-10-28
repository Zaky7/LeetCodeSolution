package twoPointers;

class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int n = height.length;

        for(int i=0; i<(n-1); i++) {

            for(int j=n-1; j>i; j--) {
                int currArea = (j - i) * Math.min(height[i], height[j]);

                maxArea = Math.max(currArea, maxArea);

                if(height[j] >= height[i]) {
                    break;
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater cwm = new ContainerWithMostWater();

        int[] height = {1,8,6,2,5,4,8,3,7};

        int maximumArea = cwm.maxArea(height);

        System.out.println(maximumArea);

    }
}