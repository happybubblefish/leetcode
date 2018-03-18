package _001_100;

public class _035_searchInsertPosition {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5 };

        System.out.println(searchInsert(nums, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;

        if(target < nums[0]) {
            return 0;
        }

        if(target > nums[len - 1]) {
            return len;
        }

        int start = 0;
        int end = len - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}
