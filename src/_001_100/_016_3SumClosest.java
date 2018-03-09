package _001_100;

import java.util.Arrays;

public class _016_3SumClosest {
    public static void main(String[] args) {
        int[] nums = { -1, 2, 1, -4, -1 };
        System.out.println(threeSumClosest(nums, 2));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int len = nums.length;
        int diff = Integer.MAX_VALUE;
        int tempDiff = 0;
        int result = 0;

        for(int i = 0; i < len - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int start = i + 1;
            int end = len - 1;
            int tempSum = 0;

            while(start < end) {
                tempSum = nums[i] + nums[start] + nums[end];

                if(tempSum == target) {
                    return target;
                } else {
                    tempDiff = Math.abs(tempSum - target);
                    if(tempDiff < diff) {
                        diff = tempDiff;
                        result = tempSum;
                    }

                    if(tempSum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }

        return result;
    }
}
