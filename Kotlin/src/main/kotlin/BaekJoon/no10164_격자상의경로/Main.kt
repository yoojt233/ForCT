package BaekJoon.no10164_격자상의경로

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() };

    fun solve(r: Int, c: Int, op: Int): Int {
        val dp = Array(r) { IntArray(c) };
        for (i in 0 until r) {
            for (j in 0 until c) {
                dp[i][j] = if (i == 0 || j == 0) op else dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[r - 1][c - 1];
    }

    if (k == 0) print(solve(n, m, 1));
    else {
        val a = (k - 1) / m + 1;
        val b = (k - 1) % m + 1;

        val c = n + 1 - a;
        val d = m + 1 - b;

        print(solve(c, d, solve(a, b, 1)));
    }
}