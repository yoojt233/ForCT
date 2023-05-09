package BaekJoon.no10830_행렬제곱

import java.util.StringTokenizer

val dp = HashMap<Long, Array<IntArray>>();

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine());
    val n = st.nextToken().toInt();
    val m = st.nextToken().toLong();
    val arr = Array(n) { IntArray(2) };

    dp[1] = arr;

    repeat(n) { i ->
        arr[i] = readLine().split(" ").map { it.toInt() }.toIntArray();
    }

    val ans = divide(arr, n, m);
    val sb = StringBuilder();
    repeat(n) { i ->
        ans[i].forEach { sb.append("${it % 1000} ") }
        sb.append("\n");
    }
    print(sb);
}

fun divide(arr: Array<IntArray>, n: Int, x: Long): Array<IntArray> {
    return if (dp.containsKey(x)) dp[x]!!;
    else {
        val half = x / 2;
        dp[x] = conquer(divide(arr, n, half), divide(arr, n, x - half), n);
        dp[x]!!;
    }
}

fun conquer(a: Array<IntArray>, b: Array<IntArray>, n: Int): Array<IntArray> {
    val res = Array(n) { IntArray(n) };

    fun calc(i: Int, j: Int): Int {
        var sum = 0;
        repeat(n) {
            sum = (sum + (a[i][it] * b[it][j]) % 1000) % 1000;
        }
        return sum;
    }

    repeat(n) { i ->
        repeat(n) { j ->
            res[i][j] = calc(i, j);
        }
    }
    return res;
}