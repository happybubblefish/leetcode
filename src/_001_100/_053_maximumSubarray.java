package _001_100;

public class _53_maximumSubarray {
    public static void main(String[] args) {
        int[] nums = { -2, -1, 0, -3 };

        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int len = nums.length;

        int start = 0;
        int curr = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        while(start + curr < len) {
            sum += nums[start + curr];

            if(sum > max) {
                max = sum;
            }

            if(sum < 0) {
                sum = 0;
                start++;
                curr = 0;
                continue;
            }

            curr++;
        }

        return max;
    }
}
