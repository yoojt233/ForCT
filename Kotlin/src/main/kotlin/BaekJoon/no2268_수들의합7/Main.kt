package BaekJoon.no2268_수들의합7

import kotlin.math.max
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };

    var size = 1;
    while (size < n) size = size shl 1;
    val seg = LongArray(size shl 1);

    val sb = StringBuilder();
    repeat(m) {
        val temp = readLine().split(" ").map { it.toInt() };
        if (temp[0] == 0) {
            val left = temp[1] - 1;
            val right = temp[2] - 1;
            sb.append("${getSum(seg, 0, n - 1, min(left, right), max(left, right), 1)}\n")
        } else update(seg, 0, n - 1, 1, temp[1] - 1, temp[2]);
    }
    print(sb);
}

fun getSum(seg: LongArray, op: Int, ed: Int, left: Int, right: Int, cur: Int): Long {
    return if (left > ed || right < op) 0;
    else if (left <= op && right >= ed) seg[cur];
    else {
        val mid = (op + ed) / 2;
        getSum(seg, op, mid, left, right, cur * 2) + getSum(seg, mid + 1, ed, left, right, cur * 2 + 1);
    }
}

fun update(seg: LongArray, op: Int, ed: Int, cur: Int, target: Int, cost: Int) {
    if (target < op || target > ed) return;
    if (op == ed) {
        seg[cur] = cost.toLong();
        return;
    }
    val mid = (op + ed) / 2;
    update(seg, op, mid, cur * 2, target, cost);
    update(seg, mid + 1, ed, cur * 2 + 1, target, cost);
    seg[cur] = seg[cur * 2] + seg[cur * 2 + 1];
}