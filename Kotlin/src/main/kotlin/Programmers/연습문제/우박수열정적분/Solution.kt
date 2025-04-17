package Programmers.연습문제.우박수열정적분

class Solution {
    fun solution(k: Int, ranges: Array<IntArray>): DoubleArray {
        val res = DoubleArray(ranges.size)
        val areas = arrayListOf(0.0)

        var x = k
        while (x > 1) {
            val temp = if (x % 2 == 0) x / 2 else x * 3 + 1

            areas.add(areas.last() + (x + temp).toDouble() / 2)
            x = temp
        }

        for (i in ranges.indices) {
            val r = ranges[i]
            val op = r[0]
            val ed = r[1] + areas.size - 1

            res[i] = if (op > ed) -1.0 else areas[ed] - areas[op]
        }

        return res
    }
}

fun main() {
    val k = 3
    val ranges = arrayOf(
        intArrayOf(0, 0),
        intArrayOf(1, -2),
        intArrayOf(3, -3)
    )

    Solution().solution(k, ranges).forEach { println(it) }
}
