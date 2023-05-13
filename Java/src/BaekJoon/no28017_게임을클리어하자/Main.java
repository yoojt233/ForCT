package BaekJoon.no28017_게임을클리어하자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] times;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        times = new int[N][M];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j)
                times[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][M];
        dp[0] = times[0].clone();
        for (int i = 1; i < N; ++i) {
            for (int j = 0; j < M; ++j)
                dp[i][j] = times[i][j] + minim(j, dp[i - 1]);
        }

        int ans = Integer.MAX_VALUE;
        for (int i : dp[N - 1])
            ans = Math.min(i, ans);
        System.out.print(ans);
    }

    private static int minim(int j, int[] before) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < M; ++i) {
            if (i == j) continue;
            res = Math.min(res, before[i]);
        }
        return res;
    }
}