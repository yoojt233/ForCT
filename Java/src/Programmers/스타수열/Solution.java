package Programmers.스타수열;

class Solution {
    public int solution(int[] a) {
        int[] cnt = new int[a.length];
        int temp = 0;

        for (int i : a) cnt[i]++;
        for (int i = 0; i < a.length; i++) {
            if (cnt[i] == 0 || cnt[i] * 2 <= temp) continue;

            int cur = 0;
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] != a[j + 1] && (a[j] == i || a[j + 1] == i)) {
                    cur += 2;
                    j++;
                }
            }

            temp = Math.max(temp, cur);
        }

        return temp;
    }
}
