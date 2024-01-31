package Programmers.KAKAO_BLIND_RECRUITMENT_2023.미로탈출명령어

import kotlin.math.abs

fun main() {
    val s = Solution()
    val n = 3
    val m = 3
    val x = 1
    val y = 2
    val r = 3
    val c = 3
    val k = 4

    print(s.solution(n, m, x, y, r, c, k))
}

class Solution {
    val dx = intArrayOf(1, 0, 0, -1)
    val dy = intArrayOf(0, -1, 1, 0)
    val dir = arrayOf('d', 'l', 'r', 'u')
    var ans = ""

    fun solution(n: Int, m: Int, x: Int, y: Int, r: Int, c: Int, k: Int): String {
        val flag = getDist(x, y, r, c)

        if (flag > k || (k - flag) % 2 == 1) return "impossible"
        dfs(n, m, x, y, r, c, k, 0, "")
        return ans
    }

    fun getDist(x1: Int, y1: Int, x2: Int, y2: Int): Int {
        return abs(x2 - x1) + abs(y2 - y1)
    }

    fun dfs(n: Int, m: Int, x: Int, y: Int, r: Int, c: Int, k: Int, level: Int, path: String) {
        if (k < level + getDist(x, y, r, c)) return

        if (level == k && x == r && y == c) {
            ans = path
            return
        }

        for (d in 0 until 4) {
            val nr = x + dx[d]
            val nc = y + dy[d]

            if (nr in 1..n && nc in 1 .. m && ans == "") dfs(n, m, nr, nc, r, c, k, level + 1, path + dir[d])
        }
    }
}