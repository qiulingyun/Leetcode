package QLY.Leetcode.graph;

import java.util.*;

public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        HashMap<Character, ArrayList<Integer>> firstChars = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            ArrayList<Integer> indexes = firstChars.getOrDefault(words[i].charAt(0), new ArrayList<>());
            indexes.add(i);
            firstChars.putIfAbsent(words[i].charAt(0), indexes);
        }

        final int n = board.length;
        final int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!firstChars.containsKey(board[i][j]))
                    continue;

                Iterator<Integer> iterator = firstChars.get(board[i][j]).iterator();
                while (iterator.hasNext()){
                    String dictWord = words[iterator.next()];
                    if (dfs(board, dictWord, i, j, 0)) {
                        iterator.remove();
                    }
                }

            }
        }

        return this.results;
    }

    private static final int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    private List<String> results = new ArrayList<>();
    private boolean dfs(char[][] board, String dictWord, int x, int y, int dictIndex){
        if (dictIndex == dictWord.length() - 1){
            results.add(dictWord);
            return true;
        }

        char c = board[x][y];
        board[x][y] = '*';

        final int n = board.length;
        final int m = board[0].length;

        boolean found = false;
        for (int[] direction: directions) {
            int nextx = x + direction[0];
            int nexty = y + direction[1];
            if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= m)
                continue;

            char next = dictWord.charAt(dictIndex + 1);
            if (board[nextx][nexty] != next)
                continue;

            found = dfs(board, dictWord, nextx, nexty, dictIndex + 1);
            if (found) {
                break;
            }
        }

        board[x][y] = c;
        return found;
    }

    public static void main(String[] args) {
        WordSearch2 wordSearch2 = new WordSearch2();
        char[][] board = {{'o','a','b','n'}
                         ,{'o','t','a','e'}
                         ,{'a','h','k','r'}
                         ,{'a','f','l','v'}};

        System.out.println(wordSearch2.findWords(board, new String[]{"oa", "oaa"}));
    }
}
