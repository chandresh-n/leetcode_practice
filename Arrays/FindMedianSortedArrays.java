public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        if (nums1.length > nums2.length) {
            temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        int[] partitions = new int[2];
        partitions = findPartition(nums1, nums2);
        if ((nums1.length + nums2.length) % 2 == 0) {
            if (partitions[1] == 0 && partitions[0] < nums1.length) {
                return (nums1[partitions[0] - 1] + Math.min(nums1[partitions[0]], nums2[partitions[1]])) / 2;
            } else if (partitions[0] == 0 && partitions[1] < nums2.length) {
                return (nums2[partitions[1] - 1] + Math.min(nums1[partitions[0]], nums2[partitions[1]])) / 2;
            } else if (partitions[1] == 0 && partitions[0] == nums1.length) {
                return (nums1[partitions[0] - 1] + nums2[partitions[1]]) / 2.0;
            } else if (partitions[0] == 0 && partitions[1] == nums2.length) {
                return (nums2[partitions[1] - 1] + nums1[partitions[0]]) / 2.0;
            }
            return (Math.max(nums1[partitions[0] - 1], nums2[partitions[1] - 1])
                    + Math.min(nums1[partitions[0]], nums2[partitions[1]])) / 2.0;
        } else {
            // add conditions here
            if (partitions[0] == 0) {
                return nums2[partitions[1] - 1];
            } else if (partitions[1] == 0) {
                return nums1[partitions[0] - 1];
            } else if (partitions[1] == 0 && partitions[0] == 0) {
                return 0;
            }
            return Math.max(nums1[partitions[0] - 1], nums2[partitions[1] - 1]);

        }
    }

    public static int[] findPartition(int[] nums1, int[] nums2) {
        int partitionNums1 = Math.max((nums1.length - 1) / 2, 0);
        int partitionNums2 = ((nums1.length + nums2.length + 1) / 2) - partitionNums1;
        while ((partitionNums2 != 0 && partitionNums1 != 0 && partitionNums1 != nums1.length
                && partitionNums2 != nums2.length)
                && (nums1[partitionNums1 - 1] > nums2[partitionNums2]
                        || nums2[partitionNums2 - 1] > nums1[partitionNums1])) {
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
        return returnValues;
    }

    public static void main(String[] args) {
        int[] intArray = new int[2];
        intArray[0] = 1;
        intArray[1] = 3;
        // intArray[2] = 3;
        // intArray[3] = 4;

        int[] intArray2 = new int[1];
        intArray2[0] = 2;
        // intArray2[1] = 4;
        // intArray2[2] = 3;
        // intArray2[3] = 4;
        // intArray[4] = -1;
        // intArray[5] = -4;
        // intArray[6] = 1;
        // intArray[7] = -5;
        // intArray[8] = 4;
        double returnValue = FindMedianSortedArrays.findMedianSortedArrays(intArray, intArray2);
        System.out.println(returnValue);

    }
}
