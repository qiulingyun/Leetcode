package QLY.Leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        Scaner scaner = new Scaner(matrix, 0, 0);
        return scaner.scan();
    }

    private static final class Scaner{
        private static final class Position{
            public int x;
            public int y;

            public Position(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        private final Position start;

        private enum Mode{
            LeftToRight, UpToDown, RightToLeft, DownToUp
        }
        private Mode mode = Mode.LeftToRight;
        private void changeMode(){
            switch (this.mode){
                case LeftToRight: this.mode = Mode.UpToDown;break;
                case UpToDown: this.mode = Mode.RightToLeft;break;
                case RightToLeft: this.mode = Mode.DownToUp;break;
                case DownToUp: this.mode = Mode.LeftToRight;break;
            }
        }

        /**
         * x for line number, y for index in this line
         * ======================> y
         * "
         * "
         * "
         * "
         * "
         * v
         * x
         */
        private Position next(Position curr){
            for (int i = 0; i < Mode.values().length; i++) {
                switch (this.mode){
                    case LeftToRight:
                        if (curr.y + 1 < matrix[curr.x].length && !visited[curr.x][curr.y + 1]){
                            visited[curr.x][curr.y + 1] = true;
                            return new Position(curr.x, curr.y + 1);
                        }else {
                            changeMode();
                        }
                        break;
                    case UpToDown:
                        if (curr.x + 1 < matrix.length && !visited[curr.x + 1][curr.y]){
                            visited[curr.x + 1][curr.y] = true;
                            return new Position(curr.x + 1, curr.y);
                        }else {
                            changeMode();
                        }
                        break;
                    case RightToLeft:
                        if (curr.y - 1 >= 0 && !visited[curr.x][curr.y - 1]){
                            visited[curr.x][curr.y - 1] = true;
                            return new Position(curr.x, curr.y - 1);
                        }else {
                            changeMode();
                        }
                        break;
                    case DownToUp:
                        if (curr.x - 1 >= 0 && !visited[curr.x - 1][curr.y]){
                            visited[curr.x - 1][curr.y] = true;
                            return new Position(curr.x - 1, curr.y);
                        }else {
                            changeMode();
                        }
                        break;
                }
            }

            return null;
        }

        private final boolean[][] visited;
        private final int[][] matrix;

        public Scaner(int[][] matrix, int startx, int starty){
            this.matrix = matrix;
            this.visited = new boolean[matrix.length][];
            for (int i = 0; i < visited.length; i++) {
                visited[i] = new boolean[matrix[i].length];
            }
            this.start = new Position(startx, starty);
        }

        public List<Integer> scan(){
            List<Integer> results = new ArrayList<>();
            results.add(matrix[start.x][start.y]);
            visited[start.x][start.y] = true;

            Position curr = start, next = null;
            while (  (next = next(curr)) != null){
                results.add(matrix[next.x][next.y]);
                curr = next;
            }

            return results;
        }

    }
}
