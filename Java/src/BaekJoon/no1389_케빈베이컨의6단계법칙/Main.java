package BaekJoon.no1389_케빈베이컨의6단계법칙;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static int[][] board;
	static int[] sums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] basic = br.readLine().split(" ");
		n = Integer.parseInt(basic[0]);
		int m = Integer.parseInt(basic[1]);

		board = new int[n][n];
		for (int i = 0; i < n; ++i) {
			Arrays.fill(board[i], Integer.MAX_VALUE);
			board[i][i] = 0;
		}

		for (int i = 0; i < m; ++i) {
			String[] input = br.readLine().split(" ");
			int to = Integer.parseInt(input[0]) - 1;
			int from = Integer.parseInt(input[1]) - 1;

			board[to][from] = 1;
			board[from][to] = 1;
		}

		int tmp = Integer.MAX_VALUE;
		int ans = -1;
		for (int mid = 0; mid < n; ++mid) {
			for (int op = 0; op < n; ++op) {
				if (op == mid)
					continue;
				for (int ed = 0; ed < n; ++ed) {
					if (op == ed || mid == ed || board[op][mid] == Integer.MAX_VALUE || board[mid][ed] == Integer.MAX_VALUE)
						continue;
					board[op][ed] = Math.min(board[op][ed], board[op][mid] + board[mid][ed]);
					board[ed][op] = board[op][ed];
				}
			}
		}

		for (int i = 0; i < n; ++i) {
			int sum = 0;
			for (int dist : board[i])
				sum += dist;
			if (sum < tmp) {
				ans = i + 1;
				tmp = sum;
			}
		}
		System.out.print(ans);
	}
}