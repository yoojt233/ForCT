package BaekJoon.no15657_N과M8

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };
    val nums = readLine().split(" ").map { it.toInt() }.sorted();

    val sb = StringBuilder();
    val chosen = IntArray(m);
    fun solve(depth: Int, op: Int) {
        if (depth == m) {
            chosen.forEach { sb.append("$it ") };
            sb.append("\n");
            return;
        }

        for (i in op until n) {
            chosen[depth] = nums[i];
            solve(depth + 1, i);
        }
    }
    solve(0, 0);
    print(sb);
}