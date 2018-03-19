package _001_100;

public class _055_jumpGame {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 0, 4 };

        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }

        int len = nums.length;
        int maxStep = nums[0];

        for(int i = 0; i <= maxStep; i++) {
            if(nums[i] + i > maxStep) {
                maxStep = nums[i] + i;
            }

            if(maxStep > len - 1) {
                return true;
            }
        }

        return false;
    }
}
