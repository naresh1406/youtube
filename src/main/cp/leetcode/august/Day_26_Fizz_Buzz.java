package main.cp.leetcode.august;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day_26_Fizz_Buzz {
    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> list = new ArrayList();
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0)
                    list.add("FizzBuzz");
                else if (i % 5 == 0)
                    list.add("Buzz");
                else if (i % 3 == 0)
                    list.add("Fizz");
                else
                    list.add(Integer.toString(i));
            }

            return list;
        }
    }

    // 2. 1-Liner using Streams
    class Solution2 {
        public List<String> fizzBuzz(int n) {
            return IntStream.rangeClosed(1, n).mapToObj(x -> x % 3 == 0 && x % 5 ==0 ?  "FizzBuzz" : x % 3 == 0 ? "Fizz" : x % 5 == 0 ? "Buzz" : Integer.toString(x)).collect(Collectors.toList());
        }
    }
}
