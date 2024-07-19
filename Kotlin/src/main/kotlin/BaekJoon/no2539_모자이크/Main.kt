package BaekJoon.no2539_모자이크

import kotlin.math.max
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val limit = readLine().toInt()
    val k = readLine().toInt()
    val positions = ArrayList<Pair<Int, Int>>()

    var left = 0
    var right = min(n, m)

    repeat(k) {
        val (r, c) = readLine().split(" ").map { it.toInt() }

        left = max(left, r)
        positions.add(Pair(r, c))
    }
    positions.sortBy { it.second }

    fun stick(x: Int): Int {
        var cnt = 0
        var prev = 0

        for (pos in positions) {
            if (prev == 0 || prev + x <= pos.second) {
                prev = pos.second
                ++cnt
            }
        }

        return cnt
    }

    while (left <= right) {
        val mid = (left + right) / 2

        if (stick(mid) > limit) left = mid + 1
        else right = mid - 1
    }

    print(left)
}
