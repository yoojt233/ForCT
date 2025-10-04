package Programmers.완전범죄;

import java.util.Arrays;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int len = info.length;
        int[][] dp = new int[len + 1][m];
        int res = Integer.MAX_VALUE;

        for (int i = 0; i <= len; i++) Arrays.fill(dp[i], 121);
        dp[0][0] = 0;
        for (int i = 1; i <= len; i++) {
            int a = info[i - 1][0];
            int b = info[i - 1][1];

            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a);

                if (j + b < m) dp[i][j + b] = Math.min(dp[i][j + b], dp[i - 1][j]);
            }
        }
        for (int v : dp[len]) res = Math.min(res, v);

        return (res < n) ? res : -1;
    }
}
