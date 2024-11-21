package BaekJoon.no1025_제곱수찾기

import kotlin.math.max
import kotlin.math.sqrt

var ans = -1

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) { readLine().toCharArray() }

    for (i in 0 until n) {
        for (j in 0 until m) {
            var org = "" + board[i][j]

            check(org.toInt())

            // 우
            for (step in 1 until m) goRight(board, org, i, j, step)
            // 하
            for (step in 1 until n) goDown(board, org, i, j, step)
            //우하, 우상
            for (sj in 1 until m) {
                for (si in 1 until n) {
                    goRightDown(board, org, i, j, si, sj)
                    goRightUp(board, org, i, j, si, sj)
                }
            }

        }
    }

    print(ans)
}

fun check(target: Int) {
    val root = sqrt(target.toDouble()).toInt()

    if (root * root == target) ans = max(ans, target)
}

fun check(target: String) {
    check(target.toInt())
    check(target.reversed().toInt())
}

fun goRight(board: Array<CharArray>, org: String, i: Int, j: Int, step: Int) {
    if (j + step >= board[i].size) return

    val next = org + board[i][j + step]

    check(next)
    goRight(board, next, i, j + step, step)
}

fun goDown(board: Array<CharArray>, org: String, i: Int, j: Int, step: Int) {
    if (i + step >= board.size) return

    val next = org + board[i + step][j]

    check(next)
    goDown(board, next, i + step, j, step)
}

fun goRightDown(board: Array<CharArray>, org: String, i: Int, j: Int, si: Int, sj: Int) {
    if (j + sj >= board[0].size || i + si >= board.size) return

    val next = org + board[i + si][j + sj]

    check(next)
    goRightDown(board, next, i + si, j + sj, si, sj)
}

fun goRightUp(board: Array<CharArray>, org: String, i: Int, j: Int, si: Int, sj: Int) {
    if (j + sj >= board[0].size || i - si < 0) return

    val next = org + board[i - si][j + sj]

    check(next)
    goRightUp(board, next, i - si, j + sj, si, sj)
}
