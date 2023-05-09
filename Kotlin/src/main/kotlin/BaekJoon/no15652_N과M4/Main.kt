package BaekJoon.no15652_N과M4

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };
    val sb = StringBuilder();

    val chosen = IntArray(m);
    fun combo(depth: Int, op: Int) {
        if (depth == m) {
            chosen.forEach { sb.append("$it ") };
            sb.append("\n");
            return;
        }

        for (i in op until n) {
            chosen[depth] = i + 1;
            combo(depth + 1, i);
        }
    }

    combo(0, 0);
    print(sb);
}