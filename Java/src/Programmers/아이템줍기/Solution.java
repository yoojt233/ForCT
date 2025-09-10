package Programmers.아이템줍기;

import java.util.Queue;
import java.util.LinkedList;

class Pos {
    int r;
    int c;
    int move;

    public Pos(int r, int c, int move) {
        this.r = r;
        this.c = c;
        this.move = move;
    }
}

public class Solution {
    boolean[][] field = new boolean[101][101];
    int[][] way4 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] way8 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] rec : rectangle) {
            int[] rows = new int[]{rec[1] * 2, rec[3] * 2};
            int[] cols = new int[]{rec[0] * 2, rec[2] * 2};

            for (int r = rows[0]; r <= rows[1]; r++) {
                for (int c = cols[0]; c <= cols[1]; c++) {
                    field[r][c] = true;
                }
            }
        }

        return bfs(characterX, characterY, itemX, itemY);
    }

    private int bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<Pos> q = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];

        q.add(new Pos(characterY * 2, characterX * 2, 0));
        visited[characterY * 2][characterX * 2] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + way4[d][0];
                int nc = cur.c + way4[d][1];

                if (nr == itemY * 2 && nc == itemX * 2) return (cur.move + 1) / 2;
                if (nr < 0 || nr > 100 || nc < 0 || nc > 100 || !field[nr][nc] || visited[nr][nc] || !isEdge(nr, nc))
                    continue;

                q.add(new Pos(nr, nc, cur.move + 1));
                visited[nr][nc] = true;
            }
        }

        return 0;
    }

    private boolean isEdge(int r, int c) {
        for (int d = 0; d < 8; d++) {
            int nr = r + way8[d][0];
            int nc = c + way8[d][1];

            if (nr < 0 || nr > 100 || nc < 0 || nc > 100 || !field[nr][nc]) return true;
        }

        return false;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] rectangle = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        System.out.println(new Solution().solution(rectangle, characterX, characterY, itemX, itemY));
    }
}