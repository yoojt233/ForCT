package Programmers.N으로표현;

import java.util.HashSet;

public class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        HashSet<Integer>[] sets = new HashSet[9];

        for (int i = 0; i < 9; i++) sets[i] = new HashSet<>();
        sets[1].add(N);

        for (int i = 2; i < 9; i++) {
            HashSet<Integer> cur = sets[i];

            cur.add(repeat(N, i));
            for (int j = 1; j <= i / 2; j++) calc(cur, sets[j], sets[i - j]);

            if (cur.contains(number)) return i;
        }

        return -1;
    }

    private static int repeat(int N, int i) {
        int res = 0;
        while (i-- > 0) res = res * 10 + N;

        return res;
    }

    private static void calc(HashSet<Integer> cur, HashSet<Integer> a, HashSet<Integer> b) {
        for (int aa : a) {
            for (int bb : b) {
                cur.add(aa + bb);
                cur.add(aa - bb);
                cur.add(bb - aa);
                cur.add(aa * bb);
                if (bb != 0) cur.add(aa / bb);
                if (aa != 0) cur.add(bb / aa);
            }
        }
    }
}
