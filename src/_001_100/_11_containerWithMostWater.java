package _001_100;

public class _11_containerWithMostWater {
    public static void main(String[] args) {
        int[] height = { 1, 1, 1, 1, 1 };
        System.out.println(maxArea(height));
    }

    //Optimization can be done: as long current low > next low, keep moving.
    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        int high = 0;

        while (start < end) {
            high = Math.min(height[start], height[end]);
            max = Math.max(max, (end - start) * high);

            if(height[start] > height[end]){
                end--;
            } else{
                start++;
            }
        }

        return max;
    }
}
