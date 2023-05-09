package BaekJoon.no9251_LCS

import kotlin.math.max;

fun main() = with(System.`in`.bufferedReader()) {
    val input = Array(2) { "" };
    repeat(2) {
        input[it] = readLine();
    }

    val dp = Array(input[0].length + 1) { IntArray(input[1].length + 1) };
    repeat(input[0].length) { i ->
        repeat(input[1].length) { j ->
            dp[i + 1][j + 1] = if (input[0][i] == input[1][j]) dp[i][j] + 1 else max(dp[i][j + 1], dp[i + 1][j]);
        }
    }
    print(dp[input[0].length][input[1].length]);
}