package BaekJoon.no1806_부분합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; ++i)
			arr[i] = Integer.parseInt(st.nextToken());

		int ans = N + 1, left = 0, right = 0, sum = 0;
		while (true) {
			if (sum >= target) {
				sum -= arr[left++];
				ans = Math.min(ans, right - left + 1);
			} else if (right == N)
				break;
			else
				sum += arr[right++];
		}

		System.out.print(ans != N + 1 ? ans : 0);
		br.close();
	}
}
