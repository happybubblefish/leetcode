package _001_100;

public class _080_removeDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };

        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int count = 1;
        int index = 1;

        for(int i = 1; i < len; i++) {
            if(nums[i] == nums[i - 1]) {
                count++;

                if(count <= 2) {
                    nums[index++] = nums[i];
                }
            } else {
                nums[index++] = nums[i];
                count = 1;
            }
        }

        return index;
    }
}
