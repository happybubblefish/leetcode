package _001_100;

public class _031_nextPermutation {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 3, 1, 1, 3 };

        nextPermutation(nums);

        for(int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }

        int len = nums.length;
        int firstDecreaseIndex = -1;
        int firstLargerThanFirstDecreaseIndex = 0;

        for(int i = len - 1; i > 0; i--) {
            if(nums[i - 1] < nums[i]) {
                firstDecreaseIndex = i - 1;
                break;
            }
        }

        //Becareful the corner case. nums = { 2, 3, 3, 1, 3, 3}
        if(firstDecreaseIndex != -1) {
            int tempIncreaseIndex = firstDecreaseIndex + 1;

            for(int i = firstDecreaseIndex + 1; i < len; i++) {
                if(nums[i] > nums[firstDecreaseIndex]) {
                    if(nums[tempIncreaseIndex] >= nums[i]) {
                        tempIncreaseIndex = i;
                    }
                }
            }

            int temp = nums[firstDecreaseIndex];
            nums[firstDecreaseIndex] = nums[tempIncreaseIndex];
            nums[tempIncreaseIndex] = temp;

            reverse(nums, firstDecreaseIndex + 1, len - 1);
        } else {
            reverse(nums, 0, len - 1);
        }
    }

    private static void reverse(int[] nums, int start, int end) {
        for(int i = start; i <= start + (end - start) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[start + end - i];
            nums[start + end - i] = temp;
        }
    }

//    public static void nextPermutation(int[] nums) {
//        if(nums == null || nums.length == 0){
//            return;
//        }
//
//        int partitionIndex = -1;
//        int divideIndex = -1;
//        int numsLen = nums.length;
//
//        for(int i = numsLen - 2; i >= 0; i--){
//            if(nums[i] < nums[i + 1]){
//                partitionIndex = i;
//                break;
//            }
//        }
//
//        //must check this for {3, 2, 1} case
//        if(partitionIndex == -1){
//            reverse(nums, 0, numsLen - 1);
//            return;
//        }
//
//        for(int i = numsLen - 1; i >= 0; i--){
//            if(nums[i] > nums[partitionIndex]){
//                divideIndex = i;
//                break;
//            }
//        }
//
//        swap(nums, partitionIndex, divideIndex);
//
//        reverse(nums, partitionIndex + 1, numsLen - 1);
//    }
//
//    private static void reverse(int[] nums, int start, int end) {
//        for(int i = start; i <= (start + end) / 2; i++){
//            swap(nums, i, start + end - i);
//        }
//    }
//
//    private static void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
}
