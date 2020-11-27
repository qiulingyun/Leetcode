package QLY.Leetcode.intervals;

import java.util.Arrays;

/**
 * 1288. 删除被覆盖区间
 */
public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        int[] first = intervals[0];
        int covered = 0;
        for (int i = 1; i < intervals.length; i++){
            if (first[0] <= intervals[i][0] && first[1] >= intervals[i][1]){
                covered++;
            }else if (first[0] <= intervals[i][0] && first[1] < intervals[i][1] && first[1] >= intervals[i][0]){
                first[1] = intervals[i][1];
            }else if (first[1] < intervals[i][0]){
                first[0] = intervals[i][0];
                first[1] = intervals[i][1];
            }
        }

        return intervals.length - covered;
    }

    public static void main(String[] args) {
        RemoveCoveredIntervals removeCoveredIntervals = new RemoveCoveredIntervals();
        System.out.println(removeCoveredIntervals.removeCoveredIntervals(new int[][]{{1,4}, {3,6},{2,8}}));
    }
}
