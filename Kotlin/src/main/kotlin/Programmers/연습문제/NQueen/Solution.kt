package Programmers.연습문제.NQueen

import kotlin.math.abs

fun main() {
    val n = 4

    print(Solution().solution(n))
}

class Solution {
    fun solution(n: Int): Int {
        val queens = IntArray(n) { -1 }

        return play(0, queens)
    }

    fun play(idx: Int, queens: IntArray): Int {
        var res = 0

        if (idx == queens.size) return 1

        for (i in queens.indices) {
            if (queens[idx] != -1) continue

            queens[idx] = i
            if (check(idx, queens)) res += play(idx + 1, queens)
            queens[idx] = -1
        }

        return res
    }

    fun check(idx: Int, queens: IntArray): Boolean {
        for (i in 0 until idx) if (queens[idx] == queens[i] || idx - i == abs(queens[idx] - queens[i])) return false

        return true
    }
}