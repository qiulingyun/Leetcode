package QLY.Leetcode.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k){
        if (k <= 0){
            return null;
        }

        // 1, 2, 3, 4   choose 2
        // [1,2], [1,3], [1,4], [2, 3]

        List<List<Integer>> results = new ArrayList<>();

        backtrace(results, new LinkedList<>(), 1, n, k);

        return results;
    }

    public void backtrace(List<List<Integer>> results, LinkedList<Integer> path, int currIndex, int n, int k){
        if (path.size() == k){  // out-entrance
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(path);
            results.add(tmp);
            return;
        }

        for (int i = currIndex; i <= n; i++){
//            if (path.contains(i)){
//                continue;
//            }

            path.addLast(i);
            backtrace(results, path, i+1, n, k);
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        System.out.println(combine.combine(4, 2));
    }
}
