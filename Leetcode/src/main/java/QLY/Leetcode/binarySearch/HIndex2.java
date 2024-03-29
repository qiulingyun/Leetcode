package QLY.Leetcode.binarySearch;

/**
 * https://leetcode-cn.com/problems/h-index-ii/
 * 275. H 指数 II
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，citations 已经按照 升序排列 。计算并返回该研究者的 h 指数。
 * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。且其余的 n - h 篇论文每篇被引用次数 不超过 h 次。
 *
 * 提示：如果 h 有多种可能的值，h 指数 是其中最大的那个。
 */
public class HIndex2 {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            int count = citations.length - mid;
            if (citations[mid] == count)
                return citations.length - mid;
            else if (citations[mid] > count){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return citations.length - left;
    }

    public static void main(String[] args) {
        HIndex2 hi = new HIndex2();
        System.out.println(hi.hIndex(new int[]{1,2,100}));
    }
}
