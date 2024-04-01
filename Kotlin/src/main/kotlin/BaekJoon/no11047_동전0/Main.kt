package BaekJoon.no11047_동전0

fun main() = with(System.`in`.bufferedReader()) {
    var (n, k) = readLine().split(" ").map { it.toInt() }
    val coins = IntArray(n) { readLine().toInt() }

    var res = 0
    for (i in n - 1 downTo 0) {
        val temp = k / coins[i]

        res += temp
        k -= (temp * coins[i])
    }
    print(res)
}