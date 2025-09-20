package Programmers.숫자의표현;

class Solution {
    public int solution(int n) {
        int res = 1;

        for (int i = 1; i < n; i++) {
            int temp = i;

            for (int j = i + 1; j < n; j++) {
                temp += j;

                if (temp >= n) {
                    if (temp == n) ++res;
                    break;
                }
            }
        }

        return res;
    }
}
