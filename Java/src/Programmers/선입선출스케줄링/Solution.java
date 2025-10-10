package Programmers.선입선출스케줄링;

class Solution {
    public int solution(int n, int[] cores) {
        if (n <= cores.length) return n;

        n -= cores.length;

        int op = 0, ed = 10000 * n;
        int time = 0, done = 0, res = 0;

        while (op <= ed) {
            int mid = (op + ed) >> 1;
            int total = 0;

            for (int core : cores) total += (mid / core);

            if (total >= n) {
                time = mid;
                ed = mid - 1;
            } else op = mid + 1;
        }

        for (int core : cores) done += ((time - 1) / core);
        n -= done;
        for (int i = 0; i < cores.length; i++) {
            if (time % cores[i] != 0) continue;
            if (--n == 0) {
                res = i + 1;
                break;
            }
        }

        return res;
    }
}
