package Programmers.숫자블록;

class Solution {
    int limit = 10_000_000;

    public int[] solution(long begin, long end) {
        int b = Math.toIntExact(begin);
        int e = Math.toIntExact(end);
        int[] res = new int[e - b + 1];

        for (int i = b; i <= e; i++) res[i - b] = (i <= limit * 2 && i % 2 == 0) ? i / 2 : prime(i);

        return res;
    }

    private int prime(int x) {
        if (x == 1) return 0;

        int res = 1;

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                res = i;

                if (x / i <= limit) return x / i;
            }
        }

        return res;
    }
}
