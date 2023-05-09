package BaekJoon.no15644_구슬탈출3

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

lateinit var board: Array<CharArray>;
lateinit var red: Pos;
lateinit var blue: Pos;
val dx = arrayOf(-1, 1, 0, 0);
val dy = arrayOf(0, 0, -1, 1);
val d = arrayOf('U', 'D', 'L', 'R');

fun main(): Unit = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };
    board = Array(n) { CharArray(m) };
    repeat(n) { i ->
        val tmp = readLine();
        repeat(m) { j ->
            board[i][j] = tmp[j];
            when (tmp[j]) {
                'R' -> {
                    red = Pos(i, j, "");
                    board[i][j] = '.';
                }
                'B' -> {
                    blue = Pos(i, j, "");
                    board[i][j] = '.';
                }
            }
        }
    }

    val res = bfs(n, m);
    if (res == null) print(-1); else {
        print("${res.path.length}\n");
        res.path.map { print(it) };
    }
}

fun trans(rr: Pos, bb: Pos, m: Int): Int {
    return (rr.r * m + rr.c) * 100 + (bb.r * m + bb.c);
}

fun bfs(n: Int, m: Int): Pos? {
    val already = HashSet<Int>();
    already.add(trans(red, blue, m));

    var res = 0;
    var q = LinkedList<Array<Pos>>();
    q.add(arrayOf(red, blue));

    while (q.isNotEmpty()) {
        if (++res > 10) return null;
        repeat(q.size) {
            val cur = q.poll();
            repeat(4) { i ->
                val next = move(n, m, arrayOf(cur[0].copy(), cur[1].copy()), i);

                val redCur = board[next[0].r][next[0].c];
                val blueCur = board[next[1].r][next[1].c];

                if (redCur == 'O' && blueCur != 'O') return next[0];
                else if (redCur == '.' && blueCur == '.' && !already.contains(trans(next[0], next[1], m))) {
                    already.add(trans(next[0], next[1], m));
                    q.add(next);
                }
            }
        }
    }

    return null;
}

fun move(n: Int, m: Int, where: Array<Pos>, dir: Int): Array<Pos> {
    var flag = BooleanArray(2);
    while (true) {
        var hole = BooleanArray(2);
        repeat(2) {
            if (!flag[it]) {
                where[it].r += dx[dir];
                where[it].c += dy[dir];

                if (where[it].r < 0 || where[it].r >= n) {
                    where[it].r -= dx[dir];
                    flag[it] = true;
                } else if (where[it].c < 0 || where[it].c >= m) {
                    where[it].c -= dy[dir];
                    flag[it] = true;
                } else if (board[where[it].r][where[it].c] == '#') {
                    where[it].r -= dx[dir];
                    where[it].c -= dy[dir];
                    flag[it] = true;
                }
            }
        }

        repeat(2) {
            if (board[where[it].r][where[it].c] == 'O') {
                hole[it] = true;
                flag[it] = true;
            }
        }

        if (flag[1] && !hole[1] && where[0].r == where[1].r && where[0].c == where[1].c) {
            where[0].r -= dx[dir];
            where[0].c -= dy[dir];
            flag[0] = true;
        }

        if (flag[0] && !hole[0] && where[0].r == where[1].r && where[0].c == where[1].c) {
            where[1].r -= dx[dir];
            where[1].c -= dy[dir];
            flag[1] = true;
        }

        if (flag[0] && flag[1]) {
            where[0].path += d[dir];
            return where;
        }
    }
}

data class Pos(
    var r: Int,
    var c: Int,
    var path: String
)