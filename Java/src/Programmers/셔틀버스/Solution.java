package Programmers.셔틀버스;

import java.util.Arrays;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] people = new int[timetable.length];
        int idx = 0, res = 0;

        for (int i = 0; i < timetable.length; i++) people[i] = timeToInt(timetable[i]);
        Arrays.sort(people);

        for (int i = 0; i < n; i++) {
            int shuttle = 540 + i * t;
            int temp = 0;

            while (true) {
                if (idx == people.length) break;

                int person = people[idx];

                if (person <= shuttle && temp < m) {
                    ++temp;
                    ++idx;
                } else break;

                res = person - 1;
            }

            if (i == n - 1 && temp < m) res = shuttle;
        }

        return String.format("%02d:%02d", res / 60, res % 60);
    }

    private int timeToInt(String s) {
        String[] temp = s.split(":");

        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
}
