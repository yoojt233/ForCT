package BaekJoon.no11659_구간합구하기4

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder();
    val (n, m) = readLine().split(" ").map { it.toInt() };
    val numbers = readLine().split(" ").map { it.toLong() };
    val sum = arrayListOf<Long>(0);

    for (i in numbers) {
        sum.add(sum.last() + i);
    }

    repeat(m) {
        var (a, b) = readLine().split(" ").map { it.toInt() };
        sb.append(sum[b] - sum[a - 1]).append("\n");
    }
    println(sb);
}