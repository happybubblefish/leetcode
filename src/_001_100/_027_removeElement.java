package _001_100;

public class _027_removeElement {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 8 };

        System.out.println(removeElement(nums, 0));
    }

    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int index = 0;

        for(int i = 0; i < len; i++) {
            if(nums[i] != val) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}
