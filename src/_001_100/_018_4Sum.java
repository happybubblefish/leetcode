package _001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _018_4Sum {
    public static void main(String[] args) {
        int[] nums = { 1, 0, -1, 0, -2, 2 };

        List<List<Integer>> res = fourSum(nums, 0);

        for(List<Integer> list : res) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        int len = nums.length;
        List<Integer> temp = new ArrayList<>();

        for(int i = 0; i < len - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int threeSum = target - nums[i];

            for(int j = i + 1; j < len - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int twoSum = threeSum - nums[j];
                int start = j + 1;
                int end = len - 1;

                while (start < end) {
                    int tempSum = nums[start] + nums[end];

                    if(tempSum == twoSum) {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);
                        res.add(new ArrayList<>(temp));
                        temp.clear();

                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }

                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }

                        start++;
                        end--;
                    } else if(tempSum > twoSum) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }

        return res;
    }
}
