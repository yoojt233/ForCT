package BaekJoon.no1246_온라인판매

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val prices = IntArray(m) { readLine().toInt() }.sorted()
    var ans = Pair(0, 0)

    for (i in prices.indices) {
        val total = prices[i] * if (m - i <= n) m - i else n

        if (total > ans.second) ans = Pair(prices[i], total)
    }

    print("${ans.first} ${ans.second}")
}
