package BaekJoon.no12865_평범한배낭

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };
    val items = Array<Item>(n + 1) { Item(0, 0) };
    for (i in 1..n) {
        val temp = readLine().split(" ").map { it.toInt() };
        items[i] = Item(temp[0], temp[1]);
    }

    val dp = IntArray(m + 1);
    for (i in 1..n) {
        for (j in m downTo items[i].w) {
            dp[j] = max(dp[j], dp[j - items[i].w] + items[i].v);
        }
    }
    print(dp[m]);
}

data class Item(
    val w: Int,
    val v: Int
)