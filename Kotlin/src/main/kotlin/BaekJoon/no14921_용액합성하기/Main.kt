package BaekJoon.no14921_용액합성하기

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val liquids = readLine().split(" ").map { it.toInt() }.toIntArray()

    var left = 0
    var right = n - 1
    var ans = liquids[left] + liquids[right]

    while (left < right) {
        val mixed = liquids[left] + liquids[right]

        if (abs(ans) > abs(mixed)) ans = mixed
        if (mixed < 0) ++left else --right
    }

    print(ans)
}
