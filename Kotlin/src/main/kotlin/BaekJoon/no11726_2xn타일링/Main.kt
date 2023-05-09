package BaekJoon.no11726_2xn타일링

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();

    val dp = Array(n + 1) { 0 };
    dp[1] = 1;
    if (n >= 2) {
        dp[2] = 2;
        for (i in 3..n) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
    }
    print(dp[n]);
}