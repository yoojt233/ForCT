package BaekJoon.no15656_N과M7

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };
    val nums = readLine().split(" ").map { it.toInt() }.sorted();

    val sb = StringBuilder();
    val chosen = IntArray(m);
    fun permu(depth: Int) {
        if (depth == m) {
            chosen.forEach { sb.append("$it ") };
            sb.append("\n");
            return;
        }

        for (i in nums) {
            chosen[depth] = i;
            permu(depth + 1);
        }
    }
    permu(0);
    print(sb);
}