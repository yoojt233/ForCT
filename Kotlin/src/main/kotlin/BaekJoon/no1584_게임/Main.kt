package BaekJoon.no1584_게임

import java.util.PriorityQueue

import kotlin.math.min
import kotlin.math.max

data class Node(val r: Int, val c: Int, val cost: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int = cost - other.cost
}

fun main() = with(System.`in`.bufferedReader()) {
    val limit = 501
    val dxdy = arrayOf(
        intArrayOf(-1, 0),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(0, 1)
    )
    val board = Array(limit) { IntArray(limit) }
    val visited = Array(limit) { BooleanArray(limit) }
    val pq = PriorityQueue<Node>()

    var ans = -1

    repeat(2) { i ->
        repeat(readLine().toInt()) {
            val (x1, y1, x2, y2) = readLine().split(" ").map { it.toInt() }

            fill(board, x1, y1, x2, y2, i + 1)
        }
    }

    if (board[limit - 1][limit - 1] != 2) {
        pq.add(Node(0, 0, 0))
        visited[0][0] = true

        OUT@ while (pq.isNotEmpty()) {
            val (r, c, cost) = pq.poll()

            for (d in dxdy) {
                val nr = r + d[0]
                val nc = c + d[1]

                if (nr == 500 && nc == 500) {
                    ans = cost + board[nr][nc]
                    break@OUT
                }

                if (nr !in 0 until limit || nc !in 0 until limit || visited[nr][nc] || board[nr][nc] == 2) continue

                visited[nr][nc] = true
                pq.add(Node(nr, nc, cost + board[nr][nc]))
            }
        }
    }

    print(ans)
}

fun fill(board: Array<IntArray>, x1: Int, y1: Int, x2: Int, y2: Int, v: Int) {
    for (i in min(x1, x2)..max(x1, x2)) {
        for (j in min(y1, y2)..max(y1, y2)) board[i][j] = max(board[i][j], v)
    }
}
