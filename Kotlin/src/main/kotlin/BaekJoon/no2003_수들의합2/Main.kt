package BaekJoon.no2003_수들의합2

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val nums = readLine().split(" ").map { it.toInt() }.toIntArray()

    var ans = 0
    var left = 0
    var right = 0
    var temp = 0

    while (true) {
        if (temp >= m) temp -= nums[left++]
        else if (right == n) break
        else temp += nums[right++]

        if (temp == m) ++ans
    }

    print(ans)
}