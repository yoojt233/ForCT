package Programmers.n진수게임;

import java.util.ArrayList;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Character>[] people = new ArrayList[t];
        for (int i = 0; i < m; i++) people[i] = new ArrayList<>();

        int curIndex = 0, curNum = 0, total = 0;

        while (total < m * t) {
            char[] num = Integer.toString(curNum++, n).toUpperCase().toCharArray();

            for (char c : num) {
                people[curIndex].add(c);
                curIndex = (curIndex + 1) % m;
            }
            total += num.length;
        }
        for (int i = 0; i < t; i++) sb.append(people[p - 1].get(i));

        return sb.toString();
    }
}
