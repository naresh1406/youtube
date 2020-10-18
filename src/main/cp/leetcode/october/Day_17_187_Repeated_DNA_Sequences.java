package main.cp.leetcode.october;

import java.util.*;
import java.util.stream.Collectors;

public class Day_17_187_Repeated_DNA_Sequences {
    // Two Sets

    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            Set<String> set = new HashSet(), repeated = new HashSet();
            for (int i = 0; i < s.length() - 9; i++) {
                String dna = s.substring(i, i + 10);
                if (set.contains(dna))
                    repeated.add(dna);
                set.add(dna);
            }
            return new ArrayList(repeated);
        }
    }

    // Map

    class Solution2 {
        public List<String> findRepeatedDnaSequences(String s) {
            Map<String, Integer> freq = new HashMap();
            for (int i = 0; i < s.length() - 9; i++) {
                String dna = s.substring(i, i + 10);
                freq.put(dna, freq.getOrDefault(dna, 0) + 1);
            }

            List<String> list = new ArrayList();
            for (Map.Entry<String, Integer> e : freq.entrySet())
                if (e.getValue() > 1)
                    list.add(e.getKey());

            return list;
        }
    }

    class Solution3 {
        public List<String> findRepeatedDnaSequences(String s) {
            Map<String, Integer> freq = new HashMap();
            for (int i = 0; i < s.length() - 9; i++) {
                String dna = s.substring(i, i + 10);
                freq.put(dna, freq.getOrDefault(dna, 0) + 1);
            }
            return freq.entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toList());
        }
    }

    // Rolling Hash

    class Solution4 {
        public List<String> findRepeatedDnaSequences(String s) {
            if (s.length() < 10) return new ArrayList();

            Set<String> result = new HashSet();

            int size = 10;
            int R = 101;
            Map<Long, List<Integer>> map = new HashMap();
            long patHash = 0;
            for (int j = 0; j < size; j++) patHash = (R * patHash + s.charAt(j));
            map.computeIfAbsent(patHash, k -> new ArrayList()).add(0);

            // pre-compute R^(m-1) % q for use in removing leading digit
            long RM = 1;
            for (int i = 1; i <= size - 1; i++)
                RM = (R * RM);

            for (int i = size; i < s.length(); i++) {
                // Remove leading digit, add trailing digit, check for match.
                patHash = (patHash - RM * s.charAt(i - size));
                patHash = (patHash * R + s.charAt(i));
                if (map.containsKey(patHash)) {
                    for (int index : map.get(patHash))
                        if (s.substring(index, index + size).equals(s.substring(i - size + 1, i + 1)))
                            result.add(s.substring(i - size + 1, i + 1));
                }
                map.putIfAbsent(patHash, new ArrayList());
                map.get(patHash).add(i - size + 1);
            }

            return new ArrayList(result);
        }
    }
}
