package BaekJoon.no1932_정수삼각형

import kotlin.math.max;

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val numbers = Array(n) { IntArray(n) };
    repeat(n) { i ->
        val temp = readLine().split(" ").map { it.toInt() };
        for (j in temp.indices) numbers[i][j] = temp[j];
    }
    val dp = Array(n) { IntArray(n + 1) };
    dp[0][1] = numbers[0][0];

    var col = 2;
    for (i in 1 until n) {
        for (j in 1..col) {
            dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + numbers[i][j - 1];
        }
        ++col;
    }
    println("${dp[n - 1].maxOrNull()}");
}