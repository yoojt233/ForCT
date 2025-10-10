package BaekJoon.no34472_교도소;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        long[] rooms = new long[n];
        long avg = 0L, ans = 0L;

        for (int i = 0; i < n; i++) {
            rooms[i] = Long.parseLong(input[i]);
            avg += rooms[i];
        }

        avg /= n;
        for (int i = 0; i < 2 * n - 1; i++) {
            int cur = i % n, next = (i + 1) % n;

            if (rooms[cur] > avg) {
                long move = rooms[cur] - avg;

                ans += move;
                rooms[cur] -= move;
                rooms[next] += move;
            }
        }

        System.out.println(ans);
    }
}
