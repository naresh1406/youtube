package main.cp.leetcode._2021._05_may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Naresh Gupta on 19/5/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=fpyTsdja4a4¬
 */
public class Day_18_609_Find_Duplicate_File_in_System {
    class Solution {
        public List<List<String>> findDuplicate(String[] paths) {
            Map<String, List<String>> map = new HashMap();
            for (String path : paths) {
                String[] token = path.split(" ");
                String dir = token[0];
                for (int i = 1; i < token.length; i++) {
                    int index = token[i].indexOf('(');
                    String fileName = token[i].substring(0, index);
                    String content = token[i].substring(index + 1, token[i].length() - 1);
                    map.computeIfAbsent(content, l -> new ArrayList()).add(dir + "/" + fileName);
                }
            }

            List<List<String>> result = new ArrayList();
            for (List<String> val : map.values())
                if (val.size() > 1)
                    result.add(val);

            return result;
        }
    }
}
