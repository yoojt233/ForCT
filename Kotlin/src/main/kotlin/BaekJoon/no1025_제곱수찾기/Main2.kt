package BaekJoon.no1025_제곱수찾기

import kotlin.math.max
import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) { readLine().toCharArray().map { it.digitToInt() }.toIntArray() }

    var ans = -1

    fun check(x: Int) {
        val root = sqrt(x.toDouble()).toInt()

        if (root * root == x) ans = max(ans, x)
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            for (dr in -n until n) {
                for (dc in -m until m) {
                    if (dr == 0 && dc == 0) continue

                    var r = i
                    var c = j
                    var sum = 0

                    while ((r in 0 until n) && (c in 0 until m)) {
                        sum = sum * 10 + board[r][c]

                        check(sum)
                        r += dr
                        c += dc
                    }
                }
            }
        }
    }

    print(ans)
}
