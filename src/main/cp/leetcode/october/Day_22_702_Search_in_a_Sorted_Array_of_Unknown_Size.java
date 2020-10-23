package main.cp.leetcode.october;

interface ArrayReader {
    int get(int index);
}

class ArrayReaderImpl implements ArrayReader {
    int[] arr;

    public ArrayReaderImpl(int[] a) {
        arr = a;
    }

    @Override
    public int get(int index) {
        return index >= arr.length ? Integer.MAX_VALUE : arr[index];
    }
}

public class Day_22_702_Search_in_a_Sorted_Array_of_Unknown_Size {

    public static void main(String[] args) {
        Solution object = new Day_22_702_Search_in_a_Sorted_Array_of_Unknown_Size().new Solution();
        ArrayReader reader = new ArrayReaderImpl(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(object.search(reader, 9));
        System.out.println(object.search(reader, 4));
    }

    class Solution {
        public int search(ArrayReader reader, int target) {
            int left = 0, right = 1;
            while (reader.get(right) < target) {
                left = right;
                right *= 2;
            }

            int mid, num;
            while (left <= right) {
                mid = left + ((right - left) >> 1);
                num = reader.get(mid);

                if (num == target) return mid;
                else if (num > target) right = mid - 1;
                else left = mid + 1;
            }

            return -1;
        }
    }
}
