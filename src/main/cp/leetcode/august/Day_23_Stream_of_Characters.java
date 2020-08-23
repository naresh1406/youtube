package main.cp.leetcode.august;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day_23_Stream_of_Characters {
    class StreamChecker {

        private StringBuilder sb; // reference for sb
        private TrieNode root; // reference for trie root

        public StreamChecker(String[] words) {
            sb = new StringBuilder(); // initialize sb
            root = new TrieNode(); // initialize trie root
            for (String word : words)
                insert(word); // insert word in trie
        }

        public boolean query(char letter) {
            sb.append(letter); // append letter in sb
            TrieNode node = root; // start from root of trie
            for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
                char c = sb.charAt(i);
                node = node.next.get(c);
                if (node != null && node.isWord) {
                    return true;
                }
            }
            return false;
        }

        /*** Defined TrieNode */
        class TrieNode {
            Map<Character, TrieNode> next;
            boolean isWord;

            public TrieNode() {
                next = new HashMap();
            }
        }

        /*** Inserts a word into the trie from reverse side*/
        public void insert(String word) {
            TrieNode current = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                TrieNode node = current.next.getOrDefault(c, new TrieNode());
                current.next.put(c, node);
                current = node;
            }
            current.isWord = true; // mark isWord true after processing all character in word
        }
    }

    // Brute Force
    class StreamChecker2 {

        private StringBuilder sb;
        private Set<String> set;

        public StreamChecker2(String[] words) {
            sb = new StringBuilder();
            set = new HashSet();
            for (String word : words)
                set.add(word);
        }

        public boolean query(char letter) {
            sb.append(letter);
            int len = sb.length();
            for (int i = len - 1; i >= 0; i--) {
                if (set.contains(sb.substring(i, len)))
                    return true;
            }
            return false;
        }
    }
}
