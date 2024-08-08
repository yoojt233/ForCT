package BaekJoon.no1459_걷기

import kotlin.math.*

fun main() = with(System.`in`.bufferedReader()) {
    var (x, y, w, s) = readLine().split(" ").map { it.toInt() }

    var res = 0L
    val left = abs(x - y)

    if (left % 2 != 0) res += w
    res += min(x, y) * min(s, w * 2).toLong()
    res += (left / 2) * min(s * 2, w * 2).toLong()

    print(res)
}
