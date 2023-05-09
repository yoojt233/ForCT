package BaekJoon.no12865_평범한배낭

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };

    val input = Array<Product>(n) { Product(0, 0) };
    repeat(n) { i ->
        val temp = readLine().split(" ").map { it.toInt() };
        input[i] = Product(temp[0], temp[1]);
    }

    val dp = Array(n + 1) { IntArray(m + 1) }
    for (i in 1..n) {
        for (j in 1..m) {
            dp[i][j] =
                if (input[i - 1].w > j) dp[i - 1][j];
                else max(dp[i - 1][j], dp[i - 1][j - input[i - 1].w] + input[i - 1].v);
        }
    }

    print(dp[n][m]);
}

data class Product(
    var w: Int,
    var v: Int
)