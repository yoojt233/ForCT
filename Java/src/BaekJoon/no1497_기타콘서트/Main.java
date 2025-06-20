package BaekJoon.no1497_기타콘서트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static long[] plays;
    static int ans = Integer.MAX_VALUE;
    static int max_cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        plays = new long[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            st.nextToken();
            plays[i] = convertBit(st.nextToken().toCharArray());
        }

        play(0, 0, 0L);

        if (max_cnt == 0) ans = -1;

        System.out.println(ans);
    }

    private static void play(int level, int sel_cnt, long possible) {
        if (level >= n) {
            int temp = Long.bitCount(possible);

            if (temp > max_cnt) {
                max_cnt = temp;
                ans = sel_cnt;
            } else if (temp == max_cnt && sel_cnt < ans) ans = sel_cnt;

            return;
        }

        play(level + 1, sel_cnt, possible);
        play(level + 1, sel_cnt + 1, possible | plays[level]);
    }

    private static long convertBit(char[] input) {
        long res = 0;

        for (int i = 0; i < m; i++) {
            if (input[i] == 'N') continue;

            res |= (1L << i);
        }

        return res;
    }
}
