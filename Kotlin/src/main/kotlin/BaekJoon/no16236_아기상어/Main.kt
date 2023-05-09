package BaekJoon.no16236_아기상어

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

lateinit var board: Array<IntArray>;

val dx = arrayOf(-1, 0, 1, 0);
val dy = arrayOf(0, -1, 0, 1);
val baby = Fish(2, 0, 0, 0);

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    board = Array(n) { IntArray(n) };

    repeat(n) { i ->
        val input = readLine().split(" ").map { it.toInt() };
        repeat(n) { j ->
            board[i][j] = input[j];
            if (input[j] == 9) {
                baby.r = i;
                baby.c = j;
                board[i][j] = 0;
            }
        }
    }

    var time = 0;
    do {
        val move = bfs(n);
        time += move;
    } while (move != 0);
    print(time);
}

fun bfs(n: Int): Int {
    val visited = Array(n) { BooleanArray(n) };
    var move = 0;

    val q: Queue<Pair<Int, Int>> = LinkedList();
    q.add(Pair(baby.r, baby.c));
    visited[baby.r][baby.c] = true;

    while (q.isNotEmpty()) {
        val chance = q.size;
        val pq = PriorityQueue<Int>();

        repeat(chance) {
            val cur = q.poll();
            for (d in 0 until 4) {
                val nr = cur.first + dx[d];
                val nc = cur.second + dy[d];

                if (nr !in 0 until n || nc !in 0 until n || visited[nr][nc] || board[nr][nc] > baby.size) continue;
                if (board[nr][nc] != 0 && board[nr][nc] < baby.size) {
                    pq.add(nr * n + nc);
                } else {
                    visited[nr][nc] = true;
                    q.add(Pair(nr, nc));
                }
            }
        }

        if (pq.isNotEmpty()) {
            val next = pq.poll();
            baby.eat(next / n, next % n);
            return move + 1;
        }

        ++move;
    }

    return 0;
}

data class Fish(var size: Int, var catch: Int, var r: Int, var c: Int) {
    fun eat(r: Int, c: Int) {
        this.r = r;
        this.c = c;
        ++catch;

        board[r][c] = 0;

        if (size == catch) {
            ++size;
            catch = 0;
        }
    }
};