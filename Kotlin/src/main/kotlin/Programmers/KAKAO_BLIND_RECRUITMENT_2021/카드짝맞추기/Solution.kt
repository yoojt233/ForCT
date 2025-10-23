package Programmers.KAKAO_BLIND_RECRUITMENT_2021.카드짝맞추기

import kotlin.math.min

data class Pos(val r: Int, val c: Int, val cnt: Int)

class Solution {
    val dir = arrayOf(
        intArrayOf(-1, 0), intArrayOf(1, 0),
        intArrayOf(0, -1), intArrayOf(0, 1)
    )
    val mates = HashMap<Int, ArrayList<Pos>>()
    val checked = HashMap<Int, Boolean>()

    fun solution(board: Array<IntArray>, r: Int, c: Int): Int {
        for (i in 0 until 4) {
            for (j in 0 until 4) {
                if (board[i][j] == 0) continue

                if (mates[board[i][j]].isNullOrEmpty()) mates[board[i][j]] = arrayListOf(Pos(i, j, 0))
                else mates[board[i][j]]!!.add(Pos(i, j, 0))

                checked[board[i][j]] = false
            }
        }

        return permu(board, Pos(r, c, 0))
    }

    fun permu(board: Array<IntArray>, cur: Pos): Int {
        var res = Int.MAX_VALUE

        for (idx in mates.keys) {
            if (checked[idx] == true) continue

            val cards = mates[idx]!!
            val way1 = bfs(board, cur, cards[0]) + bfs(board, cards[0], cards[1]) + 2
            val way2 = bfs(board, cur, cards[1]) + bfs(board, cards[1], cards[0]) + 2

            checked[idx] = true
            for (p in cards) board[p.r][p.c] = 0

            res = min(res, way1 + permu(board, cards[1]))
            res = min(res, way2 + permu(board, cards[0]))

            checked[idx] = false
            for (p in cards) board[p.r][p.c] = idx
        }

        return if (res == Int.MAX_VALUE) 0 else res
    }

    fun bfs(board: Array<IntArray>, cur: Pos, next: Pos): Int {
        val dq = ArrayDeque<Pos>()
        val visited = Array(4) { BooleanArray(4) }

        dq.add(cur)
        while (dq.isNotEmpty()) {
            val cur = dq.removeFirst()

            if (cur.r == next.r && cur.c == next.c) return cur.cnt

            for ((dx, dy) in dir) {
                var nr = cur.r + dx
                var nc = cur.c + dy

                if (nr !in 0 until 4 || nc !in 0 until 4) continue

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true
                    dq.add(Pos(nr, nc, cur.cnt + 1))
                }

                for (t in 0 until 3) {
                    if (nr + dx !in 0 until 4 || nc + dy !in 0 until 4) break
                    if (board[nr][nc] != 0) break

                    nr += dx
                    nc += dy
                }

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true
                    dq.add(Pos(nr, nc, cur.cnt + 1))
                }
            }
        }

        return Int.MAX_VALUE
    }
}
