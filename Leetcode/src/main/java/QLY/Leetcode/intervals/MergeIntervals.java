package QLY.Leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        List<int[]> results = new ArrayList<>();
        int[] curr = intervals[0];
        for (int i = 1; i < intervals.length; i++){
            if (curr[0] <= intervals[i][0] && curr[1] >= intervals[i][1]){
                continue;
            } else if (curr[0] <= intervals[i][0] && curr[1] < intervals[i][1] && curr[1] >= intervals[i][0]){
                curr[1] = intervals[i][1];
            } else if(curr[1] < intervals[i][0]){
                results.add(curr);
                curr = intervals[i];
            }
        }
//        results.add(curr);
//        Object[] temp = results.toArray();
//        int[][] res = new int[temp.length][];
//        for (int i = 0; i < temp.length; i++){
//            res[i] = (int[]) temp[i];
//        }
        return results.toArray(new int[results.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.println(Arrays.toString(mergeIntervals.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})));
    }
}
