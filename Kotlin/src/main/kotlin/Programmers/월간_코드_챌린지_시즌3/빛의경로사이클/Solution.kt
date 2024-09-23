fun main() {
    val grid = arrayOf("R", "R")

    Solution().solution(grid).forEach { print("$it ") }
}

data class Pair(var r: Int, var c: Int)

class Solution {
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)

    lateinit var visited: Array<Array<BooleanArray>>
    var n = 0
    var m = 0

    fun go(grid: Array<String>, n: Int, m: Int, cur: Pair, d: Int): Int {
        var dir = d
        var cnt = 0

        while (!visited[dir][cur.r][cur.c]) {
            visited[dir][cur.r][cur.c] = true

            dir = when (grid[cur.r][cur.c]) {
                'L' -> (dir + 1) % 4
                'R' -> (dir + 3) % 4
                else -> dir
            }

            cur.r = (cur.r + dx[dir] + n) % n
            cur.c = (cur.c + dy[dir] + m) % m
            ++cnt
        }

        return cnt
    }

    fun solution(grid: Array<String>): IntArray {
        val res = ArrayList<Int>()

        n = grid.size
        m = grid[0].length

        visited = Array(4) { Array(n) { BooleanArray(m) } }

        for (r in 0 until n) {
            for (c in 0 until m) {
                for (d in 0 until 4) {
                    if (visited[d][r][c]) continue
                    res.add(go(grid, n, m, Pair(r, c), d))
                }
            }
        }

        return res.sorted().toIntArray()
    }
}
