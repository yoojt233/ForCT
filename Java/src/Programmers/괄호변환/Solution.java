package Programmers.괄호변환;

class Pair {
    int idx;
    boolean flag;

    public Pair(int idx, boolean flag) {
        this.idx = idx;
        this.flag = flag;
    }
}

class Solution {
    public String solution(String p) {
        if (p.isEmpty()) return p;

        StringBuilder sb = new StringBuilder();
        Pair temp = find(p);
        String u = p.substring(0, temp.idx + 1);
        String v = p.substring(temp.idx + 1);

        if (temp.flag) sb.append(u);
        else sb.append('(');

        sb.append(solution(v));

        if (!temp.flag) {
            char[] t = u.toCharArray();

            sb.append(')');
            for (int i = 1; i < u.length() - 1; i++) sb.append(invert(t[i]));
        }

        return sb.toString();
    }

    private Pair find(String p) {
        char[] temp = p.toCharArray();
        int[] bracket = new int[2];
        boolean flag = temp[0] == '(';

        for (int i = 0; i < p.length(); i++) {
            bracket[(temp[i] == '(') ? 0 : 1]++;

            if (bracket[0] == bracket[1]) return new Pair(i, flag);
        }

        return new Pair(p.length(), flag);
    }

    private char invert(char c) {
        return (c == '(') ? ')' : '(';
    }
}
