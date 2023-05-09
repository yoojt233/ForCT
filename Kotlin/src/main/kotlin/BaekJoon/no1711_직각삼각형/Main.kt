package BaekJoon.no1711_직각삼각형

import kotlin.math.abs;

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val points = Array<Point?>(n) { null };

    repeat(n) { i ->
        val temp = readLine().split(" ").map { it.toLong() };
        points[i] = Point(temp[0], temp[1]);
    }

    var ans = 0;
    val lens = LongArray(3);
    for (i in 0 until n - 2) {
        for (j in i + 1 until n - 1) {
            for (k in j + 1 until n) {
                lens[0] = points[i]!!.length(points[j]!!);
                lens[1] = points[i]!!.length(points[k]!!);
                lens[2] = points[j]!!.length(points[k]!!);

                if (lens[0] + lens[1] == lens[2] || lens[1] + lens[2] == lens[0] || lens[0] + lens[2] == lens[1]) ++ans;
            }
        }
    }
    print(ans);
}

data class Point(val x: Long, val y: Long) {
    fun length(other: Point): Long {
        val row = abs(x - other.x);
        val col = abs(y - other.y);
        return row * row + col * col;
    }
}