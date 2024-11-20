package BaekJoon.no1503_세수고르기

import kotlin.math.abs
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (n, s) = readLine().split(" ").map { it.toInt() }

    fun solve(): Int {
        if (s == 0) return 0

        val impo = readLine().split(" ").map { it.toInt() }.toHashSet()
        var res = Int.MAX_VALUE

        for (x in 1..1000) {
            if (impo.contains(x)) continue
            if (x > n && abs(n - x) >= res) break

            for (y in x..1000) {
                if (impo.contains(y)) continue

                val mid = x * y
                if (mid > n && abs(n - mid) >= res) break

                for (z in y..1001) {
                    if (impo.contains(z)) continue

                    val temp = mid * z

                    if (n == temp) return 0
                    else if (temp > n && abs(n - temp) >= res) break

                    res = min(res, abs(n - x * y * z))
                }
            }
        }

        return res
    }

    print(solve())
}
