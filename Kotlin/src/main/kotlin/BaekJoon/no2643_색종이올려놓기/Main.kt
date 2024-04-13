package BaekJoon.no2643_색종이올려놓기

import kotlin.math.max
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val papers = Array(n) { Pair(0, 0) }
    val dp = IntArray(n) { 1 }
    var res = 0

    repeat(n) { i ->
        val (garo, sero) = readLine().split(" ").map { it.toInt() }
        papers[i] = Pair(min(garo, sero), max(garo, sero))
    }
    papers.sortWith(compareBy({ -it.first }, { -it.second }))

    for (i in 1 until n) {
        for (j in 0 until i) {
            if (papers[i].second <= papers[j].second) dp[i] = max(dp[i], dp[j] + 1)
        }

        res = max(res, dp[i])
    }

    print(res)
}