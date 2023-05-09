package java.BaekJoon.no11727_2xn타일링2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 1; i < n; ++i) {
			dp[i] = (dp[i - 1] * 2) % 10007;
			dp[i] = (i % 2 == 1) ? (dp[i] + 1) % 10007 : (dp[i] - 1) % 10007;
		}

		System.out.print(dp[n - 1]);
	}
}
