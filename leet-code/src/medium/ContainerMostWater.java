package medium;

public class ContainerMostWater {

    public static void main(String[] args) {
        // [1,8,6,2,5,4,8,3,7]
        int[] waterLevel = {1, 1, 3};
        ContainerMostWater mostWater = new ContainerMostWater();
        System.out.println("Maximum area of water : " + mostWater.maxArea(waterLevel));
    }

    public int maxArea(int[] height) {
        long startTime = System.currentTimeMillis() * 1000;
        int maxArea = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        while (leftIndex < rightIndex) {
            int width = (rightIndex - leftIndex);
            int leftValue = height[leftIndex];
            int rightValue = height[rightIndex];

            int minHeight = Math.min(leftValue, rightValue);
            int area = width * minHeight;

            if (area > maxArea) {
                maxArea = area;
            }

            while (height[leftIndex] <= minHeight && leftIndex < rightIndex) {
                leftIndex++;
            }

            while (height[rightIndex] <= minHeight && leftIndex < rightIndex) {
                rightIndex--;
            }
        }
        long endTime = System.currentTimeMillis() * 1000;
        System.out.println("Time taken : " + (endTime - startTime) + " milli seconds");
        return maxArea;
    }
}
