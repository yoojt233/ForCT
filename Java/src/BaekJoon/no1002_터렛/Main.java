package BaekJoon.no1002_터렛;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            int[] input = new int[6];

            // [0]: x1, [1]: y1, [2]: r1, [3]: x2, [4]: y2, [5]: r2
            for (int i = 0; i < 6; i++)
                input[i] = Integer.parseInt(st.nextToken());

            double max = Double.max(input[2], input[5]);
            double min = Double.min(input[2], input[5]);

            int x = input[0] - input[3]; // x1 - x2
            int y = input[1] - input[4]; // y1 - y2

            double dist = Math.sqrt(x * x + y * y);
            int ans = 0;
            if (dist == 0) {
                if (max == min)
                    ans = -1;
            } else {
                if (dist > max) {
                    double temp = dist;
                    dist = max;
                    max = temp;
                }

                if (min + dist > max)
                    ans = 2;
                else if (min + dist == max)
                    ans = 1;
            }
            sb.append(ans + "\n");
        }

        System.out.print(sb.toString());
        br.close();
    }
}
