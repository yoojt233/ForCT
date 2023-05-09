package java.BaekJoon.no9019_DSLR;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; ++n) {
			String[] input = br.readLine().split(" ");
			number target = bfs(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			sb.append(target.path + "\n");
		}

		System.out.print(sb);
	}

	static char[] d = { 'D', 'S', 'L', 'R' };

	private static number bfs(int op, int ed) {
		Set<Integer> already = new HashSet<>();
		already.add(op);

		Queue<number> q = new LinkedList<>();
		q.add(new number(op, ""));

		while (!q.isEmpty()) {
			number cur = q.poll();

			for (int i = 0; i < 4; ++i) {
				int next = calc(d[i], cur.num);

				if (already.contains(next))
					continue;

				if (next == ed)
					return new number(next, cur.path + d[i]);

				already.add(next);
				q.add(new number(next, cur.path + d[i]));
			}
		}

		return null;
	}

	private static int calc(char cmd, int x) {
		switch (cmd) {
		case 'D':
			return (x * 2) % 10000;
		case 'S':
			return (x == 0) ? 9999 : x - 1;
		case 'L':
		case 'R':
			int a = x / 1000;
			int b = (x / 100) - 10 * a;
			int c = (x / 10) - 100 * a - 10 * b;
			int d = x - 1000 * a - 100 * b - 10 * c;
			return (cmd == 'L') ? b * 1000 + c * 100 + d * 10 + a : 1000 * d + 100 * a + 10 * b + c;
		}
		return 0;
	}
}

class number {
	int num;
	String path;

	public number(int num, String path) {
		this.num = num;
		this.path = path;
	}
}