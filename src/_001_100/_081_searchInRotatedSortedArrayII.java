package _001_100;

public class _081_searchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = { 5, 5, 6, 8, 10, 1, 3, 3, 5, 5 };
        System.out.println(search(nums, 1));
    }

    public static boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return false;
        }

        int len = nums.length;
        int start = 0;
        int end = len - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] == target) {
                return true;
            }
        }

        return false;
    }
}
