package QLY.Leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        if (strs.length == 0){
            results.add(new ArrayList<>());
            return results;
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for (String str :strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                if (count[i] == 0)
                    continue;
                key.append(String.valueOf('a' + i)).append(count[i]);
            }

            List<String> stringList = map.getOrDefault(key.toString(), new ArrayList<>());
            stringList.add(str);
            map.putIfAbsent(key.toString(), stringList);
        }

        results.addAll(map.values());

        return results;
    }


    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
