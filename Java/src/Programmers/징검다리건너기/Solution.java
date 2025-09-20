package Programmers.징검다리건너기;

class Solution {
    public int solution(int[] stones, int k) {
        int op = 0, ed = 200_000_000;

        while (op < ed) {
            int mid = (op + ed) >> 1;

            if (check(stones, k, mid)) op = mid + 1;
            else ed = mid;
        }

        return op;
    }

    private boolean check(int[] stones, int k, int mid) {
        int cnt = 0;

        for (int stone : stones) {
            int temp = stone - mid;

            if (temp <= 0) {
                if (++cnt >= k) return false;
            } else cnt = 0;
        }

        return true;
    }
}
