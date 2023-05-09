package BaekJoon.no15683_감시

import kotlin.math.min

lateinit var board: Array<IntArray>;
lateinit var origin: Array<BooleanArray>;

val cameras = ArrayList<CCTV>();
val directions = arrayOf(
    arrayOf(arrayOf(0), arrayOf(1), arrayOf(2), arrayOf(3)),
    arrayOf(arrayOf(0, 1), arrayOf(2, 3)),
    arrayOf(arrayOf(0, 3), arrayOf(1, 3), arrayOf(1, 2), arrayOf(0, 2)),
    arrayOf(arrayOf(0, 2, 3), arrayOf(0, 1, 3), arrayOf(1, 2, 3), arrayOf(0, 1, 2)),
    arrayOf(arrayOf(0, 1, 2, 3))
);
var total = 0;
val dx = arrayOf(-1, 1, 0, 0);
val dy = arrayOf(0, 0, -1, 1);

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };
    board = Array(n) { IntArray(m) };
    origin = Array(n) { BooleanArray(m) };

    repeat(n) { i ->
        val input = readLine().split(" ").map { it.toInt() };
        repeat(m) { j ->
            if (input[j] in 1..5) cameras.add(CCTV(input[j], i, j));
            else if (input[j] == 6) board[i][j] = -1;
            else {
                ++total;
                origin[i][j] = true;
            }
        }
    }

    var ans = total;
    fun move(depth: Int) {
        if (depth == cameras.size) {
            ans = min(ans, total);
            return;
        }

        val cur = cameras[depth];
        for (d in directions[cur.type - 1]) {
            for (dir in d) watch(n, m, cur, dir, '+');
            move(depth + 1);
            for (dir in d) watch(n, m, cur, dir, '-');
        }
    }

    move(0);
    print(ans);
}

fun watch(n: Int, m: Int, cctv: CCTV, dir: Int, operator: Char) {
    var r = cctv.r;
    var c = cctv.c;
    while (true) {
        r += dx[dir];
        c += dy[dir];
        if (r !in 0 until n || (c !in 0 until m) || board[r][c] == -1) break;

        when (operator) {
            '+' -> {
                if (board[r][c] == 0 && origin[r][c]) --total;
                ++board[r][c];
            }
            '-' -> {
                --board[r][c];
                if (board[r][c] == 0 && origin[r][c]) ++total;
            }
        }
    }
}

fun getChance(num: Int): Int {
    return when (num) {
        1, 3, 4 -> 4;
        2 -> 2;
        else -> 1;
    }
}

data class CCTV(val type: Int, val r: Int, val c: Int);