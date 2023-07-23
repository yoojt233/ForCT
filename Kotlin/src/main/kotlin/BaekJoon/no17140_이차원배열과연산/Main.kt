package BaekJoon.no17140_이차원배열과연산

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val inf = 100
    val (r, c, k) = readLine().split(" ").map { it.toInt() }
    val board = Array(inf) { IntArray(inf) }
    var flag = true

    repeat(3) { i ->
        val temp = readLine().split(" ")
        repeat(3) { j ->
            board[i][j] = temp[j].toInt()
        }
    }

    var rLen = 3
    var cLen = 3

    var ans = 0
    while (ans < 100) {
        if (board[r - 1][c - 1] == k) break

        if (flag) {
            var len = 0
            for (i in 0 until rLen) {
                val cur = board[i]
                val m = HashMap<Int, Int>()
                for (j in 0 until cLen) {
                    if (cur[j] == 0) continue

                    m[cur[j]] = m.getOrDefault(cur[j], 0) + 1
                }
                val keys = m.keys.sortedWith(compareBy({ m[it] }, { it }))
                val size = keys.size

                var idx = 0
                for (k in keys) {
                    if (idx >= 100) break
                    board[i][idx] = k
                    board[i][idx + 1] = m[k]!!
                    idx += 2
                }

                for (j in size * 2 until cLen) {
                    if (board[i][j] == 0) continue
                    board[i][j] = 0
                }
                len = max(len, inf.coerceAtMost(size * 2))
            }
            cLen = len
        } else {
            var len = 0
            for (j in 0 until cLen) {
                val m = HashMap<Int, Int>()
                for (i in 0 until rLen) {
                    val cur = board[i][j]
                    if (cur == 0) continue

                    m[cur] = m.getOrDefault(cur, 0) + 1
                }
                val keys = m.keys.sortedWith(compareBy({ m[it] }, { it }))
                val size = keys.size

                var idx = 0
                for (k in keys) {
                    if (idx >= 100) break
                    board[idx][j] = k
                    board[idx + 1][j] = m[k]!!
                    idx += 2
                }

                for (i in size * 2 until rLen) {
                    if (board[i][j] == 0) continue
                    board[i][j] = 0
                }
                len = max(len, inf.coerceAtMost(size * 2))
            }
            rLen = len
        }
        flag = rLen >= cLen
        ++ans
    }

    print(if (board[r - 1][c - 1] == k) ans else -1)
}
