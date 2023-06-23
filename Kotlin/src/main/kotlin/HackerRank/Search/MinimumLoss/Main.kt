package HackerRank.Search.MinimumLoss

fun minimumLoss(price: Array<Long>, n: Int): Int {
    val map = HashMap<Long, Int>();
    for (i in price.indices) map[price[i]] = i;

    price.sort();
    var ans = Long.MAX_VALUE;
    for (i in 0 until n - 1) {
        val buy = price[i + 1];
        val sell = price[i];

        if (buy > sell && map[buy]!! < map[sell]!!) {
            ans = ans.coerceAtMost(buy - sell);
        }
    }
    return ans.toInt();
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val price = readLine()!!.trimEnd().split(" ").map { it.toLong() }.toTypedArray()

    val result = minimumLoss(price, n)

    println(result)
}