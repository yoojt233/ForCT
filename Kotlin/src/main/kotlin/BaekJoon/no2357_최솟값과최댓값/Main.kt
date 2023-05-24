package BaekJoon.no2357_최솟값과최댓값

import kotlin.math.*;

var size = 1;

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };

    while (size < n) size = size shl 1;
    val seg = Array(2) { IntArray(size shl 1) };
    repeat(n) {
        val temp = readLine().toInt()
        seg[0][size + it] = temp;
        seg[1][size + it] = temp;
    }
    setSeg(seg);

    val sb = StringBuilder();
    repeat(m) {
        val (op, ed) = readLine().split(" ").map { it.toInt() - 1 };
        val res = find(seg, op, ed);
        sb.append("${res.first} ${res.second}\n");
    }
    print(sb);
}

fun setSeg(seg: Array<IntArray>) {
    for (i in size - 1 downTo 1) {
        seg[0][i] = min(seg[0][i * 2], seg[0][i * 2 + 1]);
        seg[1][i] = max(seg[1][i * 2], seg[1][i * 2 + 1]);
    }
}

fun find(seg: Array<IntArray>, op: Int, ed: Int): Pair<Int, Int> {
    var left = op + size;
    var right = ed + size;

    var minimum = Int.MAX_VALUE;
    var maximum = Int.MIN_VALUE;

    while (left < right) {
        if (left and 1 != 0) {
            minimum = min(minimum, seg[0][left]);
            maximum = max(maximum, seg[1][left++]);
        }

        if (right and 1 == 0) {
            minimum = min(minimum, seg[0][right]);
            maximum = max(maximum, seg[1][right--]);
        }

        left = left shr 1;
        right = right shr 1;
    }

    if (left == right) {
        minimum = min(minimum, seg[0][left]);
        maximum = max(maximum, seg[1][right]);
    }

    return Pair(minimum, maximum);
}
