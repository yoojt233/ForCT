package java.BaekJoon.no1806_부분합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			arr[i] = Integer.parseInt(st.nextToken());

		int ans = N + 1, left = 0;
		do {
			int right = left;
			int sum = 0;
			OUT: while (right < N) {
				if (sum + arr[right] < target) {
					sum += arr[right];
					++right;
				} else {
					ans = Math.min(ans, right - left + 1);
					break OUT;
				}
			}
		} while (++left < N);

		System.out.print(ans != N + 1 ? ans : 0);
		br.close();
	}
}
