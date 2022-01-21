package QLY.Leetcode.unionfind;

/**
 * https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/
 * 947. 移除最多的同行或同列石头
 * n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
 * 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
 * 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
 */
public class MostStonesRemovedWithSameEowOrColumn {
    public int removeStones(int[][] stones) {
        final int n = stones.length;
        UnionFindNotRank unionFind = new UnionFindNotRank(stones.length);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                    unionFind.union(i, j);
            }
        }

        return n - unionFind.getCount();
    }
}
