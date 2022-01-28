package QLY.Leetcode.greedy;

/**
 * https://leetcode-cn.com/problems/shortest-way-to-form-string/
 * 1055. 形成字符串的最短路径
 * 对于任何字符串，我们可以通过删除其中一些字符（也可能不删除）来构造该字符串的子序列。
 * 给定源字符串 source 和目标字符串 target，找出源字符串中能通过串联形成目标字符串的子序列的最小数量。如果无法通过串联源字符串中的子序列来构造目标字符串，则返回 -1。
 */
public class ShortestWayToFormString {
    public int shortestWay(String source, String target) {
        int i = 0;
        int count = 0;
        while (i < target.length()){
            count++;
            int j = i;
            for (int k = 0; k < source.length() && j < target.length(); k++) {
                if (source.charAt(k) == target.charAt(j))
                    j++;
            }
            if (i == j)
                return -1;
            i = j;
        }
        return count;
    }

    public static void main(String[] args) {
        ShortestWayToFormString shortestWayToFormString = new ShortestWayToFormString();
        System.out.println(shortestWayToFormString.shortestWay("abc", "abcbc"));
        System.out.println(shortestWayToFormString.shortestWay("abc", "acdbc"));
        System.out.println(shortestWayToFormString.shortestWay("xyz", "xzyxz"));
    }
}
