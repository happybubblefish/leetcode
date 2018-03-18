package _001_100;

public class _026_removeDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1 };

        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null) {
            return 0;
        }

        int len = nums.length;
        int index = 0;

        for(int i = 1; i < len; i++) {
            if(nums[i] != nums[i - 1]) {
                index++;
                nums[index] = nums[i];
            }
        }

        return index + 1;
    }
}
