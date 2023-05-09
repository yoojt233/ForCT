package BaekJoon.no9466_텀프로젝트

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt();
    val sb = StringBuilder();
    repeat(t) {
        val n = readLine().toInt();
        val input = readLine().split(" ").map { it.toInt() - 1 };

        var cnt = 0;
        val visited = BooleanArray(n);
        val check = BooleanArray(n);

        fun dfs(idx: Int) {
            var next = input[idx];
            if (!visited[idx]) {
                visited[idx] = true;
                dfs(next);
                check[idx] = true;
                return;
            }

            if (check[idx]) return;
            while (idx != next) {
                ++cnt;
                next = input[next];
            }
            ++cnt;
        }

        for (i in 0 until n) {
            if (!visited[i]) dfs(i);
        }
        sb.append("${n - cnt}\n")
    }
    print(sb);
}
