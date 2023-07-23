package BaekJoon.no2879_코딩은예쁘게;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] tabs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        tabs = new int[2][n];
        for (int i = 0; i < 2; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) tabs[i][j] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int flag = 0;
        int op = 0;
        for (int i = 0; i < n; ++i) {
            int temp = tabs[1][i] - tabs[0][i];
            if (flag == 0) {
                flag = temp;
                op = i;
            }

            if (temp == 0 || (temp > 0 && flag < 0) || (temp < 0 && flag > 0)) {
                ans += solve(op, i - 1);
                flag = temp;
                op = i;
            }
        }
        ans += solve(op, n - 1);
        System.out.print(ans);
    }

    private static int solve(int op, int ed) {
        if (op > ed) return 0;
        else if (op == ed) return Math.abs(tabs[1][op] - tabs[0][op]);

        int cnt = 0;
        int idx = op;
        int limit = Integer.MAX_VALUE;
        boolean flag = tabs[1][op] - tabs[0][op] > 0 ? true : false;

        for (int i = op; i <= ed; ++i) {
            int temp = Math.abs(tabs[1][i] - tabs[0][i]);
            if (temp < limit) {
                idx = i;
                limit = temp;
            }
        }

        for (int i = op; i <= ed; ++i) {
            if (flag) tabs[0][i] += limit;
            else tabs[0][i] -= limit;
        }
        cnt += limit;
        return cnt + solve(op, idx - 1) + solve(idx + 1, ed);
    }
}
