package QLY.Leetcode.unionfind;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/redundant-connection/
 * 684. 冗余连接
 * 树可以看成是一个连通且 无环 的 无向 图。
 * 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的边。
 */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length);
        int[] redundent = null;

        for (int[] edge : edges) {
            int left = edge[0] - 1;
            int right = edge[1] - 1;

            if (!unionFind.isConnected(left, right))
                unionFind.union(left, right);
            else
                redundent = edge;
        }

        return redundent;
    }

    public static void main(String[] args) {
        RedundantConnection redundantConnection = new RedundantConnection();
        System.out.println(Arrays.stream((redundantConnection.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}))).boxed().collect(Collectors.toList()));
    }
}
