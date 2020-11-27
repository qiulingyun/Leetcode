package QLY.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class SlidingPuzzle {
    private class Board{
        public String str;
        public int index;
        public int step;

        public Board(String str, int index, int step) {
            this.str = str;
            this.index = index;
            this.step = step;
        }
    }

    private void swapChar(char[] in, int left, int right){
        char l = in[left];
        in[left] = in[right];
        in[right] = l;
    }

    public int slidingPuzzle(int[][] board) {
        String str = "";
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                str += "" + board[i][j];
            }
        }
        int initIndex = 0;
        while (str.charAt(initIndex) != '0')
            initIndex++;

        LinkedList<Board> queue = new LinkedList<>();
        queue.add(new Board(str, initIndex, 0));

        // 0 1 2
        // 3 4 5
        int[][] neighbor = {{1, 3, -1}, {0, 2, 4}, {1, 5, -1}, {0, 4, -1}, {1, 3, 5}, {2, 4, -1}};
        // 1 2 3
        // 4 5 0
        String target = "123450";
        HashSet<String> visited = new HashSet<>();

        while (!queue.isEmpty()){
            Board curr = queue.poll();
            if (curr.str.equals(target)){
                return curr.step;
            }else if (visited.contains(curr.str)){
                continue;
            }else {
                visited.add(curr.str);
            }

            for (int nextIndex: neighbor[curr.index]){
                if (nextIndex == -1)
                    continue;

                char[] nextChars = curr.str.toCharArray();
                swapChar(nextChars, curr.index, nextIndex);
                queue.add(new Board( new String(nextChars), nextIndex, curr.step + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SlidingPuzzle slidingPuzzle = new SlidingPuzzle();
        System.out.println(slidingPuzzle.slidingPuzzle(new int[][]{{3,2,4}, {1,5,0}}));
    }
}
