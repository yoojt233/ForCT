package Programmers.교점에별만들기;

import java.util.ArrayList;
import java.util.Arrays;

class Pair {
    int first, second;

    public Pair() {
        this.first = Integer.MIN_VALUE;
        this.second = Integer.MAX_VALUE;
    }

    public Pair(int a, int b) {
        this.first = a;
        this.second = b;
    }

    void update(int a) {
        first = Math.max(first, a);
        second = Math.min(second, a);
    }
}

class Solution {
    public static String[] solution(int[][] line) {
        int n = line.length;

        Pair r = new Pair();
        Pair c = new Pair();

        ArrayList<Pair> points = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int[] l1 = line[i];

            for (int j = i + 1; j < n; j++) {
                int[] l2 = line[j];

                long under = calc(l1[0], l1[1], l2[0], l2[1]);
                if (under == 0) continue;

                long upper_x = calc(l1[1], l1[2], l2[1], l2[2]);
                long upper_y = calc(l1[2], l1[0], l2[2], l2[0]);
                if (upper_x % under != 0 || upper_y % under != 0) continue;

                int x = Long.valueOf(upper_x / under).intValue();
                int y = Long.valueOf(upper_y / under).intValue();
                r.update(x);
                c.update(y);

                points.add(new Pair(x, y));
            }
        }

        int rs = c.first - c.second;
        int cs = r.first - r.second;

        char[][] temp = new char[rs + 1][cs + 1];
        for (int i = 0; i < temp.length; i++) Arrays.fill(temp[i], '.');

        for (Pair p : points) {
            int x = Math.abs(p.second - c.first);
            int y = Math.abs(p.first - r.second);

            temp[x][y] = '*';
        }

        String[] res = new String[temp.length];
        for (int i = 0; i < res.length; i++) res[i] = join(temp[i]);

        return res;
    }

    public static long calc(int a, int b, int c, int d) {
        return ((long) a * d - (long) b * c);
    }

    public static String join(char[] arr) {
        StringBuilder sb = new StringBuilder();

        for (char c : arr) sb.append(c);
        return sb.toString();
    }
}
