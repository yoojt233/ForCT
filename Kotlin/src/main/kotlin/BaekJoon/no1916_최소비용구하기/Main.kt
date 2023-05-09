package BaekJoon.no1916_최소비용구하기

import java.util.PriorityQueue

data class Bus(val to: Int, val cost: Int) : Comparable<Bus> {
    override fun compareTo(other: Bus): Int {
        return cost - other.cost;
    }
}

lateinit var graph: Array<ArrayList<Bus>>;

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    graph = Array(n) { ArrayList() };

    repeat(readLine().toInt()) {
        val input = readLine().split(" ").map { it.toInt() };
        graph[input[0] - 1].add(Bus(input[1] - 1, input[2]));
    }

    val want = readLine().split(" ").map { it.toInt() - 1 };
    print(dijkstra(want[0], want[1], n));
}

fun dijkstra(op: Int, ed: Int, n: Int): Int {
    val dist = IntArray(n) { Int.MAX_VALUE };
    dist[op] = 0;

    val pq = PriorityQueue<Bus>();
    pq.add(Bus(op, 0));

    while (pq.isNotEmpty()) {
        val cur = pq.poll();

        if (cur.cost > dist[cur.to]) continue;
        for (next in graph[cur.to]) {
            if (dist[next.to] > dist[cur.to] + next.cost) {
                dist[next.to] = dist[cur.to] + next.cost;
                pq.add(next);
            }
        }
    }
    return dist[ed];
}
