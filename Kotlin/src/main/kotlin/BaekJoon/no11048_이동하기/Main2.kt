package BaekJoon.no11048_이동하기

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    for (r in 0 until n) {
        for (c in 0 until m) {
            board[r][c] +=
                if (r == 0 && c == 0) 0
                else if (r == 0) board[r][c - 1]
                else if (c == 0) board[r - 1][c]
                else max(board[r - 1][c], board[r][c - 1])
        }
    }

    print(board[n - 1][m - 1])
}