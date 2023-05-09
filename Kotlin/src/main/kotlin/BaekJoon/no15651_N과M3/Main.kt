package BaekJoon.no15651_N과M3

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };
    val sb = StringBuilder();

    val chosen = IntArray(m);
    fun permu(depth: Int) {
        if (depth == m) {
            chosen.forEach { sb.append("$it ") };
            sb.append("\n");
            return;
        }

        for (i in 1..n) {
            chosen[depth] = i;
            permu(depth + 1);
        }
    }
    permu(0);
    print(sb);
}