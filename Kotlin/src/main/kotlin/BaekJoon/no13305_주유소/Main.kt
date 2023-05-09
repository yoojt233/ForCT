package BaekJoon.no13305_주유소

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val dist = readLine().split(" ").map { it.toLong() };
    val oil = readLine().split(" ").map { it.toLong() };

    var least = oil[0];
    var ans = 0L;
    repeat(n - 1) {
        if (oil[it] < least) least = oil[it];
        ans += least * dist[it];
    }
    print(ans);
}