package Programmers.연습문제.미로탈출

class Solution {
    var N = 0
    var M = 0

    fun solution(maps: Array<String>): Int {
        lateinit var s: Pair<Int, Int>
        lateinit var l: Pair<Int, Int>
        lateinit var e: Pair<Int, Int>

        N = maps.size
        M = maps[0].length

        for (i in maps.indices) {
            for (j in maps[0].indices) {
                when (maps[i][j]) {
                    'S' -> s = Pair(i, j)
                    'L' -> l = Pair(i, j)
                    'E' -> e = Pair(i, j)
                }
            }
        }

        val toLever = bfs(maps, s, l)

        return if (toLever != -1) {
            val toEnd = bfs(maps, l, e)

            if (toEnd != -1) toLever + toEnd else -1
        } else -1
    }

    fun bfs(maps: Array<String>, op: Pair<Int, Int>, ed: Pair<Int, Int>): Int {
        val visited = Array(N) { BooleanArray(M) }
        val dq = ArrayDeque<Triple<Int, Int, Int>>()
        val d = arrayOf(
            intArrayOf(0, -1), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(1, 0)
        )

        dq.add(Triple(op.first, op.second, 0))
        visited[op.first][op.second] = true

        while (dq.isNotEmpty()) {
            val (r, c, level) = dq.removeFirst()

            for ((dx, dy) in d) {
                val nr = r + dx
                val nc = c + dy

                if (nr !in 0 until N || nc !in 0 until M || maps[nr][nc] == 'X' || visited[nr][nc]) continue
                if (nr == ed.first && nc == ed.second) return level + 1

                visited[nr][nc] = true
                dq.add(Triple(nr, nc, level + 1))
            }
        }

        return -1
    }
}

fun main() {
    val maps = arrayOf(
        "LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"
    )

    println(Solution().solution(maps))
}
