package Programmers.프로그래머스_코드챌린지_1차_예선_2025.지게차와크레인

var n = 0
var m = 0
val dxdy = arrayOf(Pair(0, -1), Pair(0, 1), Pair(-1, 0), Pair(1, 0))

class Solution {
    fun solution(storage: Array<String>, requests: Array<String>): Int {
        n = storage.size
        m = storage[0].length

        val board = Array(n + 2) { CharArray(m + 2) { '!' } }

        var res = n * m

        for (i in 1..n) {
            for (j in 1..m) {
                board[i][j] = storage[i - 1][j - 1]
            }
        }

        for (req in requests) {
            when (req.length) {
                1 -> res -= fork(board, req[0])
                2 -> res -= crane(board, req[0])
                else -> continue
            }
        }

        return res
    }

    fun fork(board: Array<CharArray>, c: Char): Int {
        val forked = HashSet<Pair<Int, Int>>()

        for (i in 1..n) {
            for (j in 1..m) {
                if (board[i][j] != c) continue

                for (d in 0 until 4) {
                    if (board[i + dxdy[d].first][j + dxdy[d].second] != '!') continue

                    forked.add(Pair(i, j))
                    break
                }
            }
        }

        for (p in forked) board[p.first][p.second] = '!'

        dfs(board, Array(n + 2) { BooleanArray(m + 2) }, 0, 0)

        return forked.size
    }

    fun crane(board: Array<CharArray>, c: Char): Int {
        var res = 0

        for (i in 1..n) {
            for (j in 1..m) {
                if (board[i][j] != c) continue

                board[i][j] = '?'
                ++res
            }
        }

        dfs(board, Array(n + 2) { BooleanArray(m + 2) }, 0, 0)

        return res
    }

    fun dfs(board: Array<CharArray>, visited: Array<BooleanArray>, r: Int, c: Int) {
        for (d in 0 until 4) {
            val nr = r + dxdy[d].first
            val nc = c + dxdy[d].second

            if (nr !in 0 until n + 2 || nc !in 0 until m + 2 || visited[nr][nc]) continue

            when (board[nr][nc]) {
                '!' -> {
                    visited[nr][nc] = true
                    dfs(board, visited, nr, nc)
                }

                '?' -> {
                    board[nr][nc] = '!'
                    visited[nr][nc] = true
                    dfs(board, visited, nr, nc)
                }

                else -> continue
            }
        }
    }
}

fun main() {
    val storage = arrayOf("AAAAD", "ADCBD", "AAAAD")
    val requests = arrayOf("CC", "D", "B", "D")

    println(Solution().solution(storage, requests))
}