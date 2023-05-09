package BaekJoon.no1238_파티

import java.util.PriorityQueue
import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, x) = readLine().split(" ").map { it.toInt() };

    val go = Array(n + 1) { ArrayList<Road>() };
    val back = Array(n + 1) { ArrayList<Road>() };
    repeat(m) {
        val (from, to, cost) = readLine().split(" ").map { it.toInt() };
        go[from].add(Road(to, cost));
        back[to].add(Road(from, cost));
    }

    val goCosts = dijkstra(n, x, go);
    val backCosts = dijkstra(n, x, back);

//    var ans = 0;
//    for (i in 1..n) {
//        ans = max(ans, goCosts[i] + backCosts[i]);
//    }
//    print(ans);
    print(goCosts.zip(backCosts).maxOf { it.first + it.second });
}

fun dijkstra(n: Int, op: Int, arr: Array<ArrayList<Road>>): IntArray {
    val costs = IntArray(n + 1) { Int.MAX_VALUE };
    costs[op] = 0;
    val visited = BooleanArray(n + 1);

    val pq = PriorityQueue<Road>();
    pq.add(Road(op, 0));

    while (pq.isNotEmpty()) {
        val cur = pq.poll();
        if (visited[cur.to]) continue;

        visited[cur.to] = true;
        for (next in arr[cur.to]) {
            if (!visited[next.to] && costs[next.to] > costs[cur.to] + next.cost) {
                costs[next.to] = costs[cur.to] + next.cost;
                pq.add(Road(next.to, costs[next.to]));
            }
        }
    }
    return costs;
}

data class Road(val to: Int, val cost: Int) : Comparable<Road> {
    override fun compareTo(other: Road): Int {
        return cost - other.cost;
    }
}