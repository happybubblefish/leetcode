package _001_100;

public class _075_sortColors {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 1 };

        sortColors(nums);

        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }

        int len = nums.length;

        int red = -1;
        int blue = len - 1;

        for(int i = 0; i < len; i++) {
            if(nums[i] == 0) {
                red++;
                swap(nums, i, red);
            } else if(nums[i] == 2) {
                if(i >= blue) {
                    break;
                }

                swap(nums, i, blue);
                i--;
                blue--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
