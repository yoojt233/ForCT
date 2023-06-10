package BaekJoon.no11399_ATM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(numbers);
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j <= i; j++)
				sum += numbers[j];
			ans += sum;
		}

		System.out.print(ans);
		br.close();
	}
}
