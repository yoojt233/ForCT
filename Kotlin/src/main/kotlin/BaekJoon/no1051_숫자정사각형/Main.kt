package BaekJoon.no1051_숫자정사각형

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) { readLine().toCharArray().map { it.digitToInt() }.toIntArray() }

    var x = 1

    for (r in 0 until n - 1) {
        for (c in 0 until m - 1) {
            val num = board[r][c]

            var temp = x

            while (r + temp < n && c + temp < m) {
                if (board[r][c + temp] == num && board[r + temp][c] == num && board[r + temp][c + temp] == num) x =
                    temp + 1
                ++temp
            }
        }
    }

    print(x * x)
}
