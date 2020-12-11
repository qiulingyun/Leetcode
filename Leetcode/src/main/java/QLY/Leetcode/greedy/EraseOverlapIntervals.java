package QLY.Leetcode.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 435. 无重叠区间
 * 难度 中等

 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a,b)->{
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        /**
         * 1     =======
         *        ====
         *
         *  2    =======
         *         ========
         *
         *  3    =======
         *               =======
         */

        int[] now = intervals[0];
//        int index = 1;
        int count = 0;

//        while (index < intervals.length){
//            while (index < intervals.length && now[1] > intervals[index][0]){
//                now[1] = Math.min(now[1], intervals[index][1]);
//                count++;
//                index++;
//            }
//            if (index < intervals.length){
//                now[0] = intervals[index][0];
//                now[1] = intervals[index][1];
//                index++;
//            }
//
//        }

        for (int i = 1; i < intervals.length; i++){
            int[] interval = intervals[i];
            if (now[1] > interval[0]){
                if (now[1] > interval[1]){
                    now[1] = interval[1];
                }
                count++;
            }else {
                now[0] = interval[0];
                now[1] = interval[1];
            }
        }

        return count;

    }


    public static void main(String[] args) {
        EraseOverlapIntervals eraseOverlapIntervals = new EraseOverlapIntervals();
        System.out.println(eraseOverlapIntervals.eraseOverlapIntervals(new int[][]{{1,2}, {2,3}, {3,4}, {1,3}}));
    }
}
