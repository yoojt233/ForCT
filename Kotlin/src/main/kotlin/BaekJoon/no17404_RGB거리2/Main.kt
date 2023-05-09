package BaekJoon.no17404_RGB거리2

import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();

    val houses = Array(n) { IntArray(3) { 0 } };
    repeat(n) { i ->
        houses[i] = readLine().split(" ").map { it.toInt() }.toIntArray();
    }

    var ans = Int.MAX_VALUE;
    repeat(3) {
        val dp = Array(n) { IntArray(3) { Int.MAX_VALUE } };
        dp[0][it] = houses[0][it];

        for (i in 1 until n) {
            val before = Triple(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]);
            if (before.second != Int.MAX_VALUE || before.third != Int.MAX_VALUE)
                dp[i][0] = min(before.second, before.third) + houses[i][0];
            if (before.first != Int.MAX_VALUE || before.third != Int.MAX_VALUE)
                dp[i][1] = min(before.first, before.third) + houses[i][1];
            if (before.first != Int.MAX_VALUE || before.second != Int.MAX_VALUE)
                dp[i][2] = min(before.first, before.second) + houses[i][2];
        }

        for (i in 0 until 3) {
            if (i == it) continue;
            ans = min(ans, dp[n - 1][i]);
        }
    }

    print(ans);
}
