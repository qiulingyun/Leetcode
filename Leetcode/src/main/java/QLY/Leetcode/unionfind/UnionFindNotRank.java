package QLY.Leetcode.unionfind;

public class UnionFindNotRank {
    private int[] parent;
    private int count;

    public UnionFindNotRank(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        count = n;
    }

    public int find(int x){
        if (x == parent[x]){
            return x;
        }

        parent[x] = find(parent[x]);
        return parent[x];

        //return parent[x] == x? x: (parent[x] = find2(parent[x]));
    }

    public int find2(int x){
        while (x != parent[x]){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }

        return x;
    }

    public void union(int x, int y){
        int xparent = find(x);
        int yparent = find(y);
        if (xparent == yparent)
            return;

        parent[xparent] = yparent;
        count--;
    }

    public int getCount() {
        return count;
    }
}
