package QLY.Leetcode.intervals;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/the-skyline-problem/
 * 218. 天际线问题
 * 城市的 天际线 是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回 由这些建筑物形成的 天际线 。
 * 每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：
 * lefti 是第 i 座建筑物左边缘的 x 坐标。
 * righti 是第 i 座建筑物右边缘的 x 坐标。
 * heighti 是第 i 座建筑物的高度。
 * 你可以假设所有的建筑都是完美的长方形，在高度为 0 的绝对平坦的表面上。
 */
public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        TreeMap<Integer, ArrayList<Integer>> lines = new TreeMap<>();
        for (int[] building: buildings) {
            ArrayList<Integer> list = lines.getOrDefault(building[0], new ArrayList<>());
            list.add(building[2]);
            lines.putIfAbsent(building[0], list);

            list = lines.getOrDefault(building[1], new ArrayList<>());
            list.add(-building[2]);
            lines.putIfAbsent(building[1], list);
        }

        List<List<Integer>> results = new ArrayList<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->b-a);
        Iterator<Map.Entry<Integer, ArrayList<Integer>>> iterator = lines.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<Integer, ArrayList<Integer>> entry = iterator.next();
            int prev = max.peek() == null? 0: max.peek();
            for (int height : entry.getValue()) {
                if (height > 0)
                    max.add(height);
                else
                    max.remove(-height);
            }
            int curr = max.peek() == null? 0: max.peek();
            if (curr != prev){
                results.add(new ArrayList<Integer>(){{add(entry.getKey()); add(curr);}});
            }
        }

        return results;
    }

    public static void main(String[] args) {
        TheSkylineProblem theSkylineProblem = new TheSkylineProblem();
        System.out.println(theSkylineProblem.getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}}));
        System.out.println(theSkylineProblem.getSkyline(new int[][]{{0,2,3},{2,5,3}}));
    }
}
