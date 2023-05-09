package BaekJoon.no11497_통나무건너뛰기

import kotlin.math.max;

fun main() = with(System.`in`.bufferedReader()) {
    val tc = readLine().toInt();
    val sb = StringBuilder();

    repeat(tc) {
        val n = readLine().toInt();
        val log = readLine().split(" ").map { it.toInt() }.sorted();

        var diff = 0;
        repeat(n - 2) {
            diff = max(diff, log[it + 2] - log[it]);
        }
        sb.append("${max(diff, log[1] - log[0])}\n");
    }

    print(sb);
}