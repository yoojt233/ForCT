package BaekJoon.no15650_N과M2

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };
    val number = IntArray(n) { it + 1 };

    val sb = StringBuilder();
    fun permu(cur: Int, x: Int, arr: IntArray, sb: StringBuilder) {
        if (x == m) {
            arr.forEach { sb.append("$it ") };
            sb.append("\n");
            return;
        }

        for (i in cur until n) {
            arr[x] = number[i];
            permu(i + 1, x + 1, arr, sb);
        }
    }

    permu(0, 0, IntArray(m), sb);
    print(sb);
}

