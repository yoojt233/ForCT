package BaekJoon.no2075_N번째큰수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> nums = new PriorityQueue(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) {
            for (String num : br.readLine().split(" ")) nums.add(Integer.parseInt(num));
        }

        for (int i = 0; i < n - 1; ++i) nums.poll();
        System.out.println(nums.poll());

        br.close();
    }
}
