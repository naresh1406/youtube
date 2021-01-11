package main.cp.leetcode._2021._01_january;

/**
 * Created by Naresh Gupta on 11/1/2021 AD.
 * Detailed Video Explanation https://youtu.be/6VxG9d7MRiQ?t=0
 */
public class Day_11_88_Merge_Sorted_Array {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int l = nums1.length - 1;
            m--;
            n--;
            while (m >= 0 && n >= 0) {
                if (nums1[m] > nums2[n])
                    nums1[l--] = nums1[m--];
                else
                    nums1[l--] = nums2[n--];
            }

            while (n >= 0)
                nums1[l--] = nums2[n--];
        }
    }

    class Solution2 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            while (m > 0 && n > 0)
                nums1[m + n - 1] = nums1[m - 1] > nums2[n - 1] ? nums1[--m] : nums2[--n];

            while (n > 0)
                nums1[m + n - 1] = nums2[--n];
        }
    }

    // Recursive

    class Solution3 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (n <= 0)
                return;
            if (m > 0 && nums1[m - 1] > nums2[n - 1])
                nums1[m + n - 1] = nums1[--m];
            else
                nums1[m + n - 1] = nums2[--n];
            merge(nums1, m, nums2, n);
        }
    }

    class Solution4 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (n <= 0)
                return;
            nums1[m + n - 1] = m > 0 && nums1[m - 1] > nums2[n - 1] ? nums1[--m] : nums2[--n];
            merge(nums1, m, nums2, n);
        }
    }
}
