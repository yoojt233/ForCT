package BaekJoon.no15591_MooTubeSilver

import java.util.*

lateinit var graph: Array<ArrayList<Pair<Int, Int>>>;

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };

    graph = Array(n + 1) { ArrayList() };
    repeat(n - 1) {
        val (op, ed, cost) = readLine().split(" ").map { it.toInt() };
        graph[op].add(Pair(ed, cost));
        graph[ed].add(Pair(op, cost));
    }

    val sb = StringBuilder();
    repeat(m) {
        val (k, op) = readLine().split(" ").map { it.toInt() };
        sb.append("${bfs(n, k, op)}\n");
    }
    print(sb);
}

fun bfs(n: Int, k: Int, op: Int): Int {
    val visited = BooleanArray(n + 1);
    visited[op] = true;

    var ans = 0;
    val q = LinkedList<Pair<Int, Int>>();
    q.add(Pair(op, 0));

    while (q.isNotEmpty()) {
        val cur = q.poll();

        for (next in graph[cur.first]) {
            if (visited[next.first] || next.second < k) continue;
            visited[next.first] = true;
            ++ans;
            q.add(next);
        }
    }
    return ans;
}