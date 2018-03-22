package _001_100;

public class _088_mergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = { 1, 3, 5, 0, 0, 0 };
        int[] nums2 = { 4, 6, 7 };

        merge(nums1, 3, nums2, 3);

        for(int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int indexM = m - 1;
        int indexN = n - 1;

        while(indexM >= 0 && indexN >= 0) {
            if(nums1[indexM] > nums2[indexN]) {
                nums1[index] = nums1[indexM--];
            } else {
                nums1[index] = nums2[indexN--];
            }

            index--;
        }

        while(indexN >= 0) {
            nums1[index--] = nums2[indexN--];
        }
    }
}
