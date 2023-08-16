package BaekJoon.no2302_극장좌석

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()

    val dp = IntArray(41) { 1 }
    for (i in 2..n) dp[i] = dp[i - 1] + dp[i - 2]

    var ans = 1
    var fixed = 0
    repeat(m) {
        val temp = readLine().toInt()
        ans *= dp[temp - fixed - 1]
        fixed = temp
    }

    print(ans * dp[n - fixed])
}
