package Programmers.추석트래픽;

class Solution {
    public int solution(String[] lines) {
        int n = lines.length;
        int res = 0;
        long[] starts = new long[n];
        long[] ends = new long[n];

        for (int i = 0; i < n; i++) {
            String line = lines[i];
            String[] temp = line.split(" ");
            long ed = timeToLong(temp[1]);
            long work = workToLong(temp[2]);

            ends[i] = ed;
            starts[i] = ed - work + 1;
        }

        for (int i = 0; i < n; i++) {
            long op = ends[i];
            long ed = op + 999;
            int temp = 0;

            for (int j = 0; j < n; j++) {
                if (starts[j] <= ed && ends[j] >= op) ++temp;
            }

            res = Math.max(res, temp);
        }

        return res;
    }

    private long workToLong(String str) {
        String temp = str.replace("s", "");
        double s = Double.parseDouble(temp);

        return (long) (s * 1000);
    }

    private long timeToLong(String str) {
        String[] temp = str.split(":");
        String[] seconds = temp[2].split("\\.");
        long h = Long.parseLong(temp[0]) * 3600 * 1000;
        long m = Long.parseLong(temp[1]) * 60 * 1000;
        long s = Long.parseLong(seconds[0]) * 1000;
        long ms = Long.parseLong(seconds[1]);

        return h + m + s + ms;
    }
}
