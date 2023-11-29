package BaekJoon.no2110_공유기설치

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, c) = readLine().split(" ").map { it.toInt() }
    val houses = IntArray(n) { readLine().toInt() }.sorted()
    var left = 1
    var right = houses[n - 1] - houses[0]
    var res = 0

    while (left <= right) {
        val mid = (left + right) / 2
        var cnt = 1
        var installed = houses[0]

        for (i in 0 until n) {
            if (installed + mid <= houses[i]) {
                installed = houses[i]
                ++cnt
            }
        }

        if (cnt < c) right = mid - 1
        else {
            res = max(res, mid)
            left = mid + 1
        }
    }

    print(res)
}