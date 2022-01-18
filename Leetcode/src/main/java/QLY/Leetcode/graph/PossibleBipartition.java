package QLY.Leetcode.graph;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/possible-bipartition/
 * 886. 可能的二分法
 * 给定一组 N 人（编号为 1, 2, ..., N）， 我们想把每个人分进任意大小的两组。
 * 每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * 形式上，如果 dislikes[i] = [a, b]，表示不允许将编号为 a 和 b 的人归入同一组。
 * 当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 */
public class PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        LinkedList<Integer>[] neighbours = new LinkedList[n + 1];
        for (int[] dislike : dislikes) {
            if (neighbours[dislike[0]] == null)
                neighbours[dislike[0]] = new LinkedList<>();
            neighbours[dislike[0]].add(dislike[1]);

            if (neighbours[dislike[1]] == null)
                neighbours[dislike[1]] = new LinkedList<>();
            neighbours[dislike[1]].add(dislike[0]);
        }

        int[] color = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (color[i] > 0)
                continue;
            color[i] = 1;
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()){
                int curr = queue.poll();
                if (neighbours[curr] == null)
                    continue;
                for (int dis : neighbours[curr]) {
                    if (color[dis] > 0){
                        if (color[curr] == color[dis])
                            return false;
                        continue;
                    }

                    if (color[curr] == 1)
                        color[dis] = 2;
                    else
                        color[dis] = 1;

                    queue.add(dis);
                }
            }
        }


        return true;
    }

    public static void main(String[] args) {
        PossibleBipartition possibleBipartition = new PossibleBipartition();
        System.out.println(possibleBipartition.possibleBipartition(5, new int[][]{{1,2},{3,4},{4,5},{3,5}}));
    }
}
