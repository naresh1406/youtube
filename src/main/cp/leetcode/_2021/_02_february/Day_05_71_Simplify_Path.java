package main.cp.leetcode._2021._02_february;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Naresh Gupta on 6/2/2021 AD.
 * Detailed Blackboard Video Explanation https://youtu.be/kVylYewnQ_k?t=0
 */
public class Day_05_71_Simplify_Path {
    // TC - O(N)

    class Solution {
        public String simplifyPath(String path) {
            Stack<String> stack = new Stack();
            for (String token : path.split("/")) {
                if (!stack.isEmpty() && "..".equals(token))
                    stack.pop();
                else if (!Arrays.asList(".", "", "..").contains(token))
                    stack.push(token);
            }

            return "/" + String.join("/", stack);
        }
    }
}
