package _001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _015_3Sum {
    public static void main(String[] args) {
        int[] nums = { -2, 0, 0, 2, 2 };

        List<List<Integer>> res = threeSum(nums);

        for(List<Integer> list : res) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        int len = nums.length;
        List<Integer> temp = new ArrayList<>();

        for(int i = 0; i < len - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int tempSum = 0 - nums[i];
            int start = i + 1;
            int end = len - 1;

            while(start < end) {
                if(nums[start] + nums[end] == tempSum) {
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    res.add(new ArrayList<>(temp));
                    temp.clear();

                    while(start < end  && nums[start] == nums[start + 1]) {
                        start++;
                    }

                    while(start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }

                    start++;
                    end--;
                } else if(nums[start] + nums[end] > tempSum) {
                    end--;
                } else if(nums[start] + nums[end] < tempSum) {
                    start++;
                }
            }
        }

        return res;
    }
}
