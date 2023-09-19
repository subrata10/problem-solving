package hard;

public class TrappingRainWater {
    public static void main(String[] args) {
        Integer[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        int max = 0;
        int[] maxLeft = new int[height.length];

        for(int i=1; i<height.length; i++) {
            max = Math.max(height[i-1], max);
            maxLeft[i] = max;
        }

        int[] maxRight = new int[height.length];
        max = 0;
        for (int j=height.length-2; j>=0; j--) {
            max = Math.max(height[j+1], max);
            maxRight[j] = max;
        }

        // Required water block = Min(maxLeft, maxRight) - height[i]
        int sum = 0;
        for(int i=0; i<height.length; i++) {
            int requiredWater = Math.min(maxLeft[i], maxRight[i]) - height[i];
            sum = sum + (requiredWater  <= 0? 0 : requiredWater);
        }

        System.out.println(sum);
    }
}
