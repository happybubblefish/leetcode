package _001_100;

public class _034_searchForARange {
    public static void main(String[] args) {
        int[] nums = { 1, 5, 5, 5, 5, 5 };

        int[] res = searchRange(nums, 5);

        for(int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = { -1, -1 };

        if(nums == null || nums.length == 0) {
            return result;
        }

        int len = nums.length;
        int start = 0;
        int end = len - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(nums[mid] == target) {
                result[0] = result[1] = mid;
                break;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if(result[0] == -1) {
            return result;
        }

        start = 0;
        end = result[0];

        while(start <= end) {
            int mid = (start + end) / 2;

            if(nums[mid] == target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        result[0] = start;

        start = result[1];
        end = len - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(nums[mid] == target) {
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }

        result[1] = start - 1;

        return result;
    }
}
