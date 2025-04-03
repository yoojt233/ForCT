package BaekJoon.no9657_돌게임3

fun main() = with(System.`in`.bufferedReader()) {
    val target = readLine().toInt()
    val dp = BooleanArray(target.coerceAtLeast(4) + 1)

    dp[1] = true
    dp[3] = true
    dp[4] = true

    for (i in 5..target) dp[i] = !(dp[i - 4] && dp[i - 3] && dp[i - 1])

    print(if (dp[target]) "SK" else "CY")
}
