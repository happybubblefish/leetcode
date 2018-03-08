package _001_100;

import java.util.HashMap;
import java.util.Map;

public class _001_twoSum {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5, 7};

        int[] result = twoSum(nums, 7);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        int size = nums.length;

        for(int i = 0; i < size; i++) {
            if(map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                break;
            } else{
                map.put(target - nums[i], i);
            }
        }

        return result;
    }
}
