package main.cp.leetcode.september;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Day_30_First_Missing_Positive {
    // TC - O(n) && SC - O(n)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            // Set<Integer> set = new HashSet();
            // for(int num : nums) set.add(num);
            Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            int i = 1;
            while (set.contains(i)) i++;
            return i;
        }
    }

    // TC - O(n) && SC - O(n)
    class Solution2 {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            if (n == 0) return 1;

            int[] bucket = new int[n];
            for (int num : nums) {
                if (num > 0 && num <= n) {
                    bucket[num - 1]++;
                }
            }

            int i = 0;
            while (i < n && bucket[i] != 0) {
                i++;
            }
            return i + 1;
        }
    }

    // TC - O(n) && SC - O(1)
    class Solution3 {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;

            for (int i = 0; i < n; i++) {
                if (nums[i] <= 0 || nums[i] > n) {
                    nums[i] = n + 1;
                }
            }

            for (int i = 0; i < n; i++) {
                int num = Math.abs(nums[i]);
                if (num > n) continue;
                num--;
                if (nums[num] > 0) {
                    nums[num] = -1 * nums[num];
                }
            }

            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }

            return n + 1;
        }
    }

    // TC - O(n) && SC - O(1)
    class Solution4 {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;

            for (int i = 0; i < n; i++) {
                while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                }
            }

            for (int i = 0; i < n; ++i) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }

            return n + 1;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
