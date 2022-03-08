package QLY.Leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 * 986. 区间列表的交集
 */
public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> results = new ArrayList<>();
        int a = 0, b = 0;
        while (a < A.length && b < B.length){
            if (A[a][0] <= B[b][0]){
                if (A[a][1] >= B[b][1]){
                    // *******
                    //   ****
                    results.add(B[b]);
                    b++;
                }else if (A[a][1] < B[b][1] && A[a][1] >= B[b][0]){
                    // *******
                    //   ********
                    results.add(new int[]{B[b][0], A[a][1]});
                    a++;
                }else {
                    // *******
                    //         **
//                    results.add(null);
                    a++;
                }
            }else {
                if (A[a][1] <= B[b][1]){
                    //     *******
                    //   ***********
                    results.add(A[a]);
                    a++;
                }else if (A[a][1] > B[b][1] && A[a][0] <= B[b][1]){
                    //      *******
                    //   ********
                    results.add(new int[]{A[a][0], B[b][1]});
                    b++;
                }else {
                    //     *******
                    // **
//                    results.add(null);
                    b++;
                }
            }
        }

//        Object[] temp = results.toArray();
//        int[][] res = new int[temp.length][];
//        for (int i = 0; i < temp.length; i++){
//            res[i] = (int[]) temp[i];
//        }

//        return res;
        return results.toArray(new int[results.size()][]);
    }

    public static void main(String[] args) {
        IntervalIntersection intervalIntersection = new IntervalIntersection();
        System.out.println(Arrays.toString(intervalIntersection.intervalIntersection(new int[][]{{0,2},{5,10},{13,23},{24,25}}, new int[][]{{1,5},{8,12},{15,24},{25,26}})));
    }
}
