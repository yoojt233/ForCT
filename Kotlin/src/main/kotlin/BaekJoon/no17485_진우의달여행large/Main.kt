package BaekJoon.no17485_진우의달여행large

fun main() = with(System.`in`.bufferedReader()) {
    val (r, c) = readLine().split(" ").map { it.toInt() };
    val board = Array(r) { IntArray(c) { 0 } };

    for (i in board.indices) {
        board[i] = readLine().split(" ").map { it.toInt() }.toIntArray();
    }

    val dp = Array(3) { Array(r) { Array(c + 2) { 100000000 } } };
    repeat(c) {
        for (i in 0 until 3) {
            dp[i][0][it + 1] = board[0][it];
        }
    }

    for (i in 1 until r) {
        for (j in 1 until c + 1) {
            var cur = board[i][j - 1];

            dp[0][i][j] = cur + dp[1][i - 1][j - 1].coerceAtMost(dp[2][i - 1][j - 1]);
            dp[1][i][j] = cur + dp[0][i - 1][j].coerceAtMost(dp[2][i - 1][j]);
            dp[2][i][j] = cur + dp[0][i - 1][j + 1].coerceAtMost(dp[1][i - 1][j + 1]);
        }
    }

    var ans = Int.MAX_VALUE;
    for (res in dp) {
        for (i in 1 until c + 1)
            ans = ans.coerceAtMost(res[r - 1][i]);
    }

    print(ans);
}

