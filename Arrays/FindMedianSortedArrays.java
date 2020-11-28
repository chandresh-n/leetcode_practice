public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int indexOfInsertion = 0;
        int start = 0;
        int end = 0;
        if (nums1[nums1.length / 2] < nums2[0]) {
            start = nums1.length / 2;
            end = nums1.length + nums2.length;
        } else {
            start = 0;
            end = nums1.length / 2 + nums2.length;
        }
    }
}
