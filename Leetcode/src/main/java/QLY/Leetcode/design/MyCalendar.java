package QLY.Leetcode.design;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/my-calendar-i/
 * 729. 我的日程安排表 I
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。
 * 日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end 。
 * 实现 MyCalendar 类：
 * MyCalendar() 初始化日历对象。
 * boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 false 并且不要将该日程安排添加到日历中。
 */
public class MyCalendar {

    private final TreeMap<Integer, Integer> intervals;
    public MyCalendar() {
        intervals = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (intervals.isEmpty()){
            intervals.put(start, end);
            return true;
        }

        Map.Entry<Integer, Integer> floorEntry = intervals.floorEntry(start);
        if (floorEntry != null && floorEntry.getValue() > start)
            return false;
        Map.Entry<Integer, Integer> ceilingEntry = intervals.ceilingEntry(start);
        if (ceilingEntry != null && ceilingEntry.getKey() < end)
            return false;

        intervals.put(start, end);
        return true;
    }


    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(47,50));
        System.out.println(myCalendar.book(33,41));
        System.out.println(myCalendar.book(39,45));
        System.out.println(myCalendar.book(33,42));
        System.out.println(myCalendar.book(25,32));
        System.out.println(myCalendar.book(26,35));
        System.out.println(myCalendar.book(19,25));

    }
}
