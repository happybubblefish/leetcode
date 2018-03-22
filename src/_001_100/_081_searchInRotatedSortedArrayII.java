package _001_100;

public class _081_searchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = { 3, 1 };
        System.out.println(search(nums, 3));
    }

    public static boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return false;
        }

        int len = nums.length;
        int start = 0;
        int end = len - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(nums[mid] == target) {
                return true;
            } else if(nums[start] < nums[mid]) {
                if(target > nums[mid] || nums[start] > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if(nums[start] > nums[mid]) {
                if(target < nums[mid] || target > nums[end]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                start++;
            }
        }

        return false;
    }
}
