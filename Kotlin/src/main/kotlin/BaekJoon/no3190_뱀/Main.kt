package BaekJoon.no3190_뱀

lateinit var board: Array<IntArray>
val dx = intArrayOf(0, 1, 0, -1);
val dy = intArrayOf(1, 0, -1, 0);

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    board = Array(n) { IntArray(n) };

    repeat(readLine().toInt()) {
        val temp = readLine().split(" ").map { it.toInt() - 1 };
        board[temp[0]][temp[1]] = 2;
    }

    val x = readLine().toInt();
    var did = 0;
    val turn = Array<Pair<Int, Char>?>(x) { null };
    repeat(x) {
        val temp = readLine().split(" ");
        turn[it] = Pair(temp[0].toInt(), temp[1][0]);
    }

    var time = 0;
    var dir = 0;
    val snake = Snake();
    snake.where.add(Pair(0, 0));
    while (true) {
        val head = snake.where.first();
        if (did < x && time == turn[did]!!.first) {
            dir = when (turn[did]!!.second) {
                'D' -> (dir + 1) % 4;
                else -> (dir + 3) % 4;
            }
            ++did;
        }
        val next = Pair(head.first + dx[dir], head.second + dy[dir]);
        if (next.first !in 0 until n || next.second !in 0 until n || board[next.first][next.second] == 1) break;

        snake.move(next, board[next.first][next.second] == 2);
        ++time;
    }
    print(time + 1);
}

data class Snake(val where: ArrayDeque<Pair<Int, Int>>) {
    constructor() : this(ArrayDeque<Pair<Int, Int>>());

    fun move(next: Pair<Int, Int>, isApple: Boolean) {
        board[next.first][next.second] = 1;
        where.addFirst(next);
        if (!isApple) {
            val temp = where.removeLast();
            board[temp.first][temp.second] = 0;
        }
    }
}