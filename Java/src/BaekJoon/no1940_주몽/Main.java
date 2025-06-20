package BaekJoon.no1940_주몽;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);

        int op = 0, ed = n - 1;

        while (op < ed) {
            int sum = nums[op] + nums[ed];

            if (sum == m) {
                ++ans;
                ++op;
                --ed;
            } else if (sum > m) --ed;
            else ++op;
        }

        System.out.println(ans);
    }
}
