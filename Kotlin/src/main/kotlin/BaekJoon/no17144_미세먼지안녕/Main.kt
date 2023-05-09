package BaekJoon.no17144_미세먼지안녕

import java.util.LinkedList;

data class Pos(val r: Int, val c: Int);

data class AirCleaner(val upper: Pos, val under: Pos, val n: Int, val m: Int) {
    private val up = Array(upper.r + 1) { IntArray(m) };
    private val down = Array(n - under.r) { IntArray(m) };

    fun init() {
        for (i in up.indices) up[i] = board[i];
        for (i in down.indices) down[i] = board[i + under.r];
    }

    fun run() {
        for (i in upper.r - 1 downTo 1) up[i][0] = up[i - 1][0];
        for (j in 0 until m - 1) up[0][j] = up[0][j + 1];
        for (i in 0 until upper.r) up[i][m - 1] = up[i + 1][m - 1];
        for (j in m - 1 downTo 2) up[upper.r][j] = up[upper.r][j - 1];
        up[upper.r][upper.c + 1] = 0;

        for (i in 1 until down.size - 1) down[i][0] = down[i + 1][0];
        for (j in 0 until m - 1) down[down.size - 1][j] = down[down.size - 1][j + 1];
        for (i in down.size - 1 downTo 1) down[i][m - 1] = down[i - 1][m - 1];
        for (j in m - 1 downTo 2) down[0][j] = down[0][j - 1];
        down[0][1] = 0;
    }
}

val dx = intArrayOf(-1, 1, 0, 0);
val dy = intArrayOf(0, 0, -1, 1);
val res = LinkedList<Dust>();

data class Dust(val pos: Pos, var value: Int) {
    fun spread(n: Int, m: Int) {
        val son = value / 5;
        for (d in 0 until 4) {
            val nr = pos.r + dx[d];
            val nc = pos.c + dy[d];

            if (nr !in 0 until n || nc !in 0 until m || board[nr][nc] == -1) continue;
            res.add(Dust(Pos(nr, nc), son));
            res.add(Dust(pos, -son));
        }
    }
}

lateinit var board: Array<IntArray>;
lateinit var ac: AirCleaner;

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, t) = readLine().split(" ").map { it.toInt() };
    board = Array(n) { IntArray(m) };

    var flag = false;
    repeat(n) { i ->
        val input = readLine().split(" ").map { it.toInt() };
        repeat(m) { j ->
            board[i][j] = input[j];
            if (input[j] == -1 && !flag) {
                ac = AirCleaner(Pos(i, j), Pos(i + 1, j), n, m);
                flag = true;
            }
        }
    }
    ac.init();

    repeat(t) {
        getDusts(n, m);
        while (res.isNotEmpty()) {
            val cur = res.poll();
            board[cur.pos.r][cur.pos.c] += cur.value;
        }
        ac.run();
    }

    var ans = 0;
    repeat(n) { i ->
        repeat(m) { j ->
            if (board[i][j] > 0) ans += board[i][j];
        }
    }
    print(ans);
}

fun getDusts(n: Int, m: Int) {
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (board[i][j] >= 5) Dust(Pos(i, j), board[i][j]).spread(n, m);
        }
    }
}