package BaekJoon.no10655_마라톤1

import kotlin.math.*

data class Pos(var r: Int, var c: Int);

lateinit var points: Array<Pos>;

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    points = Array(n) { Pos(0, 0) };

    var total = 0;
    repeat(n) { i ->
        val (r, c) = readLine().split(" ").map { it.toInt() };
        points[i].r = r;
        points[i].c = c;

        if (i > 0) total += dist(i - 1, i);
    }

    var ans = Int.MAX_VALUE;
    for (i in 1 until n - 1) {
        val temp = total - dist(i - 1, i) - dist(i, i + 1) + dist(i - 1, i + 1);
        ans = min(ans, temp);
    }
    print(ans);
}

fun dist(op: Int, ed: Int): Int {
    return abs(points[op].r - points[ed].r) + abs(points[op].c - points[ed].c);
}