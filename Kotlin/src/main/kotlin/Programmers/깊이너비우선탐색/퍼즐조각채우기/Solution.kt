package Programmers.깊이너비우선탐색.퍼즐조각채우기

data class Pos(var r: Int, var c: Int) : Comparable<Pos> {
    fun move(dr: Int, dc: Int) {
        this.r -= dr
        this.c -= dc
    }

    fun switch() {
        this.r = c.also { this.c = -r }
    }

    override fun compareTo(other: Pos) = if (this.r != other.r) this.r - other.r else this.c - other.c
}

data class Shape(val positions: ArrayList<Pos>) {
    val size = positions.size

    fun minmax(): Pair<Int, Int> {
        var dr = Int.MAX_VALUE
        var dc = Int.MAX_VALUE

        for (p in positions) {
            dr = dr.coerceAtMost(p.r)
            dc = dc.coerceAtMost(p.c)
        }

        return Pair(dr, dc)
    }

    fun normalize(): Shape {
        val d = minmax()

        for (i in positions.indices) positions[i].move(d.first, d.second)
        positions.sort()

        return this
    }

    fun turn() {
        for (i in positions.indices) positions[i].switch()

        val d = minmax()

        for (i in positions.indices) positions[i].move(d.first, d.second)
        positions.sort()
    }
}

class Solution {
    val spaces = ArrayList<Shape>()
    val shapes = ArrayList<Shape>()

    fun solution(game_board: Array<IntArray>, table: Array<IntArray>): Int {
        val n = game_board.size
        val visited = Array(2) { Array(n) { BooleanArray(n) } }

        var res = 0

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (game_board[i][j] == 0 && !visited[0][i][j]) spaces.add(find(n, game_board, i, j, 0, visited[0]))
                if (table[i][j] == 1 && !visited[1][i][j]) shapes.add(find(n, table, i, j, 1, visited[1]))
            }
        }

        val used = BooleanArray(shapes.size)

        for (space in spaces) {
            for (i in shapes.indices) {
                if (used[i] || space.size != shapes[i].size) continue
                if (match(space, shapes[i])) {
                    used[i] = true
                    res += space.size
                    break
                }
            }
        }

        return res
    }

    fun match(a: Shape, b: Shape): Boolean {
        for (i in 0 until 4) {
            if (a.positions == b.positions) return true
            b.turn()
        }

        return false
    }

    fun find(n: Int, board: Array<IntArray>, r: Int, c: Int, v: Int, visited: Array<BooleanArray>): Shape {
        val dir = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(0, 1)
        )
        val positions = ArrayList<Pos>()
        val dq = ArrayDeque<Pos>()

        dq.add(Pos(r, c))
        visited[r][c] = true
        while (dq.isNotEmpty()) {
            val cur = dq.removeFirst()
            positions.add(cur)

            for (d in dir) {
                val nr = cur.r + d[0]
                val nc = cur.c + d[1]

                if (nr !in 0 until n || nc !in 0 until n || board[nr][nc] != v || visited[nr][nc]) continue

                visited[nr][nc] = true
                dq.add(Pos(nr, nc))
            }
        }

        return Shape(positions).normalize()
    }
}

fun main() {
    val game_board = arrayOf(
        intArrayOf(1, 1, 0, 0, 1, 0),
        intArrayOf(0, 0, 1, 0, 1, 0),
        intArrayOf(0, 1, 1, 0, 0, 1),
        intArrayOf(1, 1, 0, 1, 1, 1),
        intArrayOf(1, 0, 0, 0, 1, 0),
        intArrayOf(0, 1, 1, 1, 0, 0)
    )
    val table = arrayOf(
        intArrayOf(1, 0, 0, 1, 1, 0),
        intArrayOf(1, 0, 1, 0, 1, 0),
        intArrayOf(0, 1, 1, 0, 1, 1),
        intArrayOf(0, 0, 1, 0, 0, 0),
        intArrayOf(1, 1, 0, 1, 1, 0),
        intArrayOf(0, 1, 0, 0, 0, 0)
    )

    println(Solution().solution(game_board, table))
}
