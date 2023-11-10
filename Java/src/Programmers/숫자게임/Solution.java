package Programmers.숫자게임;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] A = new int[]{5, 1, 3, 7};
        int[] B = new int[]{2, 2, 6, 8};

        System.out.println(solution(A, B));
    }

    private static int solution(int[] A, int[] B) {
        PriorityQueue<Integer> a = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : A) a.add(i);
        for (int i : B) b.add(i);

        int res = 0;
        while (!b.isEmpty()) {
            int cur = b.poll();
            while (!a.isEmpty()) {
                if (a.poll() >= cur) continue;
                ++res;
                break;
            }
        }

        return res;
    }
}
