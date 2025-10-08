package Programmers.블록이동하기;

import java.util.Objects;
import java.util.HashSet;
import java.util.ArrayDeque;
import java.util.Arrays;

class Pos implements Comparable<Pos>, Cloneable {
    int r;
    int c;

    public Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public int compareTo(Pos other) {
        return (this.r != other.r) ? this.r - other.r : this.c - other.c;
    }

    @Override
    protected Pos clone() throws CloneNotSupportedException {
        return (Pos) super.clone();
    }
}

class Robot {
    Pos[] positions = new Pos[2];
    int level;

    public Robot(Pos first, Pos second, int level) {
        positions[0] = first;
        positions[1] = second;
        this.level = level;

        Arrays.sort(positions);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Robot)) return false;

        Robot robot = (Robot) o;
        if (this == robot) return true;
        return (this.positions[0].r == robot.positions[0].r && this.positions[0].c == robot.positions[0].c
                && this.positions[1].r == robot.positions[1].r && this.positions[1].c == robot.positions[1].c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positions[0].r, positions[0].c, positions[1].r, positions[1].c);
    }
}

class Solution {
    HashSet<Robot> visited = new HashSet<>();
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][][] turnFirst = {{{-1, 0}, {0, 1}}, {{1, 0}, {0, 1}}, {{0, -1}, {1, 0}}, {{0, 1}, {1, 0}}};
    int[][][] turnSecond = {{{-1, 0}, {0, -1}}, {{1, 0}, {0, -1}}, {{0, -1}, {-1, 0}}, {{0, 1}, {-1, 0}}};

    public int solution(int[][] board) throws Exception {
        Robot start = new Robot(new Pos(0, 0), new Pos(0, 1), 0);
        ArrayDeque<Robot> dq = new ArrayDeque<>();
        int n = board.length;
        int m = board[0].length;

        visited.add(start);
        dq.add(start);

        while (!dq.isEmpty()) {
            Robot cur = dq.removeFirst();
            Pos[] curPos = cur.positions;
            int level = cur.level;

            if ((curPos[0].r == n - 1 && curPos[0].c == n - 1) || (curPos[1].r == n - 1 && curPos[1].c == n - 1))
                return level;

            for (int[] d : dir) {
                Pos nf = new Pos(curPos[0].r + d[0], curPos[0].c + d[1]);
                Pos ns = new Pos(curPos[1].r + d[0], curPos[1].c + d[1]);
                Robot next = new Robot(nf, ns, level + 1);

                if (!rangeCheck(n, m, board, nf) || !rangeCheck(n, m, board, ns) || visited.contains(next)) continue;
                visited.add(next);
                dq.add(next);
            }

            int idx = type(cur);
            for (int i = 0; i < 2; i++) {
                Pos first = curPos[0].clone();

                for (int j = 0; j < 2; j++) {
                    first.r += turnFirst[idx + i][j][0];
                    first.c += turnFirst[idx + i][j][1];

                    if (!rangeCheck(n, m, board, first)) break;
                    if (j == 1) {
                        Robot next = new Robot(first, curPos[1], level + 1);

                        if (!visited.contains(next)) {
                            visited.add(next);
                            dq.add(next);
                        }
                    }
                }
            }

            for (int i = 0; i < 2; i++) {
                Pos second = curPos[1].clone();

                for (int j = 0; j < 2; j++) {
                    second.r += turnSecond[idx + i][j][0];
                    second.c += turnSecond[idx + i][j][1];

                    if (!rangeCheck(n, m, board, second)) break;
                    if (j == 1) {
                        Robot next = new Robot(curPos[0], second, level + 1);

                        if (!visited.contains(next)) {
                            visited.add(next);
                            dq.add(next);
                        }
                    }
                }
            }
        }

        return -1;
    }

    private int type(Robot cur) {
        return (cur.positions[0].r == cur.positions[1].r) ? 0 : 2;
    }

    private boolean rangeCheck(int n, int m, int[][] board, Pos p) {
        return p.r >= 0 && p.c >= 0 && p.r < n && p.c < m && wallCheck(board, p);
    }

    private boolean wallCheck(int[][] board, Pos p) {
        return board[p.r][p.c] == 0;
    }
}
