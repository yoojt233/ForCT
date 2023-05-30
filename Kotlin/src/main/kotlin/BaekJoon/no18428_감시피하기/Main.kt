package BaekJoon.no18428_감시피하기

import java.util.StringTokenizer

data class Pos(val r: Int, val c: Int)

lateinit var board: Array<CharArray>
val blanks = ArrayList<Pos>();
val teachers = ArrayList<Pos>();
var flag = false;

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine());
    val n = st.nextToken().toInt();

    board = Array(n) { CharArray(n) };
    repeat(n) { i ->
        st = StringTokenizer(readLine());
        repeat(n) { j ->
            board[i][j] = st.nextToken()[0];
            when (board[i][j]) {
                'X' -> blanks.add(Pos(i, j));
                'T' -> teachers.add(Pos(i, j));
            }
        }
    }

    combo(n, 0, 0);
    print(if (flag) "YES" else "NO");
}

fun combo(n: Int, level: Int, op: Int) {
    if (level == 3) {
        var temp = true;
        for (teacher in teachers) {
            temp = temp && watch(n, teacher);
            if (!temp) break;
        }
        if (temp) flag = true;
        return;
    }

    for (i in op until blanks.size) {
        val cur = blanks[i];
        board[cur.r][cur.c] = 'O';
        combo(n, level + 1, i + 1);
        if (flag) return;
        board[cur.r][cur.c] = 'X'
    }
}

val dx = intArrayOf(-1, 1, 0, 0);
val dy = intArrayOf(0, 0, -1, 1);

fun watch(n: Int, teacher: Pos): Boolean {
    var res = true;
    for (d in 0 until 4) {
        var nr = teacher.r + dx[d];
        var nc = teacher.c + dy[d];

        while (true) {
            if (nr !in 0 until n || nc !in 0 until n || board[nr][nc] == 'O') break;
            else if (board[nr][nc] == 'S') {
                res = false;
                break;
            }
            nr += dx[d];
            nc += dy[d];
        }

        if (!res) break;
    }
    return res;
}