package QLY.Leetcode.unionfind;

public class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x){
        if (parent[x] == x){
            return x;
        }

        parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x,  int y){
        int parentx = find(x);
        int parenty = find(y);
        if (rank[parentx] >= rank[parenty])
            parent[parenty] = parentx;
        else
            parent[parentx] = parenty;

        if (parentx != parenty && rank[parentx] == rank[parenty])
            rank[parentx]++;
    }
}
