package BaekJoon.no28437_막대만들기

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sticks = readLine().split(" ").map { it.toInt() }.toIntArray()

    val q = readLine().toInt()
    val targets = readLine().split(" ").map { it.toInt() }.toIntArray()
    val max_size = 100000

    val dp = IntArray(max_size + 1)
    for (stick in sticks) ++dp[stick]

    for (i in 1..max_size) {
        if (dp[i] == 0) continue

        var x = 2
        while (i * x <= max_size) dp[i * x++] += dp[i]
    }

    val sb = StringBuilder()
    for (target in targets) sb.append("${dp[target]} ")
    print(sb)
}