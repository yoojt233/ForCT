package BaekJoon.no2589_보물섬

import java.util.LinkedList;
import kotlin.math.max;

lateinit var board: Array<CharArray>;
lateinit var visited: Array<BooleanArray>;
val endPoint = LinkedList<Pos>();
var ans = 0;

data class Pos(val r: Int, val c: Int);

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };

    visited = Array(n) { BooleanArray(m) };
    board = Array(n) { CharArray(m) };
    repeat(n) {
        board[it] = readLine().toCharArray();
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (board[i][j] == 'W' || visited[i][j]) continue;
            findEd(n, m, Pos(i, j));
        }
    }

    for (p in endPoint) {
        ans = max(ans, bfs(n, m, p));
    }

    print(ans);
}

val dx = intArrayOf(-1, 1, 0, 0);
val dy = intArrayOf(0, 0, -1, 1);

fun findEd(n: Int, m: Int, op: Pos) {
    val q = LinkedList<Pos>();
    visited[op.r][op.c] = true;
    q.add(op);

    while (q.isNotEmpty()) {
        val cur = q.poll();
        var flag = false;

        for (d in 0 until 4) {
            val nr = cur.r + dx[d];
            val nc = cur.c + dy[d];

            if (nr !in 0 until n || nc !in 0 until m || board[nr][nc] == 'W' || visited[nr][nc]) continue;
            visited[nr][nc] = true;
            q.add(Pos(nr, nc));
            flag = true;
        }

        if (!flag) endPoint.add(cur);
    }
}

fun bfs(n: Int, m: Int, op: Pos): Int {
    val v = Array(n) { BooleanArray(m) };
    v[op.r][op.c] = true;

    val q = LinkedList<Pos>();
    q.add(op);

    var res = 0;
    while (q.isNotEmpty()) {
        val size = q.size;

        repeat(size) {
            val cur = q.poll();
            for (d in 0 until 4) {
                val nr = cur.r + dx[d];
                val nc = cur.c + dy[d];

                if (nr !in 0 until n || nc !in 0 until m || board[nr][nc] == 'W' || v[nr][nc]) continue;
                v[nr][nc] = true;
                q.add(Pos(nr, nc));
            }
        }
        ++res;
    }

    return res - 1;
}