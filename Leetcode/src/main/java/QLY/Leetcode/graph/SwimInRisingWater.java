package QLY.Leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/swim-in-rising-water/
 * 778. 水位上升的泳池中游泳
 * 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
 * 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
 * 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？
 */
public class SwimInRisingWater {
    private static final class Node {
        public int i;
        public int j;
        public int dis;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public Node(int i, int j, int dis) {
            this.i = i;
            this.j = j;
            this.dis = dis;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return i == node.i && j == node.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int swimInWater(int[][] grid) {
        HashMap<Node, Integer> map = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>((a,b)->a.dis-b.dis);
        HashSet<Node> visited = new HashSet<>();
        final int N = grid.length;

        Node source = new Node(0, 0, grid[0][0]);
        map.put(source, 0);
        queue.add(source);

        int k = 0;

        while (!queue.isEmpty()){
            Node curr = queue.poll();
            visited.add(curr);
            k = Math.max(k, grid[curr.i][curr.j]);
            if (curr.i == N-1 && curr.j == N-1)
                return k;
            for (int[] direction : DIRECTIONS) {
                int i = curr.i + direction[0];
                int j = curr.j + direction[1];
                if (i < 0 || i >= N || j < 0 || j >= N)
                    continue;
                Node neighbour = new Node(i, j, grid[i][j]);
                if (visited.contains(neighbour))
                    continue;

                int diff = grid[i][j] > grid[curr.i][curr.j] ? grid[i][j] - grid[curr.i][curr.j] : 0;
                int currDistence = curr.dis + diff;
                if (!map.containsKey(neighbour) || map.get(neighbour) > currDistence)
                    map.put(neighbour, currDistence);

                queue.add(neighbour);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        SwimInRisingWater swimInRisingWater = new SwimInRisingWater();
        System.out.println(swimInRisingWater.swimInWater(new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}));
        System.out.println(swimInRisingWater.swimInWater(new int[][]{{0, 2}, {1, 3}}));
    }

}
