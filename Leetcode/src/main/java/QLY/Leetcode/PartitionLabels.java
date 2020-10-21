package QLY.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] left = new int[26], right = new int[26];
        for (int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if (left[c - 'a'] == 0){
                left[c - 'a'] = i;
            }else {
                left[c - 'a'] = Math.min(left[c - 'a'], i);
            }
            right[c - 'a'] = Math.max(right[c - 'a'], i);
        }
        List<Integer> pos = new ArrayList<Integer>(), ans = new ArrayList<Integer>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            max = Math.max(right[c - 'a'], max);
            if (max == i){
                pos.add(i);
            }
        }
        for (int i = 0; i < pos.size(); i ++){
            if (i == 0){
                ans.add(pos.get(i) + 1);
            }else {
                ans.add(pos.get(i) - pos.get(i - 1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
