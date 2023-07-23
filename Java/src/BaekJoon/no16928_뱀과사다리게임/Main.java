package BaekJoon.no16928_뱀과사다리게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static int n, m;
	static Map<Integer, Integer> ladders;
	static Map<Integer, Integer> snakes;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		ladders = new HashMap<>();
		snakes = new HashMap<>();

		for (int i = 0; i < n; ++i) {
			String[] temp = br.readLine().split(" ");
			ladders.put(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
		}

		for (int i = 0; i < m; ++i) {
			String[] temp = br.readLine().split(" ");
			snakes.put(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
		}

		System.out.print(bfs());
	}

	private static int bfs() {
		boolean[] visited = new boolean[100];
		visited[0] = true;

		Queue<Integer> q = new LinkedList<>();
		q.add(1);

		int cnt = 1;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int s = 0; s < size; ++s) {
				int cur = q.poll();

				for (int i = 1; i <= 6; ++i) {
					int next = cur + i;
					if (visited[next - 1])
						continue;
					visited[next - 1] = true;
					next = (ladders.containsKey(next)) ? ladders.get(next) : (snakes.containsKey(next)) ? snakes.get(next) : next;
					if (next == 100)
						return cnt;
					visited[next - 1] = true;
					q.add(next);
				}
			}
			++cnt;
		}

		return -1;
	}
}