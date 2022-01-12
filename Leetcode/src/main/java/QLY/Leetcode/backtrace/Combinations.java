package QLY.Leetcode.backtrace;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> results = new LinkedList<>();
        backtrace(n, k, 1, path, results);
        return results;
    }
    /**
     *  n = 4, k = 2
     *   1, 2, 3, 4
     *                                           []
     *              [1]                      [2]              [3]      [4]
     *    [1,2]   [1,3]    [1,4]       [2,3]     [2,4]      [3,4]
     */

    private void backtrace(int n, int k, int curr, LinkedList<Integer> path, List<List<Integer>> results){
        if (path.size() == k){
            results.add(new LinkedList<>(path));
            return;
        }

        for (int i = curr; i <= n; i++) {
            path.add(i);
            backtrace(n, k, i + 1, path, results);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Combinations c = new Combinations();
        List<List<Integer>> lists = c.combine(4, 2);
        for (List<Integer> list :
                lists) {
            System.out.println(list.toString());
        }
    }
}
