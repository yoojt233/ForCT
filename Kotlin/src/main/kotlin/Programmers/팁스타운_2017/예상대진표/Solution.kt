package Programmers.팁스타운_2017.예상대진표

import kotlin.math.log2

fun main() {
    val n = 8
    val a = 1
    val b = 2

    print(Solution().solution(n, a, b))
}

class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        val half = n / 2

        if (a > half == b > half) {
            return if (a > half) solution(half, a - half, b - half)
            else solution(half, a, b)
        }

        return log2(n.toDouble()).toInt()
    }
}