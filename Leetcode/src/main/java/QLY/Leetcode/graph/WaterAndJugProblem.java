package QLY.Leetcode.graph;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/water-and-jug-problem/
 * 365. 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * 你允许：
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 */
public class WaterAndJugProblem {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity == 0)
            return true;
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[jug1Capacity + jug2Capacity + 1];

        queue.add(0);
        visited[0] = true;
        queue.add(jug1Capacity);
        visited[jug1Capacity] = true;
        queue.add(jug2Capacity);
        visited[jug2Capacity] = true;

        int small = Math.min(jug1Capacity, jug2Capacity);
        int big = Math.max(jug1Capacity, jug2Capacity);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == targetCapacity)
                    return true;
                else if (curr < small){
                    if (curr + small == targetCapacity || curr + big == targetCapacity)
                        return true;
                }else {
                    if (curr + small == targetCapacity)
                        return true;
                }


                if (curr + small < big && !visited[curr + small]){
                    queue.add(curr + small);
                    visited[curr + small] = true;
                }else if (curr + small > big && !visited[small + curr - big]){
                    queue.add(small + curr - big);
                    visited[small + curr - big] = true;
                }

                if (curr < small && !visited[big - small + curr]){
                    queue.add(big - small + curr);
                    visited[big - small + curr] = true;
                }else if (curr > small && !visited[curr - small]){
                    queue.add(curr - small);
                    visited[curr - small] = true;
                }

            }
        }

        return false;
    }

    public static void main(String[] args) {
        WaterAndJugProblem waterAndJugProblem = new WaterAndJugProblem();
        System.out.println(waterAndJugProblem.canMeasureWater(3, 5, 4));
        System.out.println(waterAndJugProblem.canMeasureWater(1, 2, 3));
    }
}
