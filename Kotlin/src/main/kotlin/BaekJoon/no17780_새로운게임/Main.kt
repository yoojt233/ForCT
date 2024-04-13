package BaekJoon.no17780_새로운게임

import java.util.Deque
import java.util.LinkedList

data class Piece(var r: Int, var c: Int, var dir: Int, var level: Int)

lateinit var origin: Array<IntArray>
lateinit var board: Array<Array<Deque<Piece>>>
lateinit var pieces: Array<Piece>
var flag = false

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    origin = Array(n) { IntArray(n) }
    board = Array(n) { Array(n) { LinkedList() } }
    repeat(n) { i ->
        origin[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    pieces = Array(k) { Piece(0, 0, 0, 0) }
    repeat(k) { i ->
        val (r, c, dir) = readLine().split(" ").map { it.toInt() - 1 }
        val cur = Piece(r, c, dir, board[r][c].size)
        board[r][c].add(cur)
        pieces[i] = cur

        if (cur.level >= 4) flag = true
    }

    var ans = 0
    while (!flag && ans < 1000) {
        move(n)
        ++ans
    }

    print(if (flag) ans else -1)
}

val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(1, -1, 0, 0)

fun move(n: Int) {
    for (piece in pieces) {
        if (piece.level != 0) continue

        val nr = piece.r + dx[piece.dir]
        val nc = piece.c + dy[piece.dir]

        if (nr !in 0 until n || nc !in 0 until n || origin[nr][nc] == 2) blue(n, piece)
        else if (origin[nr][nc] == 1) red(nr, nc, piece)
        else white(nr, nc, piece)

        if (flag) return
    }
}

fun blue(n: Int, piece: Piece) {
    piece.dir = reverse(piece.dir)
    val nr = piece.r + dx[piece.dir]
    val nc = piece.c + dy[piece.dir]

    if (nr !in 0 until n || nc !in 0 until n || origin[nr][nc] == 2) return
    else if (origin[nr][nc] == 1) red(nr, nc, piece)
    else white(nr, nc, piece)
}

fun red(nr: Int, nc: Int, piece: Piece) {
    val before = board[piece.r][piece.c]
    val after = board[nr][nc]
    var size = after.size

    while (before.isNotEmpty()) {
        val cur = before.pollLast()
        cur.r = nr
        cur.c = nc
        cur.level = size++
        after.add(cur)
    }
    if (after.size >= 4) flag = true
}

fun white(nr: Int, nc: Int, piece: Piece) {
    val before = board[piece.r][piece.c]
    val after = board[nr][nc]
    var size = after.size

    while (before.isNotEmpty()) {
        val cur = before.pollFirst()
        cur.r = nr
        cur.c = nc
        cur.level = size++
        after.add(cur)
    }
    if (after.size >= 4) flag = true
}

fun reverse(dir: Int): Int {
    return when (dir) {
        0 -> 1
        1 -> 0
        2 -> 3
        else -> 2
    }
}
