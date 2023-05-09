package BaekJoon.no15663_N과M9

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };
    val nums = readLine().split(" ").map { it.toInt() }.sorted();

    val sb = StringBuilder();
    val chosen = IntArray(m);
    val visited = BooleanArray(n);

    fun solve(depth: Int) {
        if (depth == m) {
            chosen.forEach { sb.append("$it ") };
            sb.append("\n");
            return;
        }

        var pre = 0;
        for (i in nums.indices) {
            if (visited[i] || pre == nums[i]) continue;

            visited[i] = true;
            chosen[depth] = nums[i];
            solve(depth + 1);
            visited[i] = false;
            pre = nums[i];
        }
    }
    solve(0);
    print(sb);
}