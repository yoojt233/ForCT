package java.BaekJoon.no10431_줄세우기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void Main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] temp = br.readLine().split(" ");
			sb.append(temp[0] + " ");

			int[] children = new int[20];
			for (int i = 1; i < temp.length; ++i)
				children[i - 1] = Integer.parseInt(temp[i]);

			int ans = 0;
			int tallest = children[0];
			for (int i = 1; i < children.length; ++i) {
				if (children[i] < tallest) {
					for (int j = 0; j < i; ++j) {
						if (children[j] > children[i])
							++ans;
					}
				} else
					tallest = children[i];
			}
			sb.append(ans + "\n");
		}
		System.out.print(sb);
	}
}
