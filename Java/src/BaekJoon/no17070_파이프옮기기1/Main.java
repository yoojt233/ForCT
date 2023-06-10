package BaekJoon.no17070_파이프옮기기1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static char[][] board;
	static int[][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		board = new char[n][n];
		dp = new int[3][n][n];

		for (int i = 0; i < n; ++i) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < n; ++j)
				board[i][j] = input[j].charAt(0);
		}

		for (int i = 0; i < n; ++i) {
			if (board[0][i] == '1')
				break;
			dp[0][0][i] = 1;
		}

		for (int i = 1; i < n; ++i) {
			for (int j = 2; j < n; ++j) {
				if (board[i][j] == '1')
					continue;
				dp[0][i][j] = dp[0][i][j - 1] + dp[1][i][j - 1];
				dp[2][i][j] = dp[1][i - 1][j] + dp[2][i - 1][j];

				if (board[i - 1][j] == '1' || board[i][j - 1] == '1')
					continue;
				dp[1][i][j] = dp[0][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[2][i - 1][j - 1];
			}
		}
		System.out.print(dp[0][n - 1][n - 1] + dp[1][n - 1][n - 1] + dp[2][n - 1][n - 1]);
	}
}