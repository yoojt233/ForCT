package BaekJoon.no32770_집가고싶다

import java.util.PriorityQueue
import kotlin.math.min

data class Pass(val to: Int, val cost: Long, val flag: Int) : Comparable<Pass> {
    override fun compareTo(other: Pass): Int {
        return if (cost - other.cost > 0) 1 else -1
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val matchers = HashMap<String, Int>()
    val graph = HashMap<Int, HashMap<Int, Int>>()

    var idx = 0

    repeat(n) {
        val (a, b, cost) = readLine().split(" ")

        if (!matchers.containsKey(a)) matchers[a] = idx++
        if (!matchers.containsKey(b)) matchers[b] = idx++

        val op = matchers[a]!!
        val ed = matchers[b]!!

        if (!graph.containsKey(op)) graph[op] = hashMapOf(ed to cost.toInt())
        else graph[op]!![ed] = min(graph[op]!!.getOrDefault(ed, Int.MAX_VALUE), cost.toInt())
    }

    print(dijk(graph, idx, matchers["sasa"]!!, matchers["home"]!!))
}

fun dijk(graph: HashMap<Int, HashMap<Int, Int>>, limit: Int, p1: Int, p2: Int): Long {
    val dist = Array(2) { LongArray(limit) { -1 } }
    val pq = PriorityQueue<Pass>()

    pq.add(Pass(p1, 0, 0))
    pq.add(Pass(p2, 0, 1))

    dist[0][p1] = 0
    dist[1][p2] = 0

    while (pq.isNotEmpty()) {
        val cur = pq.poll()
        if (dist[cur.flag][cur.to] != -1L && dist[cur.flag][cur.to] < cur.cost) continue

        val nexts = graph[cur.to] ?: HashMap()

        for (next in nexts.keys) {
            if (dist[cur.flag][next] == -1L || cur.cost + nexts[next]!! < dist[cur.flag][next]) {
                dist[cur.flag][next] = cur.cost + nexts[next]!!

                if ((cur.flag == 0 && next == p2) || (cur.flag == 1 && next == p1)) continue
                pq.add(Pass(next, dist[cur.flag][next], cur.flag))
            }
        }
    }

    return if (dist[0][p2] == -1L || dist[1][p1] == -1L) -1 else dist[0][p2] + dist[1][p1]
}
