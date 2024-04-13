package BaekJoon.no27361_막대자르기

import kotlin.math.min

data class Stick(val len: Int, val cost: Long)

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    fun getCost(len: Int, a: Int, b: Int): Long {
        return if (len >= 2) 1L * a * (len - 1) * (len - 1) + b else 0
    }

    repeat(readLine().toInt()) {
        val (n, k, a, b) = readLine().split(" ").map { it.toInt() }
        val sticks = readLine().split(" ").map {
            val i = it.toInt()
            Stick(i, getCost(i, a, b))
        }.toList()
        val dp = LongArray(k + 1) { sticks.sumOf { it.cost } }

        for (i in 0 until n) {
            val cur = sticks[i]

            for (j in k downTo 1)
                dp[j] = min(dp[j], if (j <= cur.len) cur.cost else dp[j - cur.len] + cur.cost)
        }

        sb.append("${dp[k]}\n")
    }

    print(sb)
}
