package BaekJoon.no1205_등수구하기

fun main() = with(System.`in`.bufferedReader()) {
    val (n, score, max) = readLine().split(" ").map { it.toInt() };

    var ans = 1;
    if (n > 0) {
        val ranking = readLine().split(" ").map { it.toInt() };
        val rank = ranking.count { it > score } + 1;
        val cnt = ranking.count { it >= score };

        ans = if (cnt + 1 > max) -1 else rank;
    }
    println(ans);
}