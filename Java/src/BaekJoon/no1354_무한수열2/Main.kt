package BaekJoon.no1354_무한수열2

fun main() = with(System.`in`.bufferedReader()) {
    val (n, p, q, x, y) = readLine().split(" ").map { it.toLong() }
    val map = HashMap<Long, Long>();

    fun solve(n: Long): Long {
        if (n <= 0) return 1;
        if (!map.containsKey(n)) map[n] = solve(n / p - x) + solve(n / q - y);
        return map[n]!!;
    }
    print(solve(n));
}