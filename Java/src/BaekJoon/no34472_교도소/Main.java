package BaekJoon.no34472_교도소;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        long[] rooms = new long[n];
        long sum = 0L;

        for (int i = 0; i < n; i++) {
            rooms[i] = Long.parseLong(input[i]);
            sum += rooms[i];
        }

        long avg = sum / n;
        long lower = 0;
        long[] temp = new long[n];

        rooms[0] -= avg;
        for (int i = 1; i < n; i++) rooms[i] = (rooms[i] - avg) + rooms[i - 1];
        for (int i = 0; i < n - 1; i++) {
            temp[i + 1] = -rooms[i];

            if (temp[i + 1] > lower) lower = temp[i + 1];
        }

        Arrays.sort(temp);
        lower = Math.max(lower, temp[n / 2]);
        long ans = 0;

        for (int i = 0; i < n; i++) ans += Math.abs(temp[i] - lower);

        System.out.println(ans);
    }
}
