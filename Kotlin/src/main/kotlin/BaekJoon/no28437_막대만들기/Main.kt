package BaekJoon.no28437_막대만들기

import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sticks = readLine().split(" ").map { it.toInt() }.toSet()

    val q = readLine().toInt()
    val targets = readLine().split(" ").map { it.toInt() }.toIntArray()

    val max_size = targets.maxOrNull()!!
    val dp = IntArray(max_size + 1)
    for (i in 1..max_size) {
        for (x in 1..sqrt(i.toDouble()).toInt()) {
            if (i % x != 0) continue
            if (x != i / x) dp[i] += dp[i / x]
            dp[i] += dp[x]
        }
        if (sticks.contains(i)) ++dp[i]
    }

    val sb = StringBuilder()
    for (target in targets) sb.append("${dp[target]} ")
    print(sb)
}
