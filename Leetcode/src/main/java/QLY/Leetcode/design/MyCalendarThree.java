package QLY.Leetcode.design;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/my-calendar-iii/
 * 732. 我的日程安排表 III
 * 当 k 个日程安排有一些时间上的交叉时（例如 k 个日程安排都在同一时间内），就会产生 k 次预订。
 * 给你一些日程安排 [start, end) ，请你在每个日程安排添加后，返回一个整数 k ，表示所有先前日程安排会产生的最大 k 次预订。
 * 实现一个 MyCalendarThree 类来存放你的日程安排，你可以一直添加新的日程安排。
 * MyCalendarThree() 初始化对象。
 * int book(int start, int end) 返回一个整数 k ，表示日历中存在的 k 次预订的最大值。
 *
 * good answer:
 * 在无限长的水平空间上，每多一个不重叠的点，都会将水平空间多分割为一个片段
 * 每个start都会往水平空间的左边放向射出一条射线，每个end都会拦截住这个射线阻止其继续传播，射线在其未被拦截之前会一直存在，因此在某段区间上的射线的数目与start的数目有关，也与end的数目有关，计算方式为有N个start则+N有M个end则-M
 *
 * 每个start表示当前空间在此点多了一条线
 * 每个end表示当前空间在此点少了一条线
 * 因此可以记录所有的存在的点的增加和减少的线的数目，例如
 * [[10,20],[50,60],[10,40],[5,15],[5,10],[25,55]]
 * [10,20]=>{10:1,20:-1}
 * 从左到右以此扫描对应的点的重复线段数目为：
 * [10:1,20:0]
 * 因此K为1
 * [50,60]=>{10:1,20:-1,50:1,60:-1}
 * 从左到右依次扫码对应的点的重复线段的数目为：
 * [10:1,20:0,50:1,60:0]
 * 因此K为1
 * [10,40]=>{10:2,20:-1,40:-1,50:1,60:-1}
 * 从左到右依次扫码对应的点的重复线段的数目为：
 * [10:2,20:1,40:0,50:1,60:0]
 * 因此K为2
 * [5,15]=>{5:1,10:2,15:-1,20:-1,40:-1,50:1,60:-1}
 * 从左到右依次扫码对应的点的重复线段的数目为：
 * [5:1,10:3,15:2,20:1,40:0,50:1,60:0]
 * 因此K为3
 * [5,10]=>{5:2,10:1,15:-1,20:-1,40:-1,50:1,60:-1}
 * 从左到右依次扫码对应的点的重复线段的数目为：
 * [5:2,10:3,15:2,20:1,40:0,50:1,60:0]
 * 因此K为3
 * [25,55]=>{5:2,10:1,15:-1,20:-1,25:1,40:-1,50:1,55:-1,60:-1}
 * 从左到右依次扫码对应的点的重复线段的数目为：
 * [5:2,10:3,15:2,20:1,25:2,40:1,50:2,55:1,60:0]
 * 因此K为3
 */
public class MyCalendarThree {

    private final TreeMap<Integer, Integer> delta;
    public MyCalendarThree() {
        this.delta = new TreeMap<>();
    }

    public int book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int max = 0, sum = 0;
        for (Map.Entry<Integer, Integer> entry :delta.entrySet()) {
            sum += entry.getValue();
            max = Math.max(max, sum);
        }

        return max;
    }
}
