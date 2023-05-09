package BaekJoon.no2644_촌수계산

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val (a, b) = readLine().split(" ").map { it.toInt() - 1 };
    val x = readLine().toInt();

    val graph = Array(n) { ArrayList<Int>() }

    var ans = -1;
    repeat(x) {
        val (p, c) = readLine().split(" ").map { it.toInt() - 1 };
        graph[p].add(c);
        graph[c].add(p);
    }

    val visited = BooleanArray(n);
    fun dfs(op: Int, ed: Int, cnt: Int) {
        visited[op] = true;
        for (i in graph[op]) {
            if (visited[i]) continue;
            if (i == ed) {
                ans = cnt + 1;
                return;
            }
            dfs(i, ed, cnt + 1);
        }
    }

    dfs(a, b, 0);
    print(ans);
}