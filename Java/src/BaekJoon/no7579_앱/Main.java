package BaekJoon.no7579_앱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int INF = 10001;

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[][] app = new int[2][n];
        for (int t = 0; t < 2; ++t) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; ++i)
                app[t][i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[n][INF];
        for (int i = 0; i < n; ++i) {
            int used = app[0][i];
            int turn = app[1][i];

            for (int j = 0; j < INF; ++j) {
                if (i == 0) {
                    if (j >= turn)
                        dp[i][j] = used;
                } else
                    dp[i][j] = (j >= turn) ? Math.max(dp[i - 1][j - turn] + used, dp[i - 1][j]) : dp[i - 1][j];

                if (dp[i][j] >= target)
                    ans = Math.min(ans, j);
            }
        }

        System.out.print(ans);
    }
}
