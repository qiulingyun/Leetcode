package QLY.Leetcode.greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 1353. 最多可以参加的会议数目
 * 难度 中等
 * 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。
 * 请你返回你可以参加的 最大 会议数目。
 *

 输入：events = [[1,2],[2,3],[3,4]]
 输出：3
 解释：你可以参加所有的三个会议。
 安排会议的一种方案如上图。
 第 1 天参加第一个会议。
 第 2 天参加第二个会议。
 第 3 天参加第三个会议。

 示例 2：
 输入：events= [[1,2],[2,3],[3,4],[1,2]]
 输出：4

 示例 3：
 输入：events = [[1,4],[4,4],[2,2],[3,4],[1,1]]
 输出：4

 示例 4：
 输入：events = [[1,100000]]
 输出：1


 示例 5：
 输入：events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
 输出：7

 提示：

 1 <= events.length <= 10^5
 events[i].length == 2
 1 <= events[i][0] <= events[i][1] <= 10^5

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximum-number-of-events-that-can-be-attended
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxEvents {
    /**
     * O(n*n)  out of time !!!
     * @param events
     * @return
     */
    public int maxEvents1(int[][] events) {
        Arrays.sort(events, (a,b)->{
            if (a[1] == b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        boolean[] days = new boolean[1000001];
        int count = 0;
        for (int[] event: events){
            for (int i = event[0]; i <= event[1]; i++){
                if (!days[i]){
                    count++;
                    days[i] = true;
                    break;
                }
            }
        }


        return count;
    }

    public int maxEvents(int[][] events) {
        int beginDay = 0, endDay = 0;
        for (int[] event: events){
            beginDay = Math.min(beginDay, event[0]);
            endDay = Math.max(endDay, event[1]);
        }
        Arrays.sort(events, (a,b)->{
            if (a[0] == b[0])
               return a[1] - b[1];
            return a[0] - b[0];
        });
        int count = 0;
        int eventIndex = 0;
        PriorityQueue<Integer> endDays = new PriorityQueue<>();
        for (int day = beginDay; day <= endDay; day++){
            //将从今天开始的event 的结束时间放入小顶堆
            while (eventIndex < events.length && day == events[eventIndex][0]){
                endDays.add(events[eventIndex++][1]);
            }
            //去掉已经过去的event的结束时间, 否则 {{1,2},{1,2},{1,6},{1,2},{1,2}} 出错
            while (!endDays.isEmpty() && endDays.peek() < day)
                endDays.poll();

            if (!endDays.isEmpty()){
                endDays.poll();
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        MaxEvents maxEvents = new MaxEvents();

        System.out.println(maxEvents.maxEvents(new int[][]{{1,2},{2,3},{3,4},{1,2}}));
    }
}
