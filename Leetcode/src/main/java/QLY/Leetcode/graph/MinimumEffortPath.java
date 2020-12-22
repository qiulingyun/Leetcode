package QLY.Leetcode.graph;

import java.util.*;

/**
 * EA TEST
 * 1631. 最小体力消耗路径
 * 难度 中等
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 *
 * 示例 1：
 *
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 * 示例 2：
 *
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
 * 示例 3：
 *
 * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * 输出：0
 * 解释：上图所示路径不需要消耗任何体力。
 *
 * 提示：
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 10^6
 */
public class MinimumEffortPath {
    private class Index{
        public int x;
        public int y;

        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Index index = (Index) o;
            return x == index.x &&
                    y == index.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private class Point{
        public Index index;
        public int cost;

        public Point(Index index) {
            this.index = index;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        final int X = heights.length;
        final int Y = heights[0].length;
        Map<Index, Point> visited = new HashMap<>();
        Map<Index, Point> toVisist = new HashMap<>();
//        PriorityQueue<Point> queue = new PriorityQueue<>((a,b)->a.cost-b.cost);
        Point source = new Point(new Index(0, 0));
//        source.cost = Integer.MAX_VALUE-1;
        toVisist.put(source.index, source);
        while (!toVisist.isEmpty()){
            Point curr = pollmin(toVisist);
            visited.put(curr.index, curr);
            int x = curr.index.x, y = curr.index.y;
            //left
            if (x > 0){
                Index left = new Index(x-1, y);
                if (!visited.containsKey(left)){
                    Point leftp = new Point(left);
                    leftp.cost = Math.max(Math.abs(heights[x-1][y] - heights[x][y]), curr.cost);
                    if (toVisist.containsKey(left)){
                        Point p = toVisist.get(left);
                        if (p.cost > leftp.cost)
                            p.cost = leftp.cost;
                    }else {
                        toVisist.put(left, leftp);
                    }
                }
            }

            //right
            if (x < X-1){
                Index right = new Index(x+1, y);
                if (!visited.containsKey(right)){
                    Point rightp = new Point(right);
                    rightp.cost = Math.max(Math.abs(heights[x+1][y] - heights[x][y]), curr.cost);
                    if (toVisist.containsKey(right)){
                        Point p = toVisist.get(right);
                        if (p.cost > rightp.cost)
                            p.cost = rightp.cost;
                    }else {
                        toVisist.put(right, rightp);
                    }
                }
            }

            //up
            if (y > 0){
                Index up = new Index(x, y-1);
                if (!visited.containsKey(up)){
                    Point upp = new Point(up);
                    upp.cost = Math.max(Math.abs(heights[x][y-1] - heights[x][y]), curr.cost);
                    if (toVisist.containsKey(up)){
                        Point p = toVisist.get(up);
                        if (p.cost > upp.cost)
                            p.cost = upp.cost;
                    }else {
                        toVisist.put(up, upp);
                    }
                }
            }

            //down
            if (y < Y-1){
                Index down = new Index(x, y+1);
                if (!visited.containsKey(down)){
                    Point downp = new Point(down);
                    downp.cost = Math.max(Math.abs(heights[x][y+1] - heights[x][y]), curr.cost);
                    if (toVisist.containsKey(down)){
                        Point p = toVisist.get(down);
                        if (p.cost > downp.cost)
                            p.cost = downp.cost;
                    }else {
                        toVisist.put(down, downp);
                    }
                }
            }
        }
         return visited.get(new Index(X-1, Y-1)).cost;
    }

    private Point pollmin(Map<Index, Point> map){
        int cost = Integer.MAX_VALUE;
        Point min = null;
        for (Map.Entry<Index, Point> entry: map.entrySet()){
            if( entry.getValue().cost < cost ){
                cost = entry.getValue().cost;
                min = entry.getValue();
            }
        }
        map.remove(min.index);


        return min;
    }

    // more effective
    public int minimumEffortPath2(int[][] heights) {
        final int X = heights.length;
        final int Y = heights[0].length;
        Map<Index, Point> visited = new HashMap<>();
//        Map<Index, Point> toVisist = new HashMap<>();
        PriorityQueue<Point> toVisist = new PriorityQueue<>((a,b)->a.cost-b.cost);
        Point source = new Point(new Index(0, 0));
//        source.cost = Integer.MAX_VALUE-1;
        toVisist.add(source);
        while (!toVisist.isEmpty()){
            Point curr = toVisist.poll();
            if (curr.index.equals(new Index(X-1, Y-1)))
                return curr.cost;
            if (visited.containsKey(curr.index))
                continue;   //duplicated

            visited.put(curr.index, curr);
            int x = curr.index.x, y = curr.index.y;
            //left
            if (x > 0){
                Index left = new Index(x-1, y);
                if (!visited.containsKey(left)){
                    Point leftp = new Point(left);
                    leftp.cost = Math.max(Math.abs(heights[x-1][y] - heights[x][y]), curr.cost);
                    toVisist.add(leftp);
                }
            }

            //right
            if (x < X-1){
                Index right = new Index(x+1, y);
                if (!visited.containsKey(right)){
                    Point rightp = new Point(right);
                    rightp.cost = Math.max(Math.abs(heights[x+1][y] - heights[x][y]), curr.cost);
                    toVisist.add(rightp);
                }
            }

            //up
            if (y > 0){
                Index up = new Index(x, y-1);
                if (!visited.containsKey(up)){
                    Point upp = new Point(up);
                    upp.cost = Math.max(Math.abs(heights[x][y-1] - heights[x][y]), curr.cost);
                    toVisist.add(upp);
                }
            }

            //down
            if (y < Y-1){
                Index down = new Index(x, y+1);
                if (!visited.containsKey(down)){
                    Point downp = new Point(down);
                    downp.cost = Math.max(Math.abs(heights[x][y+1] - heights[x][y]), curr.cost);
                    toVisist.add(downp);
                }
            }
        }
        return visited.get(new Index(X-1, Y-1)).cost;
    }

    public static void main(String[] args) {
        MinimumEffortPath minimumEffortPath = new MinimumEffortPath();
        int[][] heights = {{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
        int[][] heights2 = {{1,2,2},{3,8,2},{5,3,5}};
        int[][] heights3 = {{1,2,3},{3,8,4},{5,3,5}};
        System.out.println(minimumEffortPath.minimumEffortPath2(heights));
        System.out.println(minimumEffortPath.minimumEffortPath2(heights2));
        System.out.println(minimumEffortPath.minimumEffortPath2(heights3));
    }
}
