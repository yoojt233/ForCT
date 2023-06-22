package BaekJoon.no2210_숫자판점프

fun main() = with(System.`in`.bufferedReader()) {
    val board = Array(5) { IntArray(5) }
    for (i in 0 until 5) {
        val temp = readLine().split(" ");
        for (j in 0 until 5) board[i][j] = temp[j].toInt();
    }

    val dx = intArrayOf(-1, 1, 0, 0);
    val dy = intArrayOf(0, 0, -1, 1);
    val set = HashSet<Int>();

    fun dfs(r: Int, c: Int, level: Int, num: Int) {
        if (level == 5) {
            set.add(num);
            return;
        }

        for (d in 0 until 4) {
            val nr = r + dx[d];
            val nc = c + dy[d];

            if (nr !in 0 until 5 || nc !in 0 until 5) continue;
            dfs(nr, nc, level + 1, num * 10 + board[nr][nc]);
        }
    }

    for (i in 0 until 5) {
        for (j in 0 until 5) dfs(i, j, 0, board[i][j]);
    }

    print(set.size);
}
