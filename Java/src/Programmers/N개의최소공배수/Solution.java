package Programmers.N개의최소공배수;

class Solution {
    public int solution(int[] arr) {
        int cur = arr[0];

        for (int i = 1; i < arr.length; i++) {
            cur = lcm(cur, arr[i]);
        }

        return cur;
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
}
