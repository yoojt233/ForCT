package Programmers.광고삽입;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int[] time_logs = new int[360001];
        int ed = timeToInt(play_time);
        int adv = timeToInt(adv_time);
        int res = 0;
        long temp = 0;
        long cur = temp;

        for (String log : logs) {
            String[] s = log.split("-");

            time_logs[timeToInt(s[0])]++;
            time_logs[timeToInt(s[1])]--;
        }
        for (int i = 1; i < time_logs.length; i++) time_logs[i] += time_logs[i - 1];
        for (int i = adv; i <= ed; i++) {
            cur += (time_logs[i] - time_logs[i - adv]);

            if (cur > temp) {
                res = i - adv + 1;
                temp = cur;
            }
        }

        return solve(res);
    }

    private String solve(int res) {
        StringBuilder sb = new StringBuilder();

        int h = res / 3600;
        if (h < 10) sb.append("0");
        sb.append(h).append(":");

        res %= 3600;
        int m = res / 60;
        if (m < 10) sb.append("0");
        sb.append(m).append(":");

        res %= 60;
        if (res < 10) sb.append("0");
        sb.append(res);

        return sb.toString();
    }

    private int timeToInt(String s) {
        String[] temp = s.split(":");

        return Integer.parseInt(temp[0]) * 3600 + Integer.parseInt(temp[1]) * 60 + Integer.parseInt(temp[2]);
    }
}
