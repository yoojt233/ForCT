package BaekJoon.no11779_최소비용구하기2

import java.util.PriorityQueue
import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val m = readLine().toInt();

    val edges = Array(n) { ArrayList<Pair<Int, Int>>() };
    repeat(m) {
        val (from, to, cost) = readLine().split(" ").map { it.toInt() };
        edges[from - 1].add(Pair(to - 1, cost))
    }

    var (op, ed) = readLine().split(" ").map { it.toInt() - 1 };
    val pq = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second };
    pq.add(Pair(op, 0))

    val dist = IntArray(n) { Int.MAX_VALUE };
    val path = IntArray(n) { -1 };
    dist[op] = 0;
    path[op] = 0;

    while (pq.isNotEmpty()) {
        val cur = pq.poll();

        if (cur.second > dist[ed]) break;
        for (next in edges[cur.first]) {
            if (dist[next.first] <= cur.second + next.second) continue;

            dist[next.first] = cur.second + next.second;
            pq.add(Pair(next.first, dist[next.first]));
            path[next.first] = cur.first;
        }
    }
    val sb = StringBuilder();
    sb.append("${dist[ed]}\n")

    val paths = Stack<Int>();
    while (true) {
        paths.add(ed);
        ed = path[ed];
        if (op == ed) {
            paths.add(ed);
            break;
        }
    }


    sb.append("${paths.size}\n");
    while (paths.isNotEmpty()) sb.append("${paths.pop() + 1} ");
    print(sb);
}
