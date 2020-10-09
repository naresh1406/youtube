package main.cp.leetcode.october;

import java.util.Arrays;

public class Day_08_704_Binary_Search {
    // Iterative Binary Search
    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 0) return -1;
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }

    // Recursive Binary Search
    class Solution2 {
        public int search(int[] nums, int target) {
            return search(nums, 0, nums.length - 1, target);
        }

        public int search(int[] nums, int left, int right, int target) {
            if (left > right) return -1;
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return search(nums, left, mid - 1, target);
            } else {
                return search(nums, mid + 1, right, target);
            }
        }
    }

    // Arrays.binarySearch() Binary Search
    class Solution3 {
        public int search(int[] nums, int target) {
            int index = Arrays.binarySearch(nums, target);
            return index < 0 ? -1 : index;
        }
    }

    // Linear Search
    class Solution4 {
        public int search(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) return i;
                if (nums[i] > target) break;
            }
            return -1;
        }
    }
}
