package BaekJoon.no15665_N과M11

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };
    val nums = readLine().split(" ").map { it.toInt() }.sorted();

    val sb = StringBuilder();
    val chosen = IntArray(m);

    fun solve(depth: Int) {
        if (depth == m) {
            chosen.forEach { sb.append("$it ") };
            sb.appendLine();
            return;
        }

        var pre = 0;
        for (i in nums) {
            if (i == pre) continue;
            chosen[depth] = i;
            solve(depth + 1);
            pre = i;
        }
    }

    solve(0);
    print(sb);
}