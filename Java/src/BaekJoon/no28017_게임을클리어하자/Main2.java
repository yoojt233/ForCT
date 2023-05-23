package BaekJoon.no28017_게임을클리어하자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] game = new int[N][M];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j)
                game[i][j] = Integer.parseInt(st.nextToken());
        }

        Mini[] minis = {new Mini(-1, 0), new Mini(-1, 0)};

        int[][] dp = new int[N + 1][M];
        for (int i = 1; i < N + 1; ++i) {
            Mini m1 = null;
            Mini m2 = null;

            for (int j = 0; j < M; ++j) {
                int next = (j != minis[0].idx) ? minis[0].cost : minis[1].cost;
                int cur = dp[i][j] = game[i - 1][j] + next;

                if (m1 == null) m1 = new Mini(j, cur);
                else if (cur < m1.cost) {
                    m2 = m1;
                    m1 = new Mini(j, cur);
                } else if (m2 == null || cur < m2.cost) m2 = new Mini(j, cur);
            }
            minis[0] = m1;
            minis[1] = m2;
        }

        int ans = Integer.MAX_VALUE;
        for (int i : dp[N])
            ans = Math.min(ans, i);
        System.out.print(ans);
    }
}

class Mini {
    int idx;
    int cost;

    public Mini(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}