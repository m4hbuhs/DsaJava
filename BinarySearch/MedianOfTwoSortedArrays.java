import java.util.Arrays;

public class MedianOfTwoSortedArrays {
     public static double brute(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int[] arr = new int[n + m];
        int k = 0;
        for (int i = 0; i < n; i++) {
            arr[k++] = nums1[i];
        }
        for (int i = 0; i < m; i++) {
            arr[k++] = nums2[i];
        }
        Arrays.sort(arr);
        int total = n + m;
        if (total % 2 == 1) {
            return arr[total / 2];
        }
        return (arr[total / 2] + arr[total / 2 - 1]) / 2.0;
    }
    public static double better(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int i = 0;
        int j = 0;
        int prev = 0;
        int curr = 0;
        int total = n + m;
        for (int count = 0; count <= total / 2; count++) {
            prev = curr;
            if (i < n && (j >= m || nums1[i] <= nums2[j])) {
                curr = nums1[i];
                i++;
            } 
            else {
                curr = nums2[j];
                j++;
            }
        }
        if (total % 2 == 1) {
            return curr;
        }
        return (prev + curr) / 2.0;
    }
     public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length;
        int m = nums2.length;

        int low = 0;
        int high = n;

        while (low <= high) {

            int cut1 = low + (high - low) / 2;

            int cut2 = (n + m + 1) / 2 - cut1;

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];

            int right1 = (cut1 == n) ? Integer.MAX_VALUE : nums1[cut1];

            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int right2 = (cut2 == m) ? Integer.MAX_VALUE : nums2[cut2];
            // Correct partition
            if (left1 <= right2 && left2 <= right1) {
                // Odd total length
                if ((n + m) % 2 == 1) {
                    return Math.max(left1, left2);
                }
                // Even total length
                return (Math.max(left1, left2)
                        + Math.min(right1, right2)) / 2.0;
            }
            // We have taken too many elements from nums1
            else if (left1 > right2) {
                high = cut1 - 1;
            }
            // We have taken too few elements from nums1
            else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
    public static void main(String[] args) {
        int[] arr1={1,3,4,7,10,12};
        int[] arr2={2,3,6,15};
        System.out.println(brute(arr1, arr2));
        System.out.println(better(arr1, arr2));
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}