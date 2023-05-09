package BaekJoon.no15663_N과M9

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };
    val nums = readLine().split(" ").map { it.toInt() }.sorted();

    val sb = StringBuilder();
    val chosen = IntArray(m);
    val visited = BooleanArray(n);
    val exist = HashSet<String>();
    fun solve(depth: Int) {
        if (depth == m) {
            if (!check(exist, chosen)) {
                chosen.forEach { sb.append("$it ") };
                sb.append("\n");
            }
            return;
        }

        for (i in nums.indices) {
            if (visited[i]) continue;

            visited[i] = true;
            chosen[depth] = nums[i];
            solve(depth + 1);
            visited[i] = false;
        }
    }
    solve(0);
    print(sb);
}

fun check(exist: HashSet<String>, chosen: IntArray): Boolean {
    val temp = StringBuilder();
    chosen.forEach { temp.append("$it.") };

    if (exist.contains(temp.toString())) return true;
    exist.add(temp.toString());
    return false;
}
