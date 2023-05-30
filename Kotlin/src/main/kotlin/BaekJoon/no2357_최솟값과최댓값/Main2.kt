package BaekJoon.no2357_최솟값과최댓값

import kotlin.math.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };

    val origin = IntArray(n);
    repeat(n) {
        origin[it] = readLine().toInt();
    }

    var size = 1;
    while (size < n) size = size shl 1;
    val seg = Array(size shl 1) { IntArray(2) };
    init(seg, origin, 0, n - 1, 1)

    val sb = StringBuilder();
    repeat(m) {
        val (op, ed) = readLine().split(" ").map { it.toInt() - 1 }
        val temp = find(seg, 0, n - 1, op, ed, 1);
        sb.append("${temp[0]} ${temp[1]}\n");
    }
    print(sb);
}

fun init(seg: Array<IntArray>, origin: IntArray, op: Int, ed: Int, cur: Int): IntArray {
    if (op == ed) {
        seg[cur][0] = origin[op];
        seg[cur][1] = origin[op];
    } else {
        val mid = (op + ed) / 2;
        val x = init(seg, origin, op, mid, cur * 2);
        val y = init(seg, origin, mid + 1, ed, cur * 2 + 1);
        seg[cur][0] = min(x[0], y[0]);
        seg[cur][1] = max(x[1], y[1]);
    }

    return seg[cur];
}

fun find(seg: Array<IntArray>, op: Int, ed: Int, left: Int, right: Int, cur: Int): IntArray {
    return if (left > ed || right < op) intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE);
    else if (left <= op && right >= ed) seg[cur];
    else {
        val mid = (op + ed) / 2;
        val x = find(seg, op, mid, left, right, cur * 2);
        val y = find(seg, mid + 1, ed, left, right, cur * 2 + 1);
        intArrayOf(min(x[0], y[0]), max(x[1], y[1]));
    }
}