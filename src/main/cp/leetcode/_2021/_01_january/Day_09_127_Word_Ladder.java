package main.cp.leetcode._2021._01_january;

import java.util.*;

/**
 * Created by Naresh Gupta on 10/1/2021 AD.
 */
public class Day_09_127_Word_Ladder {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet(wordList);
            Queue<String> queue = new LinkedList();
            Set<String> visited = new HashSet();
            queue.add(beginWord);
            visited.add(beginWord);

            int level = 0;
            while (!queue.isEmpty()) {
                for (int size = queue.size(); size > 0; size--) {
                    String word = queue.poll();
                    if (word.equals(endWord))
                        return level + 1;
                    char[] ch = word.toCharArray();
                    for (int i = 0; i < ch.length; i++) {
                        char backup = ch[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            ch[i] = c;
                            String nextWord = String.valueOf(ch);
                            if (!visited.contains(nextWord) && wordSet.contains(nextWord)) {
                                queue.add(nextWord);
                                visited.add(nextWord);
                            }
                        }
                        ch[i] = backup;
                    }
                }
                level++;
            }

            return 0;
        }
    }

    // Usw wordSet as it visited itself
    class Solution2 {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet(wordList);
            Queue<String> queue = new LinkedList();
            queue.add(beginWord);
            wordSet.remove(beginWord);

            int level = 0;
            while (!queue.isEmpty()) {
                for (int size = queue.size(); size > 0; size--) {
                    String word = queue.poll();
                    if (word.equals(endWord))
                        return level + 1;
                    char[] ch = word.toCharArray();
                    for (int i = 0; i < ch.length; i++) {
                        char backup = ch[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            ch[i] = c;
                            String nextWord = String.valueOf(ch);
                            if (wordSet.contains(nextWord)) {
                                queue.add(nextWord);
                                wordSet.remove(nextWord);
                            }
                        }
                        ch[i] = backup;
                    }
                }
                level++;
            }

            return 0;
        }
    }
}
