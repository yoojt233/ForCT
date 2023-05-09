package BaekJoon.no11660_구간합구하기5

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };

    val dp = Array(n + 1) { IntArray(n + 1) };
    repeat(n) { i ->
        val temp = readLine().split(" ").map { it.toInt() };
        repeat(n) { j ->
            dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + temp[j];
        }
    }

    val sb = StringBuilder();
    repeat(m) {
        val (x1, y1, x2, y2) = readLine().split(" ").map { it.toInt() };
        sb.append("${dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]}\n");
    }
    print(sb);
}