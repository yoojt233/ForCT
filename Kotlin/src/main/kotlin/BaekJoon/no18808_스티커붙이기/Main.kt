package BaekJoon.no18808_스티커붙이기

data class Sticker(var r: Int, var c: Int, var shape: Array<IntArray>) {
    fun turn() {
        val newShape = Array(c) { IntArray(r) }

        repeat(r) { i ->
            repeat(c) { j ->
                newShape[j][r - i - 1] = shape[i][j]
            }
        }

        val temp = r

        this.r = c
        this.c = temp
        this.shape = newShape
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) { IntArray(m) }

    fun post(cur: Sticker, x: Int, y: Int): Boolean {
        var flag = true
        val q = ArrayList<Pair<Int, Int>>()

        out@ for (i in 0 until cur.r) {
            for (j in 0 until cur.c) {
                if (cur.shape[i][j] + board[x + i][y + j] > 1) {
                    flag = false
                    break@out
                }

                board[x + i][y + j] += cur.shape[i][j]
                q.add(Pair(i, j))
            }
        }

        if (!flag) for (pos in q) board[x + pos.first][y + pos.second] -= cur.shape[pos.first][pos.second]

        return flag
    }

    repeat(k) {
        val (r, c) = readLine().split(" ").map { it.toInt() }
        val cur = Sticker(r, c, Array(r) { readLine().split(" ").map { it.toInt() }.toIntArray() })

        var flag = false

        out@ for (d in 0 until 4) {
            for (i in 0..n - cur.r) {
                for (j in 0..m - cur.c) {
                    if (board[i][j] + cur.shape[0][0] > 1) continue

                    flag = post(cur, i, j)
                    if (flag) break@out
                }
            }
            cur.turn()
        }
    }

    print(board.sumOf { i -> i.sum() })
}
