package BaekJoon.no8982_수족관1

import kotlin.math.max

data class Pos(val r: Int, val c: Int) : Comparable<Pos> {
    override fun compareTo(other: Pos): Int {
        return if (c != other.c) c - other.c; else r - other.r;
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val board = ArrayList<Int>();

    repeat(readLine().toInt() / 2) {
        val (sr, sc) = readLine().split(" ").map { it.toInt() };
        val (er, rc) = readLine().split(" ").map { it.toInt() };

        while (board.size < sr) board.add(board.last());
        board.add(rc)
    }
    board.removeLast();

    val holes = ArrayList<Pos>();
    repeat(readLine().toInt()) {
        val (a, b, c, d) = readLine().split(" ").map { it.toInt() };
        holes.add(Pos((a + c) / 2, b));
    }
    holes.sort();

    val out = IntArray(board.size);
    for (hole in holes) {
        var std = board[hole.r];

        for (i in hole.r - 1 downTo 0) {
            if (std >= board[i]) std = board[i];
            out[i] = max(out[i], std);
        }

        std = board[hole.r];
        for (i in hole.r until board.size) {
            if (std >= board[i]) std = board[i];
            out[i] = max(out[i], std);
        }
    }

    var ans = 0;
    for (i in 0 until board.size) ans += (board[i] - out[i]);
    print(ans);
}
