package BaekJoon.no11057_오르막수

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();

    val dp = IntArray(10) { 1 };
    repeat(n - 1) {
        for (i in 8 downTo 0) dp[i] = (dp[i] + dp[i + 1]) % 10007;
    }
    var ans = 0;
    for (i in dp) ans = (ans + i) % 10007;
    print(ans);
}