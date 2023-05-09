package java.BaekJoon.no2847_게임을만든동준이;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] level = new int[n];
		for (int i = 0; i < n; ++i)
			level[i] = Integer.parseInt(br.readLine());

		int ans = 0;
		int before = level[n - 1];
		for (int i = n - 2; i >= 0; --i) {
			if (level[i] >= before) {
				int x = before - 1;
				ans += level[i] - x;
				level[i] = x;
			}
			before = level[i];
		}
		System.out.print(ans);
	}
}
