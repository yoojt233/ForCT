package BaekJoon.no2482_색상환

fun main() = with(System.`in`.bufferedReader()) {
    val mod = 1000000003;
    val n = readLine().toInt();
    val m = readLine().toInt();

    val dp = Array(n + 1) { IntArray(m + 1) };
    repeat(n + 1) {
        dp[it][0] = 1;
        dp[it][1] = it;
    }

    for (i in 2..n) {
        for (j in 2..m) {
            dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % mod;
        }
    }
    print((dp[n - 1][m] + dp[n - 3][m - 1]) % mod)
}
