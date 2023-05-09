package BaekJoon.no12100_2048Easy

var n = 0;
fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt();

    val origin = Array(n) { IntArray(n) };
    repeat(n) { i ->
        origin[i] = readLine().split(" ").map { it.toInt() }.toIntArray();
    }

    var ans = 0;
    fun move(clone: Array<IntArray>, depth: Int, dir: Int) {
        when (dir) {
            0 -> up(clone);
            1 -> down(clone);
            2 -> left(clone);
            3 -> right(clone);
        }

        if (depth == 4) {
            for (arr in clone) {
                for (i in arr) if (i > ans) ans = i;
            }
            return;
        }

        for (d in 0 until 4) {
            move(deepCopy(clone), depth + 1, d);
        }
    }

    for (d in 0 until 4) {
        move(deepCopy(origin), 0, d);
    }

    print(ans);
}

fun deepCopy(origin: Array<IntArray>): Array<IntArray> {
    val row = origin.size;
    val column = origin[0].size;
    val temp = Array(row) { IntArray(column) };

    repeat(row) { i ->
        repeat(column) { j ->
            temp[i][j] = origin[i][j];
        }
    }

    return temp;
}

fun up(board: Array<IntArray>) {
    for (j in 0 until n) {
        var top = 0;
        for (i in 1 until n) {
            if (board[i][j] == 0) continue;

            if (board[i][j] == board[top][j]) {
                board[top++][j] *= 2;
                board[i][j] = 0;
            } else {
                if (board[top][j] == 0) board[top][j] = board[i][j];
                else board[++top][j] = board[i][j];

                if (top != i) board[i][j] = 0;
            }
        }
    }
}

fun down(board: Array<IntArray>) {
    for (j in 0 until n) {
        var top = n - 1;
        for (i in n - 2 downTo 0) {
            if (board[i][j] == 0) continue;

            if (board[i][j] == board[top][j]) {
                board[top--][j] *= 2;
                board[i][j] = 0;
            } else {
                if (board[top][j] == 0) board[top][j] = board[i][j];
                else board[--top][j] = board[i][j];

                if (top != i) board[i][j] = 0;
            }
        }
    }
}

fun left(board: Array<IntArray>) {
    for (i in 0 until n) {
        var top = 0;
        for (j in 1 until n) {
            if (board[i][j] == 0) continue;

            if (board[i][j] == board[i][top]) {
                board[i][top++] *= 2;
                board[i][j] = 0;
            } else {
                if (board[i][top] == 0) board[i][top] = board[i][j];
                else board[i][++top] = board[i][j];

                if (top != j) board[i][j] = 0;
            }
        }
    }
}

fun right(board: Array<IntArray>) {
    for (i in 0 until n) {
        var top = n - 1;
        for (j in n - 2 downTo 0) {
            if (board[i][j] == 0) continue;

            if (board[i][j] == board[i][top]) {
                board[i][top--] *= 2;
                board[i][j] = 0;
            } else {
                if (board[i][top] == 0) board[i][top] = board[i][j];
                else board[i][--top] = board[i][j];

                if (top != j) board[i][j] = 0;
            }
        }
    }
}