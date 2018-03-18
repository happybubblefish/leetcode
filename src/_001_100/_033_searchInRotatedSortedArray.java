package _001_100;

public class _033_searchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 1, 2  };

        System.out.println(search(nums, 1));
    }

    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int len = nums.length;

        int pivot = 0;

        for(int i = 0; i < len - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                pivot = i + 1;
            }
        }

        if(pivot != 0 && target >= nums[0] && target <= nums[pivot - 1]) {
            return helper(nums, target, 0, pivot - 1);
        } else {
            return helper(nums, target, pivot, len - 1);
        }
    }

    private static int helper(int[] nums, int target, int start, int end) {
        int mid = 0;

        while(start <= end) {
            mid = (start + end) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
