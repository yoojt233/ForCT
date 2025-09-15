package Programmers.월간_코드_챌린지_시즌1.삼각달팽이

class Solution {
    fun solution(n: Int): IntArray {
        val arr = Array(n) { IntArray(n) { -1 } }
        val dir = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, -1))
        val res = ArrayList<Int>()

        var d = 0
        var r = 0
        var c = 0
        var cur = 1

        while (r in 0 until n && c in 0 until n && arr[r][c] == -1) {
            arr[r][c] = cur++

            val nr = r + dir[d][0]
            val nc = c + dir[d][1]

            if (nr !in 0 until n || nc !in 0 until n || arr[nr][nc] != -1) {
                d = (d + 1) % 3
                r += dir[d][0]
                c += dir[d][1]
            } else {
                r = nr
                c = nc
            }
        }

        for (ar in arr) {
            OUT@ for (num in ar) {
                if (num < 0) break@OUT

                res.add(num)
            }
        }

        return res.toIntArray()
    }
}

fun main() {
    val n = 6

    Solution().solution(n).forEach { print("$it ") }
}