package BaekJoon.no15649_N과M1

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };
    val sb = StringBuilder();

    val visited = BooleanArray(n);
    val chosen = IntArray(m);

    fun permu(depth: Int) {
        if (depth == m) {
            chosen.forEach { sb.append("$it ") };
            sb.append("\n");
            return;
        }

        for (i in 0 until n) {
            if (visited[i]) continue;
            chosen[depth] = i + 1;
            visited[i] = true;
            permu(depth + 1);
            visited[i] = false;
        }
    }
    permu(0);
    print(sb);
}