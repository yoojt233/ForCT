package BaekJoon.no1475_방번호;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[10];
        int ans = 0;

        while (n > 0) {
            int num = n % 10;
            if (num == 6) num = 9;

            ++cnt[num];
            n /= 10;
        }

        for (int i = 0; i < 9; i++) ans = Math.max(ans, cnt[i]);
        ans = Math.max(ans, ceilDiv(cnt[9], 2));

        System.out.println(ans);
    }

    private static int ceilDiv(int x, int y) {
        int res = x / y;

        return (x ^ y) >= 0 && (res * y != x) ? res + 1 : res;
    }
}
