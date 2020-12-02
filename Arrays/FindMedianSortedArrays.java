public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        if (nums1.length > nums2.length) {
            temp = nums2;
            nums2 = nums1;
            nums1 = nums2;
        }
        int[] partitions = new int[2];
        partitions = findPartition(nums1, nums2);
        if((nums1.length + nums2.length) % 2 ==0){
            return Math.max(nums1[partitions[0] - 1], nums2[partitions[1] - 1]) + Math.min(nums1[partitions[0]], nums2[partitions[1]]) / 2;
        }
        else {
            return Math.min( )
        }
    }

    public static int[] findPartition(int[] nums1, int[] nums2) {
        int partitionNums1 = nums1.length / 2;
        int partitionNums2 = ((nums1.length + nums2.length + 1) / 2) - partitionNums1;
        while (nums1[partitionNums1 - 1] > nums2[partitionNums2] || nums2[partitionNums2 - 1] > nums1[partitionNums1]) {
            if (nums1[partitionNums1 - 1] > nums2[partitionNums2]) {
                partitionNums1--;
                partitionNums2 = ((nums1.length + nums2.length + 1) / 2) - partitionNums1;
            } else {
                partitionNums1++;
                partitionNums2 = ((nums1.length + nums2.length + 1) / 2) - partitionNums1;
            }
        }
        int[] returnValues = new int[2];
        returnValues[0] = partitionNums1;
        returnValues[1] = partitionNums2;
    }
}
