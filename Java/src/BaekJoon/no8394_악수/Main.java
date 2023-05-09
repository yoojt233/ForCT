package java.BaekJoon.no8394_악수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < N + 1; ++i)
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10;

		System.out.print(dp[N]);
		br.close();
	}
}
