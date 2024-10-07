package Programmers.PCCP기출문제.퍼즐게임챌린지

fun main() {
    val diffs = intArrayOf(1, 99999, 100000, 99995)
    val times = intArrayOf(9999, 9001, 9999, 9001)
    val limit = 3456789012L

    print(Solution().solution(diffs, times, limit))
}

class Solution {
    fun solution(diffs: IntArray, times: IntArray, limit: Long): Int {
        var left = 1
        var right = diffs.maxOrNull()!!

        while (left <= right) {
            val mid = (left + right) shr 1
            val temp = solve(diffs, times, limit, mid)

            if (temp > limit) left = mid + 1
            else right = mid - 1
        }

        return left
    }

    fun solve(diffs: IntArray, times: IntArray, limit: Long, level: Int): Long {
        var res = 0L

        for (i in diffs.indices) {
            if (diffs[i] <= level) res += times[i]
            else {
                val gap = diffs[i] - level

                res += (times[i - 1] + times[i]) * gap + times[i]
            }

            if (res > limit) return res
        }

        return res
    }
}
