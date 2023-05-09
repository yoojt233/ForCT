package BaekJoon.no11660_구간합구하기5

lateinit var dp: Array<IntArray>;

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };
    dp = Array(n) { IntArray(n + 1) };
    repeat(n) { row ->
        val temp = readLine().split(" ").map { it.toInt() };
        for (i in temp.indices) {
            dp[row][i + 1] = if (i == 0) temp[i] else temp[i] + dp[row][i];
        }
    }

    fun sums(x1: Int, y1: Int, x2: Int, y2: Int): Int {
        var sum = 0;
        for (r in x1..x2) {
            sum += (dp[r][y2 + 1] - dp[r][y1]);
        }
        return sum;
    }

    val sb = StringBuilder();
    repeat(m) {
        val (x1, y1, x2, y2) = readLine().split(" ").map { it.toInt() - 1 };
        sb.append("${sums(x1, y1, x2, y2)}\n");
    }
    print(sb);
}
