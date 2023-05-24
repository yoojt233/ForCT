package BaekJoon.no2042_구간합구하기

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M, K) = readLine().split(" ").map { it.toInt() };

    val input = LongArray(N);
    repeat(N) {
        input[it] = readLine().toLong();
    }
    var n = 1;
    while (n < N) n = n shl 1;

    val seg = LongArray(n shl 1);
    init(seg, input, 0, N - 1, 1);

    val sb = StringBuilder();
    repeat(M + K) {
        val temp = readLine().split(" ");
        if (temp[0].toInt() == 1) {
            val target = temp[1].toInt() - 1;
            val diff = temp[2].toLong() - input[target];
            input[target] += diff;
            update(seg, 0, N - 1, 1, target, diff);
        } else sb.append("${getSum(seg, 0, N - 1, temp[1].toInt() - 1, temp[2].toInt() - 1, 1)}\n");
    }
    print(sb);
}

fun init(seg: LongArray, input: LongArray, op: Int, ed: Int, cur: Int): Long {
    seg[cur] =
        if (op == ed) input[op];
        else {
            val mid = (op + ed) / 2;
            init(seg, input, op, mid, cur * 2) + init(seg, input, mid + 1, ed, cur * 2 + 1);
        }
    return seg[cur];
}

fun getSum(seg: LongArray, op: Int, ed: Int, left: Int, right: Int, cur: Int): Long {
    return if (left > ed || right < op) 0;
    else if (left <= op && right >= ed) seg[cur];
    else {
        val mid = (op + ed) / 2;
        getSum(seg, op, mid, left, right, cur * 2) + getSum(seg, mid + 1, ed, left, right, cur * 2 + 1);
    }
}

fun update(seg: LongArray, op: Int, ed: Int, cur: Int, target: Int, diff: Long) {
    if (target < op || target > ed) return;
    seg[cur] += diff;
    if (op != ed) {
        val mid = (op + ed) / 2;
        update(seg, op, mid, cur * 2, target, diff);
        update(seg, mid + 1, ed, cur * 2 + 1, target, diff);
    }
}