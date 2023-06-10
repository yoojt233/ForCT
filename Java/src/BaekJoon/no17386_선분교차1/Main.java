package BaekJoon.no17386_선분교차1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Point[][] input = new Point[2][2];
		for (int i = 0; i < 2; ++i) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < 2; ++j)
				input[i][j] = new Point(Integer.parseInt(temp[j * 2]), Integer.parseInt(temp[j * 2 + 1]));
			Arrays.sort(input[i]);
		}

		int a = ccw(input[0][0], input[0][1], input[1][0]) * ccw(input[0][0], input[0][1], input[1][1]);
		int b = ccw(input[1][0], input[1][1], input[0][0]) * ccw(input[1][0], input[1][1], input[0][1]);

		System.out.print((a <= 0 && b <= 0) ? 1 : 0);
	}

	private static int ccw(Point f, Point s, Point t) {
		long res = 1l * (s.x - f.x) * (t.y - f.y) - 1l * (t.x - f.x) * (s.y - f.y);
		return (res > 0) ? 1 : (res < 0) ? -1 : 0;
	}
}

class Point implements Comparable<Point> {
	int x, y;

	public Point(int a, int b) {
		this.x = a;
		this.y = b;
	}

	@Override
	public int compareTo(Point o) {
		return (this.x != o.x) ? this.x - o.x : o.y - this.y;
	}
}