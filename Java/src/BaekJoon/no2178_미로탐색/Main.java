package BaekJoon.no2178_미로탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char[][] board;
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		board = new char[n][m];
		for (int i = 0; i < n; ++i)
			board[i] = br.readLine().toCharArray();

		System.out.print(bfs());
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int bfs() {
		boolean[][] visited = new boolean[n][m];

		Queue<pos> q = new LinkedList<>();
		q.add(new pos(0, 0, 1));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			pos cur = q.poll();

			for (int i = 0; i < 4; ++i) {
				int nr = cur.r + dx[i];
				int nc = cur.c + dy[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] || board[nr][nc] == '0')
					continue;

				if (nr == n - 1 && nc == m - 1)
					return cur.move + 1;

				visited[nr][nc] = true;
				q.add(new pos(nr, nc, cur.move + 1));
			}
		}

		return -1;
	}
}

class pos {
	int r, c;
	int move;

	public pos(int r, int c, int move) {
		this.r = r;
		this.c = c;
		this.move = move;
	}
}