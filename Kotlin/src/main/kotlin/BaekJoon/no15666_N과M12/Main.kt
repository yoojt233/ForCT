package BaekJoon.no15666_N과M12

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

        var pre = 0;
        for (i in op until n) {
            if (pre == nums[i]) continue;
            chosen[depth] = nums[i];
            solve(depth + 1, i);
            pre = nums[i];
        }
    }
    solve(0, 0);
    print(sb);
}