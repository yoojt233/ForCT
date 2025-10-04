package Programmers.외벽점검;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    boolean flag;
    int res;

    public int solution(int n, int[] weak, int[] dist) {
        res = 1;
        flag = false;
        ArrayList<Integer> weaks = new ArrayList<>();

        Arrays.sort(dist);
        for (int w : weak) weaks.add(w);
        for (int i = 0; i < weak.length - 1; i++) weaks.add(weak[i] + n);

        while (res <= dist.length) {
            ArrayList<Integer> people = new ArrayList<>();

            for (int i = 0; i < res; i++) people.add(dist[dist.length - 1 - i]);
            for (int i = 0; i < weak.length; i++) {
                boolean[] moved = new boolean[res];
                moved[0] = true;

                check(i, i + weak.length, 0, 0, weaks, people, moved);
                if (flag) return res;
            }

            ++res;
        }

        return -1;
    }

    private void check(int op, int ed, int level, int idx, ArrayList<Integer> weaks, ArrayList<Integer> people, boolean[] moved) {
        if (level >= people.size()) return;

        int start = weaks.get(op), end = start + people.get(idx);

        for (int i = op; i < ed; i++) {
            if (weaks.get(i) <= end) ++op;
            else break;
        }

        if (op < ed) {
            for (int i = 1; i < people.size(); i++) {
                if (moved[i]) continue;

                moved[i] = true;
                check(op, ed, level + 1, i, weaks, people, moved);
                moved[i] = false;
            }
        } else flag = true;
    }
}
