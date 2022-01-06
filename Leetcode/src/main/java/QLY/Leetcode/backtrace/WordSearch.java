package QLY.Leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    private static final class Position{
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = new boolean[board[i].length];
        }
        char[] words = word.toCharArray();

        List<Position> source = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == words[0]){
                    source.add(new Position(i, j));
                }
            }
        }

        for (Position s : source) {
            visited[s.x][s.y] = true;
            if (backtrace(board, words, visited, s, 1, String.valueOf(words[0])))
                return true;
            visited[s.x][s.y] = false;
        }
        return false;
    }

    private boolean backtrace(char[][] board, char[] words, boolean[][] visited, Position currPosition, int currIndex, String path){
        if (currIndex == words.length){
            return path.equals(String.valueOf(words));
        }

        if (currPosition.x + 1 < board.length
                && !visited[currPosition.x + 1][currPosition.y]
                && board[currPosition.x + 1][currPosition.y] == words[currIndex]){

            visited[currPosition.x + 1][currPosition.y] = true;
            if (backtrace(board, words, visited, new Position(currPosition.x + 1, currPosition.y), currIndex + 1, path + board[currPosition.x + 1][currPosition.y])) {
                return true;
            }
            visited[currPosition.x + 1][currPosition.y] = false;
        }

        if (currPosition.y + 1 < board[currPosition.x].length
                && !visited[currPosition.x][currPosition.y + 1]
                && board[currPosition.x][currPosition.y + 1] == words[currIndex]){

            visited[currPosition.x][currPosition.y + 1] = true;
            if (backtrace(board, words, visited, new Position(currPosition.x, currPosition.y + 1), currIndex + 1, path + board[currPosition.x][currPosition.y + 1])) {
                return true;
            }
            visited[currPosition.x][currPosition.y + 1] = false;
        }

        if (currPosition.x - 1 >= 0
                && !visited[currPosition.x - 1][currPosition.y]
                && board[currPosition.x - 1][currPosition.y] == words[currIndex]){

            visited[currPosition.x - 1][currPosition.y] = true;
            if (backtrace(board, words, visited, new Position(currPosition.x - 1, currPosition.y), currIndex + 1, path + board[currPosition.x - 1][currPosition.y])) {
                return true;
            }
            visited[currPosition.x - 1][currPosition.y] = false;
        }

        if (currPosition.y - 1 >= 0
                && !visited[currPosition.x][currPosition.y - 1]
                && board[currPosition.x][currPosition.y - 1] == words[currIndex]){

            visited[currPosition.x][currPosition.y - 1] = true;
            if (backtrace(board, words, visited, new Position(currPosition.x, currPosition.y - 1), currIndex + 1, path + board[currPosition.x][currPosition.y - 1])) {
                return true;
            }
            visited[currPosition.x][currPosition.y - 1] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));

//        System.out.println(wordSearch.exist(new char[][]{{'a','a'}}, "aaa"));
    }
}
