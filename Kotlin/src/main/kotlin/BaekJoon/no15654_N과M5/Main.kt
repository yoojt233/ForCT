package BaekJoon.no15654_N과M5

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };
    val numbers = readLine().split(" ").map { it.toInt() }.sorted();
    val sb = StringBuilder();

    val res = IntArray(m);
    val visited = BooleanArray(n);
    fun combo(depth: Int) {
        if (depth == m) {
            res.forEach { sb.append(it).append(" ") };
            sb.append("\n");
            return;
        }

        for (i in numbers.indices) {
            if (visited[i]) continue;

            visited[i] = true;
            res[depth] = numbers[i];
            combo(depth + 1);
            visited[i] = false;
        }
    }
    combo(0);
    print(sb);
}